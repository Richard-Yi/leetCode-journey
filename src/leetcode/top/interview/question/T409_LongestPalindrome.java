package leetcode.top.interview.question;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Richard_yyf
 * @version 1.0 2020/5/24
 */
public class T409_LongestPalindrome {

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    static int longestPalindrome(String s) {
        int pair = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0) + 1;
            if (count == 2) {
                pair++;
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }
        return (pair * 2) + (map.size() > 0 ? 1 : 0);
    }
}
