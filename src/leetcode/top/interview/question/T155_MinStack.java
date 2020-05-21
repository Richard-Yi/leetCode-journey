package leetcode.top.interview.question;

import java.util.Stack;

/**
 * @author Richard_Yi
 * @version 1.0 2020/5/21
 */
public class T155_MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(-3 == minStack.getMin());
        minStack.pop();
        System.out.println(0 == minStack.top());
        System.out.println(-2 == minStack.getMin());
    }

    static class MinStack {

        private Stack<Integer> minStack;

        private Stack<Integer> stack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if (minStack.size() == 0 || x <= minStack.peek()) {
                // 关键是等于的时候也要放进去！！
                minStack.push(x);
            }
            stack.push(x);
        }

        public void pop() {
            int x = stack.pop();
            if (x == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
