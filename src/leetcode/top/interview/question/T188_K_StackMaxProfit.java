package leetcode.top.interview.question;

/**
 * @author Richard_yyf
 * @version 1.0 2020/5/17
 */
public class T188_K_StackMaxProfit {

    public static void main(String[] args) {
        int[] prices = {2,4,1};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }

    static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int n = prices.length;
        if (k > n / 2) {
            // 相当于k无限大
            return maxProfit_K_Infinity(prices);
        }

        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k1 = k; k1 > 0; k1--) {
                if (i == 0) {
                    dp[i][k1][0] = 0;
                    dp[i][k1][1] = -prices[i];
                    continue;
                }
                dp[i][k1][0] = Math.max(dp[i - 1][k1][0], dp[i - 1][k1][1] + prices[i]);
                // TODO 注意是 k-1 !!!!!!!!
                dp[i][k1][1] = Math.max(dp[i - 1][k1][1], dp[i - 1][k1 - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    static int maxProfit_K_Infinity(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }
}
