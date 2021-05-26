package self.learn.array.sort;

import java.util.Arrays;

/**
 * TODO 这题正确解法是用堆排序
 *
 * @author Richard_yyf
 * @version 1.0 2021/5/25
 */
public class FindKthLargest_215 {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(new FindKthLargest_215().findKthLargest(nums, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length  - k];
    }

    private void sort(int[] nums) {
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
        int j = left;
        while (j < right) {
            if (nums[j] < pivot) {
                if (i != j) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                i++;
            }
            j++;
        }

        nums[right] = nums[i];
        nums[i] = pivot;

        return i;
    }
}
