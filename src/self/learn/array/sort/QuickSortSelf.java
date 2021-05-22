package self.learn.array.sort;

import java.util.Arrays;

/**
 * @author Richard_yyf
 * @version 1.0 2021/5/22
 */
public class QuickSortSelf {


    public static void main(String[] args) {
        int[] nums = {4, 1, 6, 3, 2, 5};
        new QuickSortSelf().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 快速排序

    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        int q = partition(nums, left, right);
        quickSort(nums, left, q - 1);
        quickSort(nums, q + 1, right);
    }


    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];

        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                if (i != j) {
                    swap(nums, i, j);
                }
                i++;
            }
        }

        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }


}
