package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，
 * 每种硬币的数量无限，再给一个总金额 amount，
 * 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。
 *
 * 比如说 k = 3，面值分别为 1，2，5，总金额 amount = 11。
 * 那么最少需要 3 枚硬币凑出，即 11 = 5 + 5 + 1。
 *
 * @author Richard_Yi
 * @version 1.0 2020/5/13
 */
public class SpareChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 40;
        long cur = System.currentTimeMillis();
        System.out.println(coinChange(coins, amount));
        System.out.println("耗时：" + (System.currentTimeMillis() - cur));
        cur = System.currentTimeMillis();
        System.out.println(coinChange2(coins, amount));
        System.out.println("耗时：" + (System.currentTimeMillis() - cur));
    }

    // 再次回忆三要素
    // 重叠子问题
    // 最优子结构
    // 状态转移方程

    // 穷举、递归

    static int coinChange(int[] coins, int amount) {
        return dp(amount, coins);
    }

    static int dp(int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int temp = dp(amount - coin, coins);
            if (temp == -1) {
                continue;
            }
            res = Math.min(temp + 1, res);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // 加入备忘录消除子问题

    static int coinChange2(int[] coins, int amount) {

        Map<Integer, Integer> table = new HashMap<>();

        return dp2(table, amount, coins);
    }


    static int dp2(Map<Integer, Integer> table, int amount, int[] coins) {

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (!table.containsKey(amount)) {

            int res = Integer.MAX_VALUE;

            for (int coin : coins) {
                int temp = dp(amount - coin, coins);
                if (temp == -1) {
                    continue;
                }
                res = Math.min(temp + 1, res);
            }

            table.put(amount, res == Integer.MAX_VALUE ? -1 : res);
        }

        return table.get(amount);
    }
}
