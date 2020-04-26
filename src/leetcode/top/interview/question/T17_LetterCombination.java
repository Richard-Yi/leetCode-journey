package leetcode.top.interview.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author Richard_Yi
 * @version 1.0 2020/4/26
 */
public class T17_LetterCombination {

    // https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/hui-su-suan-fa-xiang-jie-xiu-ding-ban

    // 要学习回溯算法的底层原理，思考思维（最好能手写出来）

    // 类似问题，八皇后、全排列

    public static void main(String[] args) {
        String digits = "345";
        System.out.println(letterCombinations(digits).toString());
    }

    public static List<String> letterCombinations(String digits) {

        Map<Character, char[]> telMap = new HashMap<>(8);
        telMap.put('2', new char[]{'a', 'b', 'c'});
        telMap.put('3', new char[]{'d', 'e', 'f'});
        telMap.put('4', new char[]{'g', 'h', 'i'});
        telMap.put('5', new char[]{'j', 'k', 'l'});
        telMap.put('6', new char[]{'m', 'n', 'o'});
        telMap.put('7', new char[]{'p', 'q', 'r', 's'});
        telMap.put('8', new char[]{'t', 'u', 'v'});
        telMap.put('9', new char[]{'w', 'x', 'y', 'z'});

        List<String> result = new ArrayList<>();
        backTrack(new StringBuilder(""), telMap, 0, digits, result);
        return result;
    }

    private static void backTrack(StringBuilder path, Map<Character, char[]> telMap,
                           int depth, String digits, List<String> result) {

        // 停止条件
        if (depth == digits.length()) {
            // 已经到底决策树的最底层
            result.add(path.toString());
            return;
        }

        char[] list = telMap.get(digits.charAt(depth));

        for (char c : list) {
            // 前置 做选择
            path.append(c);
            backTrack(path, telMap, depth + 1, digits, result);
            // 后置 撤销选择
            path.deleteCharAt(path.length() - 1);
        }

    }

    void backTrack(路径, 选择列表) {
        // 触发结束条件
        if(stop condition) {
            // do sth
            return;
        }

        // 遍历选择列表
        for 选择 in 选择列表 {
            // 排序不合法选择
            // 更新选择列表
            // 做选择
            路径.add(选择);

            backTrack(路径, 选择列表);
            // 撤销选择
            路径.remove(选择);
            // 选择列表更新
        }
    }
}
