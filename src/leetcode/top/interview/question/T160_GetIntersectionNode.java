package leetcode.top.interview.question;

import leetcode.common.ListNode;

/**
 * @author Richard_Yi
 * @version 1.0 2020/5/22
 */
public class T160_GetIntersectionNode {

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        int aLen = 0;
        int bLen = 0;
        while (a != null) {
            aLen++;
            a = a.next;
        }
        while (b != null) {
            bLen++;
            b = b.next;
        }

        a = headA;
        b = headB;
        if (aLen > bLen) {
            int x = aLen - bLen;
            while (x > 0) {
                a = a.next;
                x--;
            }
        } else {
            int x = bLen - aLen;
            while (x > 0) {
                b = b.next;
                x--;
            }
        }
        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
}
