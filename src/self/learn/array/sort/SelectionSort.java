package self.learn.array.sort;

import java.util.Arrays;

/**
 * @author Richard_yyf
 * @version 1.0 2021/5/20
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            for (int j = i; j < nums.length; j++) {
                // 未排序区找到最小的
                if (min > nums[j]) {
                    int tmp = nums[j];
                    nums[j] = min;
                    min = tmp;
                }
            }
            nums[i] = min;
        }
    }
}
