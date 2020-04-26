package leetcode.top.interview.question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Richard_Yi
 * @version 1.0 2020/4/26
 */
public class T78_SubSet {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backTrack(nums, -1, track, result);
        return result;
    }

    private static void backTrack(int[] nums, int start,
                                  List<Integer> track, List<List<Integer>> result) {

        result.add(new ArrayList<>(track));

        for (int i = start + 1; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);

            backTrack(nums, i, track, result);

            // 撤销选择
            track.remove(track.size() - 1);
        }

    }
}
