package leetcode.dp.rob;

/**
 * 打家劫舍 题型二
 *
 * @author Richard_yyf
 * @version 1.0 2020/5/23
 */
public class Rob_2 {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(rob(nums));
    }

    static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int dp_i_2 = 0;
        int dp_i_1 = 0;
        // 选最后一间，不选第一间的情况
        for (int i = n - 1; i >= 1; i--) {
            int temp = dp_i_1;
            dp_i_1 = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = temp;
        }
        int x1 = dp_i_1;
        // 选第一间，不选最后一间的情况
        dp_i_1 = 0;
        dp_i_2 = 0;
        for (int i = n - 2; i >= 0; i--) {
            int temp = dp_i_1;
            dp_i_1 = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = temp;
        }
        return Math.max(dp_i_1, x1);
    }
}
