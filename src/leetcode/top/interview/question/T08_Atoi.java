package leetcode.top.interview.question;

/**
 * @author Richard_yyf
 * @version 1.0 2020/6/19
 */
public class T08_Atoi {

    public static void main(String[] args) {
        System.out.println(myatoi("-123456"));
    }

    static int myatoi(String str) {
        char[] array = str.toCharArray();
        int n = array.length;
        int idx = 0;
        while (idx < n && array[idx] == ' ') {
            // trim
            idx++;
        }
        if (idx == n) {
            // if end return 0
            return 0;
        }
        boolean negative = false;
        if (array[idx] == '-') {
            // negative
            negative = true;
            idx++;
        } else if (array[idx] == '+'){
            idx++;
        } else if (!Character.isDigit(array[idx])) {
            // 非数字
            return 0;
        }

        int ans = 0;
        while (idx < n && Character.isDigit(array[idx])) {
            int digit = array[idx] - '0';
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > 7)) {
                // 越界，注意这里是ans 还一直是正值
                // [-2147483648, 2147483647]
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;

            idx++;
        }
        return negative ? -ans : ans;
    }
}
