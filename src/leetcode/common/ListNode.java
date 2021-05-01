package leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Richard_Yi
 * @version 1.0 2020/4/28
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode toLinkedList(int[] array) {
        ListNode head = new ListNode(-1);
        ListNode curr = null;
        for (int i : array) {
            if (curr == null) {
                curr = new ListNode(i);
                head.next = curr;
            } else {
                curr.next = new ListNode(i);
                curr = curr.next;
            }
        }
        return head.next;
    }

    public static int[] toArray(ListNode head) {

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}