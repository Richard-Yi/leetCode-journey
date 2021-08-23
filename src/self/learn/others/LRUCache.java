package self.learn.others;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Richard_yyf
 * @version 1.0 2021/8/23
 */
public class LRUCache {

    class Node {
        int key;
        int val;
        Node left;
        Node right;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node() {
        }
    }

    private Map<Integer, Node> cacheMap;
    private int n;
    private Node head;
    private Node tail;

    public LRUCache (int capacity) {
        n = capacity;
        cacheMap = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.right = tail;
        tail.left = head;
    }


    public int get(int key) {

        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            refresh(node);
            return node.val;
        }
        return -1;
    }


    public void put(int key, int value) {

        Node node;
        if (cacheMap.containsKey(key)) {
            node = cacheMap.get(key);
            node.val = value;
        } else {
            if (n == cacheMap.size()) {
                cacheMap.remove(tail.left.key);
                deleteNode(tail.left);
            }
            node = new Node(key, value);
            cacheMap.put(key, node);
        }
        refresh(node);
    }

    private void refresh(Node node) {
        deleteNode(node);
        node.right = head.right;
        node.left = head;
        head.right = node;
        node.right.left = node;
    }

    private void deleteNode(Node node) {
        if (node.left != null) {
            node.left.right = node.right;
            node.right.left = node.left;
        }
    }

}
