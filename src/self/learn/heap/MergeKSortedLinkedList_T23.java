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
        if (lists.length == 0) {
            return null;
        }
        // new java.util.PriorityQueue<>() 时，如果capacity为0，会报错
        java.util.PriorityQueue<ListNode> heap = new java.util.PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            // 不能offer null，会报错
            heap.offer(list);
        }
        ListNode head = new ListNode(0);
        ListNode cur = null;
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            if (cur == null) {
                cur = min;
                head.next = cur;
            } else {
                cur.next = min;
                cur = min;
            }
            if (min.next != null) {
                heap.offer(min.next);
            }
        }
        return head.next;
    }
}
