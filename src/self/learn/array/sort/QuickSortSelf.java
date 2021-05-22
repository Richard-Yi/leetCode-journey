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
        // 两个指针分别是 j 和 i，j 会一直向右顺序遍历，并且这个过程中会一直与 pivot 位置的数比较。
        // 只有当 j 位置的数小于 pivot 位置的数才会发生和 i 位置的交换（也就是swap A[ i ] with A [ j ]），
        // 同时 i 自增一次。直到遍历完成后， i 左边的数就都是小于pivot的，
        // 此时把 i 位置的数和pivot位置的数交换，那么pivot左边就都是比它小的数，而右边就都是比它大的数了,这样我们就成功完成了一个原地排序算法！
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
