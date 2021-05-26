package self.learn.slidewindow;

import java.util.HashMap;

/**
 * @author Richard_yyf
 * @version 1.0 2021/5/26
 */
public class LengthOfLongestSubstring_T3 {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring_T3().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        // 需要一个连续的包含不重复字符的窗口

        // 当下一个元素为重复元素时，窗口变化前先记录更新最长子串

        // left 右移，直到没有重复元素

        if (s.length() <= 1) {
            return s.length();
        }

        int resultLen = 1;
        int left = 0;
        int right = 1;
        HashMap<Character, Integer> windowMap = new HashMap<>();
        windowMap.put(s.charAt(0), 0);
        while (right < s.length()) {
            if (windowMap.containsKey(s.charAt(right))) {
                // 如果存在，left移动到已存在元素下标+1的位置
                // NOTICE!!!! left移动到Math.max("已存在元素下标+1的位置", left)
                left = Math.max(windowMap.get(s.charAt(right)) + 1, left);
            }
            windowMap.put(s.charAt(right), right);
            resultLen = Math.max(right - left + 1, resultLen);
            right++;
        }

        return resultLen;
    }
}
