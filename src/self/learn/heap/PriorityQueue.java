package self.learn.heap;

/**
 * 优先队列自实现
 * @author Richard_yyf
 * @version 1.0 2021/6/3
 */
public class PriorityQueue {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.push(1, -5);
        priorityQueue.push(2, -4);
        priorityQueue.push(3, -3);
        priorityQueue.push(4, -2);
        priorityQueue.push(5, -1);
        while (!priorityQueue.isEmpty()) {
            PNode pNode = priorityQueue.pop();
            System.out.println(pNode.val + ": " + pNode.priority);
        }
    }

    PNode head;

    static class PNode {
        int val;
        int priority;
        PNode next;

        public PNode(int val, int priority) {
            this.val = val;
            this.priority = priority;
        }
    }

    public void push(int value, int priority) {
        if (head == null) {
            head = new PNode(value, priority);
            return;
        }
        PNode pNode = new PNode(value, priority);
        if (head.priority < priority) {
            pNode.next = head;
            head = pNode;
            return;
        }
        PNode cur = head;
        while (cur.next != null && cur.next.priority > priority) {
            cur = cur.next;
        }
        if (cur.next == null) {
            cur.next = pNode;
        } else {
            pNode.next = cur.next;
            cur.next = pNode;
        }
    }

    public PNode peek() {
        return head;
    }

    public PNode pop() {
        if (head == null) {
            return null;
        }
        PNode rm = head;
        head = rm.next;
        rm.next = null;
        return rm;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
