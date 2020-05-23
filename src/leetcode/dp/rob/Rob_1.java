package leetcode.dp.rob;

import java.util.Arrays;

/**
 * 打家劫舍 题型一
 * @author Richard_yyf
 * @version 1.0 2020/5/23
 */
public class Rob_1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob1(nums));
        System.out.println(rob2(nums));
        System.out.println(rob3(nums));
        System.out.println(rob4(nums));
    }

    // 递归方式

    static int rob1(int[] nums) {
        return dp1(nums, 0);
    }

    static int dp1(int[] nums, int start) {
        if (start >= nums.length) {
            // 到了最后一家了
            // 这里不要迷糊了，因为是nums.length所以才是>=符号
            return 0;
        }

        return Math.max(
                dp1(nums, start + 1),
                nums[start] + dp1(nums, start + 2)
        );
    }

    // 备忘录 优化重叠子问题

    static int[] memo;

    static int rob2(int[] nums) {
        memo = new int[nums.length];
        // -1 用来标识是否初始化，相较于map节省空间
        Arrays.fill(memo, -1);
        return dp2(nums, 0);
    }

    static int dp2(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] == -1) {
            memo[start] = Math.max(
                    dp2(nums, start + 1),
                    nums[start] + dp2(nums, start + 2)
            );
        }
        return memo[start];
    }

    // 前面是自顶向下，改成自底向上

    static int rob3(int[] nums) {
        int n = nums.length;
        // int 初始化是0，这个不要忘了，所以不用显示声明dp[n] = 0
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }

    static int rob4(int[] nums) {
        int n = nums.length;
        int dp_i_2 = 0;
        int dp_i_1 = 0;
        for (int i = n - 1; i >= 0; i--) {
            int temp = dp_i_1;
            dp_i_1 = Math.max(dp_i_1, dp_i_2 + nums[i]);
            dp_i_2 = temp;
        }
        return dp_i_1;
    }
}
