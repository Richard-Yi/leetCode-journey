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
        new T31_NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 后面的大数和前面的小数交换
    // 1. 从后向前找第一个减小的数
    // 2. 从那个高位小数后面开始找最接近它且大于它的数
    // 3. 两者交换位置，并且将大数后面的数升序排列

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }

        int pivot = n - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }

        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        int lg = pivot + 1;
        while (lg < n && nums[lg] > nums[pivot]) {
            lg++;
        }

        swap(nums, pivot, --lg);
        reverse(nums, pivot + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
