package leetcode.top.interview.question;

import leetcode.common.TreeNode;

/**
 * @author Richard_Yi
 * @version 1.0 2020/5/28
 */
public class T543_DiameterOfBinaryTree {

    // 递归

    int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // 计算以当前节点为最高节点且经过当前节点的半径
        int dRoot = traverseCompute(root);

        int dLeft = diameterOfBinaryTree(root.left);
        int dRight = diameterOfBinaryTree(root.right);

        return Math.max(Math.max(dRoot, dLeft), dRight);
    }

    private int traverseCompute(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = biasedTraverse(root.left);
        int r = biasedTraverse(root.right);
        return l + r;
    }

    private int biasedTraverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = biasedTraverse(root.left);
        int r = biasedTraverse(root.right);
        return Math.max(l, r) + 1;
    }
}
