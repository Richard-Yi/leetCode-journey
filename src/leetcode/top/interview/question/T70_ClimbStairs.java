package leetcode.top.interview.question;

/**
 * @author Richard_Yi
 * @version 1.0 2020/5/13
 */
public class T70_ClimbStairs {

    public static void main(String[] args) {
        int n = 5;

        System.out.println(climbStairs(n));
    }

    static int climbStairs(int n) {

        if (n < 3) {
            return n;
        }

        int prev = 1, curr = 2;

        for (int i = 3; i <= n; i++) {

            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }

        return curr;
    }
}
