package self.learn.array.sort;

import java.util.Arrays;

/**
 * O(n^2) 排序：冒泡、插入、选择排序   -- 基于比较
 * O(nlog(n)) 排序：快排、归并    -- 基于比较
 * O(n) 排序：桶、计数、基数      -- 不基于比较
 *
 * @author Richard_yyf
 * @version 1.0 2020/6/26
 */
public class SortMain {

    public static void main(String[] args) {
        int[] nums = {4, 1, 6, 3, 2, 5};
//        SortMethod.bubbleSort(nums);
//        SortMethod.insertionSort(nums);
//        SortMethod.selectionSort(nums);
//        SortMethod.mergeSort(nums);
//        SortMethod.quickSort(nums);
        SortMethod.countSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
