package leetcode.top.interview.question;

import java.util.Arrays;

/**
 * @author Richard_Yi
 * @version 1.0 2020/5/7
 */
public class T34_SearchRange {


    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }

    private static int[] searchRange(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        int[] res = {-1, -1};

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                // target in [left, mid - 1]
                right = mid - 1;
            } else if (nums[mid] == target) {

                res[0] = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                // target in [mid + 1, right]
                left = mid + 1;
            }
        }

        right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                // target in [left, mid - 1]
                right = mid - 1;
            } else if (nums[mid] == target) {

                res[1] = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                // target in [mid + 1, right]
                left = mid + 1;
            }
        }

        return res;
    }
}
