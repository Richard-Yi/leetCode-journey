package self.learn.linklist;

import leetcode.common.ListNode;

import java.util.Arrays;

/**
 * @author Richard_yyf
 * @version 1.0 2021/5/9
 */
public class ReverseList3_25 {

    public static void main(String[] args) {
        // case1 head = [1,2,3,4,5], k=2
        ListNode listNode = ListNode.toLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode reversedNode = reverseKGroup(listNode, 3);
        System.out.println(Arrays.toString(ListNode.toArray(reversedNode)));

        // case2 [1,2,3,4,5], k=1
        listNode = ListNode.toLinkedList(new int[]{1, 2, 3, 4, 5});
        reversedNode = reverseKGroup(listNode, 1);
        System.out.println(Arrays.toString(ListNode.toArray(reversedNode)));

        // case3 [1,2,3,4,5], k=5
        listNode = ListNode.toLinkedList(new int[]{1, 2, 3, 4, 5});
        reversedNode = reverseKGroup(listNode, 5);
        System.out.println(Arrays.toString(ListNode.toArray(reversedNode)));

        // case4 [1,2,3,4,5], k=3
        listNode = ListNode.toLinkedList(new int[]{1, 2, 3, 4, 5});
        reversedNode = reverseKGroup(listNode, 3);
        System.out.println(Arrays.toString(ListNode.toArray(reversedNode)));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode pre = dummy;


        int count = 0;
        boolean isRemainStepsHigherThanK = remainStepsHigherThanK(pre.next, k);
        while (true) {
            // 判断实际的剩余长度
            if (!isRemainStepsHigherThanK || cur.next == null) {
                break;
            }

            ListNode tempNext = cur.next;
            cur.next = tempNext.next;
            tempNext.next = pre.next;
            pre.next = tempNext;

            count++;

            if (count == k - 1) {
                // 交换次数达到 k - 1次
                // cur 前进一步，
                pre = cur;
                cur = cur.next;
                // count 归零
                count = 0;
                isRemainStepsHigherThanK = remainStepsHigherThanK(pre.next, k);
            }
        }

        return dummy.next;
    }

    public static boolean remainStepsHigherThanK(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
}
