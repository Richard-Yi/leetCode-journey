package leetcode.self.study.slide_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @author Richard_Yi
 * @version 1.0 2020/5/6
 */
public class T438_FindAnagrams {

    // 这道题虽然套路也是滑动窗口，但是在自己在做的时候，还是有几个细节会弄混
    // 1. 变量名容易弄混，最好起成有一定含义的变量名
    // 2. 这里面还是先得到可行解，再优化可行解的套路。

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        int left, right;
        left = right = 0;

        Map<Character, Integer> toMatchMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            toMatchMap.put(p.charAt(i), toMatchMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        Map<Character, Integer> matchMap = new HashMap<>();

        int need = toMatchMap.size();
        int matched = 0;

        List<Integer> res = new ArrayList<>();

        while (right < s.length()) {

            char c = s.charAt(right);
            int count = matchMap.getOrDefault(c, 0) + 1;
            matchMap.put(c, count);
            if (toMatchMap.containsKey(c) && toMatchMap.get(c) == count) {
                matched++;
            }
            right++;

            while (need == matched) {
                // 这里因为是right++是先执行的，所以是right - left，而不是right - left + 1;
                if (right - left == p.length()) {
                    res.add(left);
                }

                char cLeft = s.charAt(left);
                int countLeft = matchMap.getOrDefault(cLeft, 0) - 1;
                matchMap.put(cLeft, countLeft);
                if (toMatchMap.containsKey(cLeft) && toMatchMap.get(cLeft) > countLeft) {
                    matched--;
                }
                left++;
            }


        }
        return res;
    }
}
