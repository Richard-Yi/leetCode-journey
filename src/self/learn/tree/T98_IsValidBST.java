package self.learn.tree;

import leetcode.common.TreeNode;

/**
 * @author Richard_yyf
 * @version 1.0 2021/11/21
 */
public class T98_IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValid(root.left, null, root) && isValid(root.right, root, null);
    }

    private boolean isValid(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min.val) {
            return false;
        }
        if (max != null && node.val >= max.val) {
            return false;
        }
        return isValid(node.left, min, node) && isValid(node.right, node, max);
    }
}
