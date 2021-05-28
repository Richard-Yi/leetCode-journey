package self.learn.linklist;

import leetcode.common.ListNode;

/**
 *
 * @author Richard_yyf
 * @version 1.0 2021/5/28
 */
public class SwapPairs_T24 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;

        int i = 0;

        while (cur.next != null) {
            if ((i) % 2 == 0) {
                // revert
                ListNode temp = cur.next;
                pre.next = cur.next;
                cur.next = temp.next;
                temp.next = cur;
                // pre要更新
                pre = temp;
                // cur 通过旋转进了1位
            } else {
                pre = pre.next;
                cur = cur.next;
            }
            i++;
        }

        return dummy.next;
    }
}
