package leetcode.self.study.slide_window;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口练习题
 * <p>
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @author Richard_yyf
 * @version 1.0 2020/5/5
 */
public class MinWindow {

    public static void main(String[] args) {
        System.out.println(minWindow2("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow2("cabwefgewcwaefgcf", "cae"));
        System.out.println(minWindow2("a", "a"));
    }

    private static String minWindow2(String s, String t) {

        int left = 0;
        int right = 0;

        Map<Character, Integer> tMap = getTargetMap(t);
        Map<Character, Integer> cMap = new HashMap<>();

        int toMeet = tMap.size();
        int met = 0;

        int[] res = {-1, 0, 0};

        while (right < s.length()) {
            char c = s.charAt(right);
            int count = cMap.getOrDefault(s.charAt(right), 0) + 1;
            cMap.put(c, count);

            if (tMap.containsKey(c) && tMap.get(c) == count) {
                met++;
            }

            while (left <= right && met == toMeet) {
                // 更新res
                if (res[0] == -1 || right - left + 1 < res[0]) {
                    res[0] = right - left + 1;
                    res[1] = left;
                    res[2] = right;
                }

                char temp = s.charAt(left);
                int tempCount = cMap.getOrDefault(temp, 0) - 1;
                cMap.put(temp, tempCount);
                if (tMap.containsKey(temp) && tMap.get(temp) > tempCount) {
                    met--;
                }

                // left 右移
                left++;
            }

            right++;
        }
        return res[0] == -1 ? "" : s.substring(res[1], res[2] + 1);
    }

    private static String minWindow(String s, String t) {

        int left = 0;
        int right = 0;
        String res = "";

        Map<Character, Integer> tMap = getTargetMap(t);
        Map<Character, Integer> cMap = new HashMap<>();

        while (right < s.length()) {
            // 窗口
            cMap.put(s.charAt(right), cMap.getOrDefault(s.charAt(right), 0) + 1);

            // 开始优化窗口
            while (matchTarget(cMap, tMap)) {
                // 每当left 移动，更新res
                // 注意，最小子串才会更新！！！
                String temp = s.substring(left, right + 1);
                if (res.length() == 0 || temp.length() < res.length()) {
                    res = temp;
                }
                cMap.put(s.charAt(left), cMap.get(s.charAt(left)) - 1);
                left++;
            }
            // 窗口还没有满足
            right++;
        }

        return res;
    }

    private static boolean matchTarget(Map<Character, Integer> cMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (entry.getValue() > cMap.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> getTargetMap(String t) {
        Map<Character, Integer> map = new HashMap<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        return map;
    }
}
