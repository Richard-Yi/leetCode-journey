package leetcode.top.interview.question;

import leetcode.common.TreeNode;

/**
 * @author Richard_yyf
 * @version 1.0 2020/5/16
 */
public class T101_IsSymmetric {

    public static void main(String[] args) {

    }

    static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            // 空指针返回，但是其中有一个不是，所以非对称
            return false;
        }
        return (t1.val == t2.val)
                && (isMirror(t1.left, t2.right))
                && (isMirror(t1.right, t2.left));
    }
}
