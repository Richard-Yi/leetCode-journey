package self.learn.tree;

import leetcode.common.TreeNode;

/**
 * 难度：easy
 * tag: tree 递归
 * 总结：不难，只要你熟悉平衡二叉树的概念就很简单了
 * @author Richard_yyf
 * @version 1.0 2021/6/13
 */
public class IsBalanced_T110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
