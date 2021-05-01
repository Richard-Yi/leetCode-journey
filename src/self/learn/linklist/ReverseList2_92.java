package self.learn.linklist;

import leetcode.common.ListNode;

import java.util.Arrays;

/**
 * @author Richard_yyf
 * @version 1.0 2021/5/1
 */
public class ReverseList2_92 {

    public static void main(String[] args) {
        // case1 head = [1,2,3,4,5], left = 2, right = 4
        ListNode listNode = ListNode.toLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode reversed = reverseBetween(listNode, 2, 4);
        System.out.println(Arrays.toString(ListNode.toArray(reversed)));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = dummy.next;
        // 头插法 left - 1 很关键
        for (int step = 0; step < left - 1; step++) {
            prev = prev.next;
            cur = cur.next;
        }

        for (int step = left; step < right; step++) {
            ListNode removed = cur.next;

            cur.next = cur.next.next;

            removed.next = prev.next;
            prev.next = removed;
        }
        return dummy.next;
    }

}
