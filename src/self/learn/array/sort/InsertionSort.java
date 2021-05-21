package self.learn.array.sort;

import java.util.Arrays;

/**
 * @author Richard_yyf
 * @version 1.0 2021/5/20
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        // 已排序区和未排序区
        // 未排序区拿一个，在已排序区找到合适的地方插入
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                // 在已排序区里找合适的地方
                if (val < nums[j]) {
                    nums[j + 1] = nums[j]; // 数据移动
                } else {
                    break;
                }
            }
            nums[j + 1] = val;
        }
    }
}
