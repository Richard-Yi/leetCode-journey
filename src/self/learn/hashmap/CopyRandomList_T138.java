package self.learn.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 难度：mid
 * tag: hash map
 * @author Richard_yyf
 * @version 1.0 2021/6/11
 */
public class CopyRandomList_T138 {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        Node dumpHead = new Node(0);
        Node newCur = null;
        while (cur != null) {
            Node copy = map.computeIfAbsent(cur, n -> new Node(n.val));
            if (cur.random != null) {
                copy.random = map.computeIfAbsent(cur.random, n -> new Node(n.val));
            }
            copy.next = cur.next == null ? null : map.get(cur.next);

            if (dumpHead.next == null) {
                dumpHead.next = copy;
                newCur = copy;
            } else {
                newCur.next = copy;
                newCur = newCur.next;
            }
            cur = cur.next;
        }

        return dumpHead.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
