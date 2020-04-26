package leetcode.top.interview.question;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author Richard_yyf
 * @version 1.0 2020/3/9
 */
public class T02_AddTwoNumbers {

    // 复习版本
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 进位
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode currentNode = head;
        // 这里是 或"||" 的关系！
        while (l1 != null || l2 != null) {
            int s1 = l1 == null ? 0 : l1.val;
            int s2 = l2 == null ? 0 : l2.val;

            int cur = s1 + s2 + carry;
            carry = cur / 10;
            cur = cur % 10;
            currentNode.next = new ListNode(cur);
            currentNode = currentNode.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        // 记得还要判断最高位相加还要再进一位的情况，即carry = 1
        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }
        return head.next;
    }


    // 非空、链表
    // 链表用来表示两个非负的整数
    // 位数按照逆序存储，每个node上只有一位数字


    // 自己结题时候犯的错误：
    // 1. 忘了有进位
    // 2. 忘了是逆序存储，进位的给下一个node+1；
    // 3. 这里相当于是补全的思想，比如 1 -> 0 -> 8 和 2 -> 1 -> 3 -> 4，应该把 1 -> 0 -> 8当做 1 -> 0 -> 8 -> 0对待

    public ListNode realSolution(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;

        // 进位，carrier = val1 + val2 >= 10 ? 1 : 0;
        int carrier = 0;
        while (p1 != null || p2 != null) {
            // 如果某一个链表到头了，接下去的位数就都补0
            int a = p1 == null ? 0 : p1.val;
            int b = p2 == null ? 0 : p2.val;
            curr.next = new ListNode((a + b + carrier) % 10);
            // 计算进位
            carrier = (a + b + carrier) / 10;

            // 指针前进
            curr = curr.next;
            // 有一个赋值为null，说明到了尽头
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
        }
        // 如果进位是0，说明curr是最后一个，否则就还需要进一位
        curr.next = carrier == 0 ? null : new ListNode(carrier);
        ListNode ret = dummyHead.next;
        dummyHead = null;
        return ret;
    }

    public ListNode addTwoNumbersFromMyFirstBadPractice(ListNode l1, ListNode l2) {
        int val = l1.val + l2.val;
        ListNode node;
        ListNode current;
        if (val >= 10) {
            node = new ListNode(1);
            current = new ListNode(val - 10);
            node.next = current;
        } else {
            node = new ListNode(val);
            current = node;
        }
        if (l1.next == null && l2.next == null) {
            return node;
        }
        ListNode l1Current = l1.next;
        ListNode l2Current = l2.next;
        while (true) {
            if (l1Current == null && l2Current == null) {
                return node;
            }
            if (l1Current == null) {
                current.next = l2Current.next;
                return node;
            }
            if (l2Current == null) {
                current.next = l1Current.next;
                return node;
            }
            // 进位未考虑！
            val = l1Current.val + l2Current.val;
            if (val >= 10) {
                current.val++;
                current.next = new ListNode(val -10);
                current = current.next;
            } else {
                current.next = new ListNode(val);
                current = current.next;
            }
            l1Current = l1Current.next;
            l2Current = l2Current.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}