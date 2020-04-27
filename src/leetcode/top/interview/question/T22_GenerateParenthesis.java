package leetcode.top.interview.question;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成：https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author Richard_Yi
 * @version 1.0 2020/4/27
 */
public class T22_GenerateParenthesis {

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));

    }

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        StringBuilder path = new StringBuilder();

        backTrack(path, n, n, 2 * n, result);

        return result;
    }

    private static void backTrack(StringBuilder path, int s1, int s2, int target, List<String> result) {
        if (s1 > s2) {
            // s1 s2是剩余的左右括号数，先左后右，剩下的左括号不可能大于右括号
            return;
        }

        if (s1 < 0) {
            return;
        }

        if (path.length() == target) {

            result.add(path.toString());
            return;
        }


        // 尝试放一个左括号
        path.append("(");
        backTrack(path, s1 - 1, s2, target, result);
        path.deleteCharAt(path.length() - 1);

        // 尝试放一个右括号
        path.append(")");
        backTrack(path, s1, s2 - 1, target, result);
        path.deleteCharAt(path.length() - 1);

    }

}
