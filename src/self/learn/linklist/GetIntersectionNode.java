package self.learn.linklist;

import leetcode.common.ListNode;

/**
 * 链表相交节点
 * 难度：easy
 * tag: 链表，双指针，快慢指针
 * 总结：题目描述非常拗口，理解了之后不难，就是双指针快慢指针的套路
 * @author Richard_yyf
 * @version 1.0 2021/5/31
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode cur = headA;
        while (cur != null) {
            lenA++;
            cur = cur.next;
        }

        cur = headB;
        while (cur != null) {
            lenB++;
            cur = cur.next;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < (lenA - lenB); i++) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < (lenB - lenA); i++) {
                curB = curB.next;
            }
        }

        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }
}
