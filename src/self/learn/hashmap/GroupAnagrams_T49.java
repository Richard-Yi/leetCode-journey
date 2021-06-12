package self.learn.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * tag: hash map, sort
 * 难度：mid
 * @author Richard_yyf
 * @version 1.0 2021/6/12
 */
public class GroupAnagrams_T49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String temp = Arrays.toString(arr);
            List<String> group = map.computeIfAbsent(temp, k -> new ArrayList<>());
            group.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
