package leetcode.self.study.slide_window;

import java.util.HashMap;

/**
 *
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author Richard_Yi
 * @version 1.0 2020/5/6
 */
public class LongestSubString {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int left = 0, right = 0;

        HashMap<Character, Integer> window = new HashMap<>();
        int res = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;

            // condition
            while (window.get(c) > 1) {

                char c2 = s.charAt(left);
                window.put(c2, window.get(c2) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }

        return res;
    }
}
