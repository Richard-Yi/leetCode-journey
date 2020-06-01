package leetcode.top.interview.question;

import java.util.Map;

/**
 * @author Richard_Yi
 * @version 1.0 2020/6/1
 */
public class T62_UniquePaths {

    public static void main(String[] args) {
//        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths2(51, 9));
    }

    // f(3, 2) = f(2, 2) + f(3, 1)

    // 直接这样写会超出时间限制

    static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    static int uniquePaths2(int m, int n) {

        int[][] table = initTable(m, n);
        if (m == 1 || n == 1) {
            return 1;
        }

        return dp(table, m - 1, n) + dp(table, m, n - 1);
    }

    private static int[][]  initTable(int m, int n) {
        int[][] table = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            table[i][1] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            table[1][i] = 1;
        }
        return table;
    }

    private static int dp(int[][] table, int m, int n) {
        if (table[m][n] == 0) {
            table[m][n] = dp(table, m - 1, n) + dp(table, m, n - 1);
        }
        return table[m][n];
    }


}
