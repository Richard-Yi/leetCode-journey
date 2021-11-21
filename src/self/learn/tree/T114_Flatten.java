package self.learn.tree;

import leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author Richard_yyf
 * @version 1.0 2021/11/21
 */
public class T114_Flatten {

    public void flatten(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        // flatten left and right
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        // 左子树 放到 右子树上
        root.left = null;
        root.right = left;

        // 遍历来到新的右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        // 原来的右子树拼接到新的右子树末端上
        p.right = right;
    }
}
