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

        Map<Character, Integer> targetMap = new HashMap<>(t.length());
        Map<Character, Integer> windowMap = new HashMap<>(t.length());

        // 初始化 targetMap
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }


        // 初始化
        int left = 0;
        int right = t.length() - 1;
        int matchCount = 0;
        for (int i = 0; i <= right; i++) {
            if (targetMap.containsKey(s.charAt(i))) {
                // 如果包含则放进去，并且+1
                windowMap.put(s.charAt(i), windowMap.getOrDefault(s.charAt(i), 0) + 1);
                if (windowMap.get(s.charAt(i)) <= targetMap.get(s.charAt(i))) {
                    // 如果+1了之后，小于等于目标数量，则说明 +1有效
                    matchCount++;
                }
            }
        }

        // 最小窗口的left
        int minWindowStart = 0;
        int minWindowSize = Integer.MAX_VALUE;
        while (true) {
            if (matchCount == t.length()) {
                // 满足条件，判断再更新
                if (right - left + 1 < minWindowSize) {
                    minWindowStart = left;
                    minWindowSize = right - left + 1;
                }
                // right 不变，left 右移
                if (targetMap.containsKey(s.charAt(left))) {
                    windowMap.put(s.charAt(left), windowMap.getOrDefault(s.charAt(left), 0) - 1);
                    // 如果 -1了之后，小于目标数量，则说明 -1 有效
                    if (windowMap.get(s.charAt(left)) < targetMap.get(s.charAt(left))) {
                        matchCount--;
                    }
                }
                left++;
            } else if (matchCount < t.length()) {
                if (right == s.length() - 1) {
                    break;
                }

                // 不满足，right 右移，left不动
                right++;
                if (targetMap.containsKey(s.charAt(right))) {
                    windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right), 0) + 1);
                    if (windowMap.get(s.charAt(right)) <= targetMap.get(s.charAt(right))) {
                        // 如果+1了之后，小于等于目标数量，则说明 +1有效
                        matchCount++;
                    }
                }
            }
        }
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(minWindowStart, minWindowStart + minWindowSize);
    }
}
