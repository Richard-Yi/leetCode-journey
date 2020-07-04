package leetcode.self.study.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 双向链表 + HashMap
 * @author Richard_yyf
 * @version 1.0 2020/6/20
 */
public class LRUCache<K, V> {

    private final Map<K, Node<K,V>> cacheMap = new HashMap<>();

    /**
     * 缓存限制
     */
    private int limit;

    /**
     * 节点数
     */
    private int nodeCount;

    private Node<K, V> head;
    private Node<K, V> tail;

    public LRUCache(int limit) {
        this.limit = limit;

        head = new Node<>();
        tail = new Node<>();

        head.next = tail;
        tail.prev = head;
        nodeCount = 0;
    }

    public V get(K key) {
        Node<K, V> node = cacheMap.get(key);
        // 更新链表顺序，放到头节点
        if (node != null) {
            move2Head(node);
            return node.val;
        } else {
            return null;
        }
    }

    private void move2Head(Node<K,V> node) {
        Node temp = node.prev;
        node.next.prev = temp;
        temp.next = node.next;

        temp = head.next;
        head.next = node;
        node.prev = head;
        temp.prev = node;
        node.next = temp;
    }

    public void put(K key, V value) {
        // add to map
        if (cacheMap.containsKey(key)) {
            // 更新值
            cacheMap.get(key).val = value;
        } else {
            Node<K, V> node = new Node<>(key, value);
            cacheMap.put(key, node);
            add2Tail(node);
        }
    }

    private void add2Tail(Node<K, V> node) {
        if (nodeCount == limit) {
            removeEldest();
        }
        Node temp = tail.prev;
        temp.next = node;
        node.prev = temp;
        node.next = tail;
        tail.prev = node;

        nodeCount++;
    }

    private void removeEldest() {
        Node<K, V> eldest = tail.prev;
        eldest.prev.next = tail;
        tail.prev = eldest.prev;

        cacheMap.remove(eldest.key);
        nodeCount--;
    }

    private class Node<K, V> {
        K key;
        V val;
        Node next;
        Node prev;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public Node() {
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head.next;
        while (node != tail) {
            sb.append(node.val);
            node = node.next;
        }
        return sb.toString();
    }
}
