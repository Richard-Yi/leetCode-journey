package self.learn.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目14: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
 * 示例1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 *
 * @author Richard_yyf
 * @version 1.0 2021/4/14
 */
public class LongestCommonPrefix_14 {


    public static void main(String[] args) {
//        String[] array = new String[]{"flower", "flow", "flight"};
//        String[] array = new String[]{"c","acc","ccc"};
//        String[] array = new String[]{"dog", "racecar", "car"};
        String[] array = new String[]{"aaa","aa","aaa"};
        System.out.println(longestCommonPrefix(array));
        System.out.println(longestCommonPrefix2(array));
    }

    public static String longestCommonPrefix2(String[] array) {
        if (array.length == 0) {
            return "";
        }

        String str = array[0];
        if (str.length() < 1) {
            return "";
        }

        int end = str.length();
        for (int i = 1; i < array.length; i++) {
            String nowStr = array[i];
            if (nowStr.length() == 0) {
                return "";
            }

            int tempEnd = 0;
            int l = Math.min(str.length(), nowStr.length());
            for (int j = 0; j < l; j++) {
                if (str.charAt(j) == nowStr.charAt(j)) {
                    tempEnd++;
                } else {
                    break;
                }

            }
            end = Math.min(tempEnd, end);
            if (end == 0) {
                return "";
            }

            if (nowStr.length() < str.length()) {
                str = nowStr;
            }
        }

        return str.substring(0, end);
    }

    public static String longestCommonPrefix(String[] array) {
        if (array.length == 0) {
            return "";
        }
        Map<Integer, Character> map = null;
        int end = 0;
        for(int i = 0; i < array.length; i++) {
            String ele = array[i];
            if (ele.length() == 0) {
                // TODO 这个是容易忽略一点，为空字符串的时候应该直接返回空
                return "";
            }
            if (map == null) {
                map = new HashMap<>(ele.length());
                for(int j = 0; j < ele.length(); j++) {
                    map.put(j, ele.charAt(j));
                    end = ele.length();
                }
            } else {
                int tempEnd = 0;
                for(int j = 0; j < ele.length(); j++) {
                    // TODO 要判空
                    if(map.get(j) != null && map.get(j) == ele.charAt(j)) {
                        tempEnd++;
                    } else {
                        break;
                    }
                }

                end = Math.min(end, tempEnd);

            }
        }

        return array[0].substring(0, end);
    }


}
