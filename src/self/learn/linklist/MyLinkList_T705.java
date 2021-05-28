package self.learn.linklist;

/**
 * - tag: 链表
 * - 主要考察你对链表的操控能力，建议多练习
 * - 难度：medium
 * @author Richard_yyf
 * @version 1.0 2021/5/28
 */
public class MyLinkList_T705 {

    public static void main(String[] args) {
        // ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
        // [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7); // 7
        linkedList.print();
        linkedList.addAtHead(2); // 2 7
        linkedList.print();
        linkedList.addAtHead(1); // 1 2 7
        linkedList.print();
        linkedList.addAtIndex(3, 0); // 1 2 7 0
        linkedList.print();
        linkedList.deleteAtIndex(2); // 1 2 0
        linkedList.print();
        linkedList.addAtHead(6); // 6 1 2 0
        linkedList.print();
        linkedList.addAtTail(4); // 6 1 2 0 4
        linkedList.print();
        linkedList.get(4); // 4
        linkedList.print();
        linkedList.addAtHead(4);
        linkedList.print();
        linkedList.addAtIndex(5, 0);
        linkedList.print();
        linkedList.addAtHead(6);

//        linkedList.addAtHead(1); // 1
//        linkedList.print();
//        linkedList.addAtTail(3); // 1 -> 3
//        linkedList.print();
//        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//        linkedList.print();
//        linkedList.get(1);            //返回2
//        linkedList.print();
//        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//        linkedList.print();
//        linkedList.get(1);            //返回3
    }

    static class MyLinkedList {

        private ListNode head;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            this.size = 0;
            head = new ListNode(0);
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index >= size) {
                return -1;
            }
            ListNode cur = head.next;
            for (int i = 1; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode addNode = new ListNode(val);
            addNode.next = head.next;
            head.next = addNode;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            ListNode addNode = new ListNode(val);
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = addNode;
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            int i = 0;
            ListNode cur = head;
            while (i < index) {
                cur = cur.next;
                i++;
            }
            ListNode addNode = new ListNode(val);
            addNode.next = cur.next;
            cur.next = addNode;
            size++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }
            ListNode cur = head;
            int i = 0;
            while (i < index) {
                cur = cur.next;
                i++;
            }
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = null;
            size--;
        }

        void print() {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
                System.out.print(cur.val + ",");
            }
            System.out.print("\n");
        }

        class ListNode {
            int val;
            ListNode next;

            ListNode(int val) {
                this.val = val;
            }
        }
    }

}
