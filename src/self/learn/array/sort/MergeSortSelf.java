package self.learn.array.sort;

import java.util.Arrays;

/**
 * 自己写的mergeSort
 * @author Richard_yyf
 * @version 1.0 2021/5/22
 */
public class MergeSortSelf {

    public static void main(String[] args) {
        int[] nums = {4, 1, 6, 3, 2, 5};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    // 归并排序

    public static void mergeSort(int[] nums, int start, int end) {

        if (start == end) {
            return;
        }

        int mid = (end + start) / 2;
        // 排序 [start, mid] [mid + 1, end]
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        // 合并 [start, mid] 和 [mid + 1, end]
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        // [start, mid] 和 [mid + 1, end]

        int[] temp = new int[end - start + 1];

        int i = start;
        int j = mid + 1;
        int k = 0;
        // 比较排序
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }

        // 如果 [start, mid] 没走完
        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        // 如果 [mid + 1, end] 没走完
        while (j <= end) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        // 赋值回去
        for (int p = 0; p < temp.length; p++) {
            nums[start + p] = temp[p];
        }
    }
}
