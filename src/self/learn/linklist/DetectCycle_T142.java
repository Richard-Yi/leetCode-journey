package self.learn.linklist;

import leetcode.common.ListNode;

/**
 *
 * 难度：medium
 * tag: 双指针 链表
 * 时间：20min
 * 总结：判断环不难，判断环之后怎么获取到入口节点是个问题；
 * @author Richard_yyf
 * @version 1.0 2021/5/31
 */
public class DetectCycle_T142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == null || head.next == null) {
            return null;
        }
        while (fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode node1 = head;
                ListNode node2 = slow;
                while (node1 != node2) {
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return node1;
            }
        }
        return null;
    }
}
