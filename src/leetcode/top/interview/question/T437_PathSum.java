package leetcode.top.interview.question;

import leetcode.common.TreeNode;

/**
 * @author Richard_Yi
 * @version 1.0 2020/5/26
 */
public class T437_PathSum {

    // 找出路径和等于给定数值的路径总数。

    // 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的

    int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return countSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int countSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int c = 0;
        if (root.val == sum) {
            c++;
        }

        return c + countSum(root.left, sum - root.val)
                + countSum(root.right, sum - root.val);
    }

}
