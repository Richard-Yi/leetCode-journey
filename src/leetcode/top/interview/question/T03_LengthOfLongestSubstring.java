package leetcode.top.interview.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
 *
 * @author Richard_yyf
 * @version 1.0 2020/3/9
 */
public class T03_LengthOfLongestSubstring {

    // 菜鸡的我，第一想法就是暴力
    // 暴力都不知道怎么暴力。。。

    // 双指针？

    // 题目思路
    // 1. 这个无重复的意思是说，这个子序列里面都是unique的
    // 2.


    // 滑动窗口！！
    // 维护一个滑动窗口，窗口内的都是没有重复的字符，去尽可能的扩大窗口的大小，窗口不停的向右滑动。

    public int lengthOfLongestSubstring_real(String s) {
        HashMap<Character, Integer> uniques = new HashMap<>(s.length());

        int length = 0;
        // 滑动窗口的左下标
        int i = 0;
        // j - 滑动窗口的右下标
        for (int j = 0; j < s.length(); j++) {
            if (uniques.containsKey(s.charAt(j))) {
                // 存在
                i = uniques.get(s.charAt(j)) + 1;
            } else {
                // 不存在
                uniques.put(s.charAt(j), j);
                length = j - i + 1;
            }
        }

        return length;
    }

    public int lengthOfLongestSubstring_violent(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int length = 1;
        int i = 0, j = 1;

        while (j < s.length()) {
            if (allUnique(s, i, j)) {
                int newLength = j - i + 1;
                if (newLength > length) {
                    length = newLength;
                    i = j + 1;
                    j++;
                }
            } else {
                i++;
            }
            j++;
        }
        return length;
    }

    private boolean allUnique(String s, int i, int j) {
        HashSet<Character> set = new HashSet<>();
        for (int k = i; k <= j; k++) {
            if (set.contains(s.charAt(k))) {
                return false;
            }
            set.add(s.charAt(k));
        }
        return true;
    }
}
