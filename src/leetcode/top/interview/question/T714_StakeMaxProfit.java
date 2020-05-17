package leetcode.top.interview.question;

/**
 * @author Richard_yyf
 * @version 1.0 2020/5/17
 */
public class T714_StakeMaxProfit {

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }

    static int maxProfit(int[] prices, int fee) {
        // fee 的存在，相当于买入的价格提高了
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
        }
        return dp_i_0;
    }
}
