package leetcode.top.interview.question;

import leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断回文链表
 *
 * @author Richard_yyf
 * @version 1.0 2020/5/16
 */
public class T234_PalindromeLinkedList {

    public static void main(String[] args) {
        int[] arrays = {1, 1};
        System.out.println(isPalindrome(ListNode.toLinkedList(arrays)));
    }

    // 解法1：链表转数组，再去判断是否是回文

    static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val);
        int size = list.size();
        if (size <= 1) {
            return true;
        }
        int left = size / 2 - 1;
        int right = left + 1 + size % 2;
        while (left >= 0 && right < size) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    // 双指针
    // O(n) 时间复杂度和 O(1) 空间复杂度解决此题？


    // 思路：双指针 + 反转链表
    static boolean isPalindrome2(ListNode head) {
        return true;
    }
}
