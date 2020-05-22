package leetcode.top.interview.question;

/**
 * @author Richard_Yi
 * @version 1.0 2020/5/22
 */
public class T198_Rob {


    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

    // 一个关键点：非负整数

    // 动态规划 dp[n] = max(dp[n-1], dp[n-2] + nums[n])

    static int rob(int[] nums) {

        if (nums.length < 1) {
            return 0;
        }

        int len = nums.length;

        int prev = 0;
        int curr = nums[0];
        for (int i = 2; i <= len; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + nums[i - 1]);
            prev = temp;
        }
        return curr;
    }
}
