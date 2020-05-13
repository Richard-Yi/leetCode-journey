package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Richard_Yi
 * @version 1.0 2020/5/12
 */
public class T509_Fibonacci {

    public static void main(String[] args) {
        int n = 0;
        System.out.println(fib(n));
        System.out.println(fib2(n));
        System.out.println(fib3(n));
        System.out.println(fib4(n));
        System.out.println(fib5(n));
    }

    // 时间复杂度怎么算？子问题个数乘以解决一个子问题需要的时间。
    //
    // 子问题个数，即图中节点的总数，
    //
    // 由于本算法不存在冗余计算，子问题就是 f(1), f(2), f(3) ... f(20)，
    //
    // 数量和输入规模 n = 20 成正比，所以子问题个数为 O(n)。

    private static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static Map<Integer, Integer> map = new HashMap<>();

    // 带备忘录的解法

    private static int fib2(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        int a;
        if (map.containsKey(N - 1)) {
            a = map.get(N - 1);
        } else {
            a = fib2(N - 1);
            map.put(N - 1, a);
        }
        int b;
        if (map.containsKey(N - 2)) {
            b = map.get(N - 2);
        } else {
            b = fib2(N - 2);
            map.put(N - 2, b);
        }
        return a + b;
    }

    // 带备忘录的解法

    private static int fib3(int N) {
        if (N < 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>(N);
        return help(map, N);
    }

    private static int help(Map<Integer, Integer> map, int N) {

        if (N == 1 || N == 2) {
            return 1;
        }

        if (map.containsKey(N)) {
            return map.get(N);
        }

        return help(map, N - 1) + help(map, N - 2);
    }

    // dp table的解法，自底向上

    private static int fib4(int N) {
        Map<Integer, Integer> map = new HashMap<>(N);

        map.put(1, 1);
        map.put(0, 0);
        for (int i = 2; i <= N; i++) {
            int ret = map.get(i - 1) + map.get(i - 2);
            map.put(i, ret);
        }
        return map.get(N);
    }

    // dp table的解法再优化

    private static int fib5(int N) {

        if (N < 2) {
            return N;
        }

        int prev = 0, curr = 1;
        for (int i = 2; i <= N; i++) {
            int temp = prev;
            prev = curr;
            curr = prev + temp;
        }
        return curr;
    }
}
