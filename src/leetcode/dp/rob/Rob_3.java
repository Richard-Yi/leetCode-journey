package leetcode.dp.rob;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍 二叉树
 * @author Richard_yyf
 * @version 1.0 2020/5/23
 */
public class Rob_3 {

    private Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        // 抢当前这家
        int rob_it = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.right) + rob(root.right.left));
        // 不抢下家
        int rob_next = rob(root.left) + rob(root.right);
        int max = Math.max(rob_it, rob_next);
        memo.put(root, max);
        return max;
    }

    public int rob2(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    // arr[0] 代表 不抢root 得到的最大钱数
    // arr[1] 代表 抢root 得到的最大钱数
    private int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int rob_it = root.val + left[0] + right[0];
        // 不抢当前这家，下家可抢可不抢！取决于收益
        int rob_next = Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);
        return new int[]{rob_next, rob_it};
    }
}
