package self.learn.array.slidewindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Richard_yyf
 * @version 1.0 2021/11/19
 */
public class T239_MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] result = new T239_MaxSlidingWindow().maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }

    //[1, 3, -1, -3, 5, 3, 6, 7]
    //i = 0, queue.addLast,[1]
    //i = 0, current max: 1
    //i = 1, queue.removeLast, ret:[]
    //i = 1, queue.addLast, ret:[3]
    //i = 1, current max:3
    //i = 2, queue.addLast, ret:[3, -1]
    //i = 2, current max:3
    //i = 3, queue.addLast, ret:[3, -1, -3]
    //i = 3, current max:3
    //i = 4, queue.removeLast, ret:[3, -1]
    //i = 4, queue.removeLast, ret:[3]
    //i = 4, queue.removeLast, ret:[]
    //i = 4, queue.addLast, ret:[5]
    //i = 4, current max:5
    //i = 5, queue.addLast, ret:[5, 3]
    //i = 5, current max:5
    //i = 6, queue.removeLast, ret:[5]
    //i = 6, queue.removeLast, ret:[]
    //i = 6, queue.addLast, ret:[6]
    //i = 6, current max:6
    //i = 7, queue.removeLast, ret:[]
    //i = 7, queue.addLast, ret:[7]
    //i = 7, current max:7
    //[3, 3, 5, 5, 6, 7]

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        System.out.println(Arrays.toString(nums));
        int[] ret = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.removeLast();
                System.out.println(String.format("i = %s, queue.removeLast, ret:%s", i, queue));
            }

            queue.addLast(i);
            System.out.println(String.format("i = %s, queue.addLast, ret:%s", i, queue));
            if (queue.peek() + k <= i) {
                queue.remove();
                System.out.println(String.format("i = %s, queue.remove, ret:%s", i, queue));
            }

            System.out.println(String.format("i = %s, current max:%s", i, queue.peek()));
            if (i + 1 >= k) {
                ret[i - k + 1] = nums[queue.peek()];
            }
        }

        return ret;
    }

}
