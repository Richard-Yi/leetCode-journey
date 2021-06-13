package self.learn.tree;

/**
 * 二分查找树 实现
 * @author Richard_yyf
 * @version 1.0 2021/6/13
 */
public class BST {

    // get
    // insert
    // delete
    TreeNode root;

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(1);
        bst.insert(5);
        bst.insert(2);
        bst.insert(4);
        bst.insert(3);
        bst.inOrderTraversal();
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    public static void preOrderTraversal(TreeNode root) {
        // 前序遍历
        if (root == null) {
            return;
        }
        // 先访问节点自己
        System.out.println(root.val);
        // 再左
        preOrderTraversal(root.left);
        // 再右
        preOrderTraversal(root.right);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    public static void postOrderTraversal(TreeNode root) {
        // 后续遍历
        if (root == null) {
            return;
        }
        // 先左
        postOrderTraversal(root.left);
        // 再右
        postOrderTraversal(root.right);
        // 再自己
        System.out.println(root.val);
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public static void inOrderTraversal(TreeNode root) {
        // 后续遍历
        if (root == null) {
            return;
        }
        // 先左
        inOrderTraversal(root.left);
        // 再自己
        System.out.println(root.val);
        // 再右
        inOrderTraversal(root.right);
    }

    public TreeNode get(int target) {
        TreeNode cur = root;
        while (cur != null && cur.val != target) {
            if (target > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return cur;
    }

    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (true) {
            parent = cur;
            if (val > parent.val) {
                cur = parent.right;
                if (cur == null) {
                    parent.right = new TreeNode(val);
                    return;
                }
            } else if (val < parent.val) {
                cur = parent.left;
                if (cur == null) {
                    parent.left = new TreeNode(val);
                    return;
                }
            } else {
                // BST does not allow nodes with the same value
                return;
            }
        }
    }

    public boolean delete(int target) {

        // find node to be deleted
        // parent 代表cur的父节点
        TreeNode parent = null;
        // cur 代表要被删除的节点
        TreeNode cur = root;
        boolean isLeft = false;
        while (cur != null && cur.val != target) {
            parent = cur;
            if (target > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
                isLeft = true;
            }
        }
        if (cur == null) {
            // node to be deleted not found
            return false;
        }
        // case 1: the node has no child
        if (cur.right == null && cur.left == null) {
            if (cur == root) {
                root = null;
                return true;
            }
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }

        } else if (cur.right == null || cur.left == null) {

            // case 2: one child
            if (cur == root) {
                if (cur.right == null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
                return true;
            }
            TreeNode temp = cur.right != null ? cur.right : cur.left;
            if (isLeft) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }

        } else {
            // case 3: two children
            // 需要找到current右边子树中最小的节点，用于放在delete node的位置
            TreeNode successor = getSuccessor(cur);
            if (cur == root) {
                root = successor;
            } else if (isLeft) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }

        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode successor = null;
        TreeNode successorParent = null;
        // 在右子树里面找
        TreeNode cur = node.right;
        while (cur != null) {
            successorParent = successor;
            successor = cur;
            cur = cur.left;
        }
        if (successor != node.right) {
            // 把successor节点的右节点放到 successorParent 的左边
            // 注意，successor 只可能有右节点
            successorParent.left = successor.right;
            // node是要删除的节点，successor作为它的替换节点要继承它的右子树
            successor.right = node.right;
        }
        return successor;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
