package leetcode.top.interview.question;

import java.util.Arrays;

/**
 * 下一个排列：https://leetcode-cn.com/problems/next-permutation/
 *
 * @author Richard_Yi
 * @version 1.0 2020/5/6
 */
public class T31_NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 1, 5};
//        Arrays.sort(nums, 1, 3);
//        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 后面的大数和前面的小数交换
    // 1. 从后向前找第一个减小的数
    // 2. 从那个高位小数后面开始找最接近它且大于它的数
    // 3. 两者交换位置，并且将大数后面的数升序排列

    private static void nextPermutation(int[] nums) {

        if (nums.length <= 1) {
            return;
        }

        int p = nums.length - 2;
        int n1 = -1;

        while (p >= 0) {
            if (nums[p] < nums[p + 1]) {
                n1 = p;
                break;
            }
            p--;
        }

        if (n1 == -1) {
            Arrays.sort(nums);
            return;
        }

        // 此时 p指在了 n1的位置上
        int higher = -1;
        int n2 = -1;
        p++;
        while (p < nums.length) {
            if (higher == -1 || (nums[p] > nums[n1] && higher > nums[p])) {
                higher = nums[p];
                n2 = p;
            }
            p++;
        }

        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;

        Arrays.sort(nums, n1 + 1, nums.length);
    }
}
