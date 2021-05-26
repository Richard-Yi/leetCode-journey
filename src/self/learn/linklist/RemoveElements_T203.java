package self.learn.linklist;

import leetcode.common.ListNode;

/**
 * - tag: 链表
 * - 难度：easy
 * @author Richard_yyf
 * @version 1.0 2021/5/26
 */
public class RemoveElements_T203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
