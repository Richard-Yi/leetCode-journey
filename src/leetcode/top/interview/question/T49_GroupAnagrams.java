package leetcode.top.interview.question;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Richard_Yi
 * @version 1.0 2020/6/2
 */
public class T49_GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs).toString());
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] a = str.toCharArray();
            Arrays.sort(a);
            String sorted = Arrays.toString(a);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
