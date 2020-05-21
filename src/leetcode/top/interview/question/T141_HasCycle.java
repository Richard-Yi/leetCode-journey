package leetcode.top.interview.question;

import leetcode.common.ListNode;

/**
 * @author Richard_Yi
 * @version 1.0 2020/5/21
 */
public class T141_HasCycle {


    static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if (fast == null) {
            return false;
        }

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
