package leetcode.top.interview.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Richard_Yi
 * @version 1.0 2020/4/26
 */
public class T39_CombinationSum {

    // 这道题掌握了回溯算法之后，整体的思路非常的清晰

    // 但是就是卡在了重复组合这里，加入start下标解决

    // 注意：这是一组不含重复元素的整数数组 nums

    // 39.组合总和
    // 40. 组合总和 II
    // 46. 全排列
    // 47. 全排列 II
    // 78. 子集
    // 90. 子集 II

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;

        Arrays.sort(candidates);

        System.out.println(combinationSum(candidates, target));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> track = new ArrayList<>();
        backTrack(result, track, candidates, target, 0);

        return result;
    }

    private static void backTrack(List<List<Integer>> result, List<Integer> track,
                                  int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(track));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 选择
            track.add(candidates[i]);

            // backTrack
            backTrack(result, track, candidates, target - candidates[i], i);

            // 撤消
            track.remove(track.size() - 1);
        }
    }
}
