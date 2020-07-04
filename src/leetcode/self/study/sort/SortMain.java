package leetcode.self.study.sort;

import java.util.Arrays;

/**
 * O(n^2) 排序：冒泡、插入、排序   -- 基于比较
 * O(nlog(n)) 排序：快排、归并    -- 基于比较
 * O(n) 排序：桶、计数、基数      -- 不基于比较
 *
 * @author Richard_yyf
 * @version 1.0 2020/6/26
 */
public class SortMain {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 3, 2, 1};
//        bubbleSort(nums);
//        insertionSort(nums);
//        selectionSort(nums);
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 冒泡只会操作相邻的两个数组，每次冒泡至少让一个元素移动到它应该在的地方
     * <p>
     * 1. 原地排序算法
     * 2. 稳定排序算法，当相等是不会交换顺序
     * 3. 时间复杂度 O(n^2)
     *
     * @param nums nums
     */
    private static void bubbleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 提前退出冒泡
            boolean noDataSwap = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    noDataSwap = false;
                }
            }
            if (noDataSwap) {
                break;
            }
        }
    }

    /**
     * 插入排序
     * <p>
     * 插入算法思想
     * 将数组中元素分为两个区间：已排序区间和未排序区间，
     * 初始已排序区间只有1个元素，就是数组的第一个元素。
     * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，
     * 并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为空，算法结束。
     * </p>
     *
     * @param nums nums
     */
    private static void insertionSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                // 已排序部分，从后向前遍历
                if (nums[j] > val) {
                    // 移动
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = val;
        }
    }

    private static void selectionSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    int temp = nums[j];
                    nums[j] = min;
                    min = temp;
                }
            }
            nums[i] = min;
        }
    }

    // ======================  nlog(n)  ===================

    /**
     * 归并排序的核心思想还是蛮简单的。
     * 如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，
     * 再将排好序的两部分合并在一起，这样整个数组就都有序。
     *
     * 分治是一种解决问题的处理思想，递归是一种编程技巧
     *
     * 归并排序不是原地排序算法
     *
     * @param nums nums
     */
    private static void mergeSort(int[] nums) {
        mergeOne(nums, 0, nums.length - 1);
    }

    private static void mergeOne(int[] nums, int left, int right) {
        if (left >= right) {
            // 递归截止条件
            return;
        }

        int q = (left + right) / 2;
        mergeOne(nums, left, q);
        mergeOne(nums, q + 1, right);
        // 有序段合并
        merge(nums, left, q, right);
    }

    private static void merge(int[] nums, int left, int q, int right) {
        // [left, q] [q + 1, right]
        int k = 0;
        int i = left; int j = q + 1;
        int[] tmp = new int[right - left + 1];
        while (i <= q && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }

        // 看下左右数组哪边剩余了
        int l, r;
        if (i == left) {
            // 剩余左边 [left, q]
            l = left; r = q;
        } else {
            // 剩余的是右边 [q+1, right]
            l = q + 1; r = right;
        }
        // copy rest
        while (l <= r) {
            tmp[k++] = nums[l++];
        }

        // copy from tmp to nums
        for (i = 0; i < tmp.length; i++) {
            nums[left + i] = tmp[i];
        }
    }

    private static void quickSort(int[] nums) {

    }
}
