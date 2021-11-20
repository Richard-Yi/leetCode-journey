package self.learn.dp;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @author Richard_yyf
 * @version 1.0 2021/11/20
 */
public class T322_CoinChange {

    /**
     * 1、确定 base case，
     * 这个很简单，显然目标金额 amount 为 0 时算法返回 0，因为不需要任何硬币就已经凑出目标金额了。
     *
     * 2、确定「状态」，
     * 也就是原问题和子问题中会变化的变量。由于硬币数量无限，硬币的面额也是题目给定的，
     * 只有目标金额会不断地向 base case 靠近，所以唯一的「状态」就是目标金额 amount。
     *
     * 3、确定「选择」，
     * 也就是导致「状态」产生变化的行为。目标金额为什么变化呢，
     * 因为你在选择硬币，你每选择一枚硬币，就相当于减少了目标金额。所以说所有硬币的面值，就是你的「选择」。
     *
     * 4、明确 dp 函数/数组的定义。
     * 我们这里讲的是自顶向下的解法，所以会有一个递归的 dp 函数，
     * 一般来说函数的参数就是状态转移中会变化的量，也就是上面说到的「状态」；
     * 函数的返回值就是题目要求我们计算的量。就本题来说，状态只有一个，即「目标金额」，
     * 题目要求我们计算凑出目标金额所需的最少硬币数量。所以我们可以这样定义 dp 函数：
     *
     * dp(n) 的定义：输入一个目标金额 n，返回凑出目标金额 n 的最少硬币数量。
     */

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // 子问题无解
                if (i - coin < 0) {
                    continue;
                }
                // 子问题求解
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        // 自上而下，备忘录
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -10);
        return dp(memo, coins, amount);
    }

    private int dp(int[] memo, int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        // memo lookup
        if (memo[amount] != -10) {
            return memo[amount];
        }
        // sub problem
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int sub = dp(memo, coins, amount - coins[i]);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, 1 + sub);
        }
        if (res == Integer.MAX_VALUE) {
            res = -1;
        }
        // memo update
        memo[amount] = res;
        return res;
    }
}
