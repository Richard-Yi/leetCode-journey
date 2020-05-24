package leetcode.top.interview.question;

import java.util.LinkedList;

/**
 * @author Richard_yyf
 * @version 1.0 2020/5/24
 */
public class T255_QueueStack {

    class MyStack {

        private LinkedList<Integer> list;

        /** Initialize your data structure here. */
        public MyStack() {
            list = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            list.addFirst(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return list.removeFirst();
        }

        /** Get the top element. */
        public int top() {
            return list.getFirst();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return list.isEmpty();
        }
    }
}
