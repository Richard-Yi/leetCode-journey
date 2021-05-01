package self.learn.linklist;

import leetcode.common.ListNode;

import java.util.Arrays;

/**
 * @author Richard_yyf
 * @version 1.0 2021/5/1
 */
public class ReverseList_206 {

    public static void main(String[] args) {
        ListNode listNode = ListNode.toLinkedList(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ListNode.toArray(listNode)));
        ListNode reversed = reverseList(listNode);
        System.out.println(Arrays.toString(ListNode.toArray(reversed)));
        System.out.println(Arrays.toString(ListNode.toArray(reverseList2(ListNode.toLinkedList(new int[]{1, 2, 3, 4})))));
        System.out.println(Arrays.toString(ListNode.toArray(reverseList3(ListNode.toLinkedList(new int[]{1, 2, 3, 4})))));
    }

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (true) {
            if (current == null) {
                break;
            }

            ListNode tempNext = current.next;

            // current 指向前面的
            current.next = prev;

            if (tempNext == null) {
                break;
            }

            // 前进
            prev = current;
            current = tempNext;

        }
        return current;
    }

    public static ListNode reverseList2(ListNode head) {
        // 递归写法
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public static ListNode reverseList3(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy.next;

        while (true) {

            ListNode move = curr.next;
            if (move == null) {
                break;
            }
            curr.next = curr.next.next;
            move.next = dummy.next;
            dummy.next = move;
        }

        ListNode ret = dummy.next;
        ret.next = null;
        return ret;
    }
}
