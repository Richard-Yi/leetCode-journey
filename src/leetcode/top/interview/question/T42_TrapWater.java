package leetcode.top.interview.question;

import java.util.Arrays;

/**
 * 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author Richard_Yi
 * @version 1.0 2020/5/7
 */
public class T42_TrapWater {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(nums));
    }

    // TODO 其他解法

    // 韦恩图解法

    private static int trap(int[] height) {

        int n = height.length;

        int s1 = 0;
        int s2 = 0;
        int maxLeft = 0, maxRight = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > maxLeft) {
                maxLeft = height[i];
            }
            if (height[n - i - 1] > maxRight) {
                maxRight = height[n - i - 1];
            }
            s1 += maxLeft;
            s2 += maxRight;
            sum += height[i];
        }
        return s1 + s2 - maxLeft * n - sum;
    }
}
