package leetcode.Stack_20;

import java.util.Stack;

/**
 * Created by felix on 15/4/20.
 * https://leetcode.com/problems/valid-parentheses/
 */
public class Solution {


    /**
     * 时间太慢
     * Runtime: 228 ms
     */
    public boolean isValid(String s) {
        char[] brackets = new char[]{'(', ')', '{', '}', '[', ']'};
        boolean result = true;
        Stack<Character> stack = new Stack<Character>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (isleft(c)) {
                stack.push(c);
            } else if (isright(c)) {
                if (stack.isEmpty()) {
                    result = false;
                    break;
                } else {
                    if (isPair(stack.peek(), c)) {
                        stack.pop();
                    } else {
                        result = false;
                        break;
                    }

                }

            }

        }

        if (result && stack.isEmpty()) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }


    /**
     * 两个括号字符是否能组成一对
     */
    private boolean isPair(char top, char c) {
        return (top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']');
    }

    private boolean isright(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    private boolean isleft(char c) {
        return c == '(' || c == '{' || c == '[';
    }





}
