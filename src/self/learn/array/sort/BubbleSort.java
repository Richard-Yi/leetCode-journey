package self.learn.array.sort;

import java.util.Arrays;

/**
 * @author Richard_yyf
 * @version 1.0 2021/5/20
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            // TODO: 注意，这里 -1 可以理解为 j 代表比较次数
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                // 没有移动的
                break;
            }
        }
    }
}
