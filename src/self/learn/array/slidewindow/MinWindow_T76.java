package self.learn.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Richard_yyf
 * @version 1.0 2021/5/24
 */
public class MinWindow_T76 {

    public static void main(String[] args) {
        System.out.println(new MinWindow_T76().minWindow("a", "aa"));
        System.out.println(new MinWindow_T76().minWindow("ADOBECODEBANC", "ABC"));

    }
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> target = new HashMap<>(t.length());

        for (int i = 0; i < t.length(); i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = t.length() - 1;
        int valid = 0;
        Map<Character, Integer> window = new HashMap<>(s.length());
        String targetStr = null;
        for(int i = 0; i < t.length(); i++) {
            if (target.containsKey(s.charAt(i))) {
                int count = window.getOrDefault(s.charAt(i), 0);
                if (count < target.get(s.charAt(i))) {
                    valid++;
                }
                window.put(s.charAt(i), count + 1);
            }
        }

        while (true) {
            if (valid == t.length()) {
                // 更新 targetStr
                if (targetStr == null || targetStr.length() > right - left + 1) {
                    targetStr = s.substring(left, right + 1);
                }
                // left 右移 right 不变
                if (target.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                    if (window.get(s.charAt(left)) < target.get(s.charAt(left))) {
                        valid--;
                    }
                }
                left++;
            } else if (valid < t.length()){
                // right 右移，left 不变
                if (right == s.length() - 1) {
                    break;
                }
                right++;
                if (target.containsKey(s.charAt(right))) {
                    int count = window.getOrDefault(s.charAt(right), 0);
                    if (count < target.get(s.charAt(right))) {
                        valid++;
                    }
                    window.put(s.charAt(right), count + 1);
                }
            }
        }

        return targetStr == null ? "" : targetStr;
    }

}
