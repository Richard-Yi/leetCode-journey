package leetcode.top.interview.question;

import leetcode.common.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author Richard_Yi
 * @version 1.0 2020/5/15
 */
public class T206_ReverseLinkedList {

    public static void main(String[] args) {

    }

    // 迭代
    static ListNode reverseDoublePointIterate(ListNode node) {

        if (node == null) {
            return node;
        }

        ListNode pre = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }

        return pre;
    }

    // 递归

    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 最后一个节点
        // 如果链表是 1->2->3->4->5，那么此时的cur就是5
        // head 是 4, head.next.next = 5.next = 4 达到5->4的效果
        ListNode cur = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
