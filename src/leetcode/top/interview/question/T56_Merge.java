package leetcode.top.interview.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/**
 * @author Richard_yyf
 * @version 1.0 2020/6/6
 */
public class T56_Merge {

    public static void main(String[] args) {

    }

    //  [[1,3],[2,6],[8,10],[15,18]]

    static int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return intervals;
        }
        int[][] res = new int[intervals.length][2];
        // 排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int size = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (size == -1) {
                size++;
                res[size][0] = intervals[i][0];
                res[size][1] = intervals[i][1];
                continue;
            }

            int left = intervals[i][0], right = intervals[i][1];
            // 3 种情况 (排序后，肯定 a > 1)
            // 1. [1, 6] [a, b] a > 6, b > a > 6
            // 2. [1, 6] [a, b] a > 1, b <= 6 合并
            // 3. [1, 6] [a, b] a > 1, b > 6 合并

            if (left <= res[size][1]) {
                // 重叠
                // size 没有变化
                res[size][0] = Math.min(res[size][0], intervals[i][0]);
                res[size][1] = Math.max(res[size][1], intervals[i][1]);
            } else {
                // 新增
                // size ++
                size++;
                res[size][0] = intervals[i][0];
                res[size][1] = intervals[i][1];
            }
        }
        return Arrays.copyOf(res, size + 1);
    }
}
