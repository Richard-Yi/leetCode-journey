package self.learn.tree;

import leetcode.common.TreeNode;

/**
 * @author Richard_yyf
 * @version 1.0 2021/11/21
 */
public class T226_InvertTree {

    public TreeNode invertTree(TreeNode root) {
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
