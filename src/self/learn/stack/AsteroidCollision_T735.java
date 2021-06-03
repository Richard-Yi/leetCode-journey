package self.learn.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 难度：medium
 * tag: 栈
 * 总结：自己多练几遍
 * @author Richard_yyf
 * @version 1.0 2021/6/1
 */
public class AsteroidCollision_T735 {

    public static void main(String[] args) {
//        int[] asteroids = {5, 10, -5};
        int[] asteroids = {-2, 2, -1, -2};
        int[] res = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(res));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = asteroids.length - 1; i >= 0; i--) {
            if (stack.isEmpty() || stack.peek() > 0 || asteroids[i] < 0) {
                // stack 为空，栈顶元素 > 0 ， 当前元素小于0
                stack.push(asteroids[i]);
                continue;
            }

            int temp = asteroids[i] + stack.peek();
            while (temp > 0) {

                stack.pop();
                if (stack.peek() == null || stack.peek() > 0) {
                    break;
                }
                temp = asteroids[i] + stack.peek();

            }
            if (temp == 0) {
                stack.pop();
            } else if (temp > 0){
                stack.push(asteroids[i]);
            }
            // temp < 0就啥也不用干，保持原样
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
