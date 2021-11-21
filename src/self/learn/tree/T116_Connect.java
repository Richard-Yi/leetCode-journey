package self.learn.tree;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @author Richard_yyf
 * @version 1.0 2021/11/21
 */
public class T116_Connect {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        doConnect(root.left, root.right);
        return root;
    }

    private void doConnect(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        doConnect(left.left, left.right);
        doConnect(left.right, right.left);
        doConnect(right.left, right.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
