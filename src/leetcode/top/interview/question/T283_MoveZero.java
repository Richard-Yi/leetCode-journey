package leetcode.top.interview.question;

import java.util.Arrays;

/**
 * @author Richard_yyf
 * @version 1.0 2020/5/24
 */
public class T283_MoveZero {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 必须在原数组上操作，不能拷贝额外的数组。
    // 尽量减少操作次数。

    static void moveZeros(int[] nums) {
        // 指针遍历过的0的个数
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                c++;
            } else {
                nums[i - c] = nums[i];
            }
        }
        for (int i = nums.length - 1; i >= nums.length - c; i--) {
            nums[i] = 0;
        }
    }
}
