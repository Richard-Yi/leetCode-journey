package self.learn.heap;

import leetcode.common.ListNode;

import java.util.Comparator;

/**
 * 难度：hard
 * tag: 堆排序，最小堆
 * 总结：思路很巧妙，但是在写的时候没有考虑heap的边界条件，入参为Null的时候
 * @author Richard_yyf
 * @version 1.0 2021/6/9
 */
public class MergeKSortedLinkedList_T23 {

    public static void main(String[] args) {
        System.out.println(new MergeKSortedLinkedList_T23().mergeKLists(null));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        java.util.PriorityQueue<ListNode> heap = new java.util.PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            heap.offer(node);
        }

        ListNode head = null;
        ListNode cur = null;
        while (!heap.isEmpty()) {
            ListNode move = heap.poll();
            if (head == null) {
                head = move;
            } else {
                cur.next = move;
            }
            cur = move;
            if (move.next != null) {
                heap.offer(move.next);
            }
        }
        return head;
    }
}
