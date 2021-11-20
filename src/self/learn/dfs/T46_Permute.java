package self.learn.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 *
 * @author Richard_Yi
 * @version 1.0 2020/4/27
 */
public class T46_Permute {

    // 全排列

    // 再改进，将 Set<Integer> indexUsed = new HashSet<>(); 改成 boolean[] used

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums).toString());
    }

    public List<List<Integer>> permute2(int[] nums) {

        boolean[] used = new boolean[nums.length];

        List<List<Integer>> result = new ArrayList<>();

        backTrack(new ArrayList<>(), nums, used, result);

        return result;
    }

    private void backTrack(List<Integer> path, int[] nums, boolean[] used, List<List<Integer>> result) {
        if (path == null) {
            path = new ArrayList<>(nums.length);
        }
        // if 满足结束条件
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }
        // for in 选项
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 做选择
            used[i] = true;
            path.add(nums[i]);

            backTrack(path, nums, used, result);
            // 撤销选择
            path.remove(path.size() - 1);
            used[i] = false;
        }
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
