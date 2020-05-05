package leetcode.top.interview.question;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author Richard_yyf
 * @version 1.0 2020/5/5
 */
public class T20_ValidBrackets {

    public static void main(String[] args) {
        System.out.println(isValid("(())"));
    }

    private static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (isLeftBracketChar(t)) {
                stack.push(t);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (getRightPairedChar(stack.peek()) == t) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static char getRightPairedChar(char s) {
        if (s == '(') {
            return ')';
        }
        if (s == '[') {
            return ']';
        }
        if (s == '{') {
            return '}';
        }
        throw new IllegalArgumentException();
    }

    private static boolean isLeftBracketChar(char s) {
        return s == '(' || s == '{' || s == '[';
    }

}
