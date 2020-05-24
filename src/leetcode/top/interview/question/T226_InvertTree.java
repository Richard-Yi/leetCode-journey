package leetcode.top.interview.question;

import leetcode.common.TreeNode;

/**
 * @author Richard_yyf
 * @version 1.0 2020/5/24
 */
public class T226_InvertTree {

    TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
