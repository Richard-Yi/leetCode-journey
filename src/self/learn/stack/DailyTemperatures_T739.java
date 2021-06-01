package self.learn.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 难度：medium
 * tag: 栈
 * 总结：定义好stack的含义很重要，比如在这题里面，stack里面装的就是比temperature[i]要大的元素，head最小，呈单调递增
 * @author Richard_yyf
 * @version 1.0 2021/6/1
 */
public class DailyTemperatures_T739 {

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(res));
    }

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];

        // 比temperature[i] 大的数
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (stack.peek() != null) {
                if (temperatures[stack.peek()] > temperatures[i]) {
                    res[i] = stack.peek() - i;
                    stack.push(i);
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.peek() == null) {
                res[i] = 0;
                stack.push(i);
            }
        }

        return res;
    }
}
