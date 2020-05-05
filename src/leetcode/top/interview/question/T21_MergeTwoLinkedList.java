package leetcode.top.interview.question;

import leetcode.common.ListNode;

import java.util.List;

/**
 * @author Richard_yyf
 * @version 1.0 2020/5/5
 */
public class T21_MergeTwoLinkedList {


    public static void main(String[] args) {

    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        head.next = curr;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                curr.next = n1;
                n1 = n1.next;
            } else {
//                if (curr == null) {
//                    head.next = curr = n2;
//                }
                curr.next = n2;
                n2 = n2.next;
            }
            curr = curr.next;
        }
        if (n1 == null) {
            curr.next = n2;
        }
        if (n2 == null) {
            curr.next = n1;
        }

        return head.next;
    }

}
