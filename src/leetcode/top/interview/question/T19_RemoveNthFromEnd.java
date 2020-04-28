package leetcode.top.interview.question;

/**
 * @author Richard_Yi
 * @version 1.0 2020/4/28
 */
public class T19_RemoveNthFromEnd {

    public static void main(String[] args) {

    }

    // 这道题是查找链表中倒数第K个数的变题

    // 参考题解：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/hua-jie-suan-fa-19-shan-chu-lian-biao-de-dao-shu-d/

    // 只用迭代一次的解法：双指针：快慢指针

    static ListNode removeNthFromEndOnlyIterateOnce(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast, slow;
        fast = slow = pre;

        // 快指针先前移动n次
        while (n != 0) {
            n--;
            fast = fast.next;
        }

        // 快慢指针一起移动，直到快指针到了尽头 即fast.next == null

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return pre.next;
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;

        ListNode curr = head;

        while (curr.next != null) {
            size++;
            curr = curr.next;
        }

        int temp = 0;
        int i = size - n;
        curr = head;
        ListNode left = null;
        while (temp != i) {
            left = curr;
            temp++;
            // 边界情况考虑
            if (curr.next != null) {
                curr = curr.next;
            }
        }
        if (left == null) {
            // 删除正数第一个
            return head.next;
        }
        left.next = curr.next;
        curr.next = null;

        return head;
    }
}
