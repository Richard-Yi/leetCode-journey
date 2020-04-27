package leetcode.top.interview.question;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations/
 *
 * @author Richard_Yi
 * @version 1.0 2020/4/27
 */
public class T46_Permute {

    // 全排列

    // 主要卡在怎么排除candidates上面

    // 再改进，将 Set<Integer> indexUsed = new HashSet<>(); 改成 boolean[] used

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums).toString());
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        // 默认值是false
        boolean[] used = new boolean[nums.length];

        backTrack(path, nums, 0, result, used);

        return result;
    }

    private static void backTrack(List<Integer> path, int[] nums, int depth,
                                  List<List<Integer>> result,
                                  boolean[] used) {

        if (depth == nums.length) {

            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;

            backTrack(path, nums, depth + 1, result, used);

            used[i] = false;
            path.remove(path.size() - 1);
        }

    }
}
