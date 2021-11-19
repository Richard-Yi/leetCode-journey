package self.learn.array.slidewindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Richard_yyf
 * @version 1.0 2021/11/19
 */
public class T239_MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.push(nums[i]);
                if (i == k - 1) {
                    res[i - k + 1] = queue.max();
                }
            } else {
                queue.pop(nums[i - k]);
                queue.push(nums[i]);
                res[i - k + 1] = queue.max();
            }
        }
        return res;
    }

    static class MonotonicQueue {
        private Deque<Integer> deque = new ArrayDeque<>();
        void push(int n) {
            while (!deque.isEmpty() && deque.peekLast() < n) {
                // 要保证队列左边是最大的
                deque.pollLast();
            }
            // 往队列头添加
            deque.offerFirst(n);
        }
        void pop(int n) {
            if (!deque.isEmpty() && deque.peekLast() == n) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && deque.peekLast() < deque.peekFirst()) {
                deque.pollLast();
            }
        }
        int max() {
            return deque.peekLast();
        }
    }

}
