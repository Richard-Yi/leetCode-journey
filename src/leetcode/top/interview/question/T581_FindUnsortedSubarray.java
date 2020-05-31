package leetcode.top.interview.question;

import java.util.Arrays;

/**
 * @author Richard_yyf
 * @version 1.0 2020/5/31
 */
public class T581_FindUnsortedSubarray {

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
        System.out.println(findUnsortedSubarray2(nums));
    }

    // 这道题的核心是在于
    // 无序子数组中最小元素的正确位置可以决定左边界，
    // 最大元素的正确位置可以决定右边界

    static int findUnsortedSubarray(int[] nums) {
        // [2, 6, 4, 8, 10, 9, 15]
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        int right = 0, left = sortedNums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sortedNums[i]) {
                // 最左边不匹配的
                left = Math.min(left, i);
                // 最右边不匹配的
                right = Math.max(right, i);
            }
        }
        return (right - left >= 0 ? right - left + 1 : 0);
    }

    // 无需额外空间，时间复杂度O(n)

    static int findUnsortedSubarray2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 正序遍历，找出无序子串的min
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                // 出现了下降
                flag = true;
            }
            if (flag) {
                min = Math.min(min, nums[i]);
            }
        }
        // 逆序遍历，找出无序子串的max
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                // 出现了上升
                flag = true;
            }
            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }
        // 找出 min 在有序数组中的位置
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) {
                left = i;
                break;
            }
        }
        int right = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < max) {
                right = i;
                break;
            }
        }
        return (right - left) >= 0 ? (right - left + 1) : 0;
    }
}
