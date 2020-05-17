package leetcode.top.interview.question;

import leetcode.common.TreeNode;

/**
 * 二叉树最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @author Richard_yyf
 * @version 1.0 2020/5/17
 */
public class T104_TreeMaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
