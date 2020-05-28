package leetcode.top.interview.question;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Richard_Yi
 * @version 1.0 2020/5/28
 */
public class T538_ConvertBST {

    // 回溯算法

    TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, root.val);
        traverse(root.left, map);
        traverse(root.right, map);

        return root;
    }

    private void traverse(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return;
        }

        putRootAddIfHigherThan(root, map);

        traverse(root.left, map);
        traverse(root.right, map);
    }

    private void putRootAddIfHigherThan(TreeNode root, Map<TreeNode, Integer> map) {
        int currVal = root.val;
        int res = currVal;
        for (Map.Entry<TreeNode, Integer> entry : map.entrySet()) {
            if (currVal > entry.getValue()) {
                entry.getKey().val = entry.getKey().val + currVal;
            }
            if (entry.getValue() > currVal) {
                res = res + entry.getValue();
            }
        }
        root.val = res;
        map.put(root, currVal);
    }
}
