package leetcode.top.interview.question;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author Richard_yyf
 * @version 1.0 2020/3/25
 */
public class T05_LongestPalindrome {

    public static void main(String[] args) {

    }

    // 1. 用两个下标标识 最长回文串 的左下标 右下标

    // 2. 思考啥时候更新？

    // 3.

    // 方法1： 穷举所有的组合，然后判断是不是回文字符串 O(n^3)
    // 提交失败：Time Limit Exceeded

    public String longestPalindrome1(String s) {

        if (s.length() < 2) {
            return s;
        }

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }

        return longest;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // 中心扩散法

    // 一个遍历的指针，再以指针为中心两边扩散

    // 遍历每一个索引，以这个索引为中心，利用“回文串”中心对称的特点，往两边扩散，看最多能扩散多远

    // 奇数 回文串和 偶数 回文串的区别

    public String longestPalindrome2(String s) {
        int len = s.length();

        if (len < 2) {
            return s;
        }

        String ans = s.substring(0, 1);

        for (int i = 0; i < len - 1; i++) {

            // 把奇数和偶数回文串分开考虑
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);

            String longest = oddStr.length() > evenStr.length() ? oddStr : evenStr;

            if (longest.length() > ans.length()) {
                ans = longest;
            }
        }

        return ans;
    }

    private String centerSpread(String s, int i, int j) {

        int left = i;
        int right = j;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }

        return s.substring(left + 1, right);
    }
}
