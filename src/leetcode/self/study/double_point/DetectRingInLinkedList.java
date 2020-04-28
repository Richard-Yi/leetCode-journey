package leetcode.self.study.double_point;


import leetcode.common.ListNode;

/**
 * 双指针技巧再分为两类，一类是「快慢指针」，一类是「左右指针」。
 * 「快慢指针」解决主要解决链表中的问题，比如典型的判定链表中是否包含环；
 * 「左右指针」主要解决数组（或者字符串）中的问题，比如二分查找。
 *
 * @author Richard_Yi
 * @version 1.0 2020/4/28
 */
public class DetectRingInLinkedList {

    // 1. 判断链表中是否有环

    boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        if (fast == null) {
            return false;
        }

        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 如果成环，那么正常情况下循环不会结束
            // 但是快慢指针总会相遇，然后退出循环
            if (fast == slow) {
                return true;
            }
        }
        // 所以这里是不成环的情况
        return false;
    }

    // 2. 已知有环，返回环的起始位置的Node

    ListNode returnCycleStartNode(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                break;
            }
        }

        // 快指针走了2K步，慢指针走K步相遇，cycle 的长度是K

        // 假设相遇点距离环起点是m，环起点距离head是l，可以得出 l + m + k = 2k
        // 得出环起点具体head l = k-m

        // 上述描述的是相遇时的情况，那么接下去，如果把其中一个指针指向head
        // 两个指针匀速前进k-m, 指针A 行走了k-m = l(环起点与head的距离) 走到了环起点，
        // 指针B 走了 k-m，距离环起点的距离就是 k-m+m = k;也走到了环起点。

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
