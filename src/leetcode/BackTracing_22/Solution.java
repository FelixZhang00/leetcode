package leetcode.BackTracing_22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 15/6/22.
 * https://leetcode.com/problems/generate-parentheses/
 * 题意：给定括号数，求所有有效的组合
 * <p/>
 * 思路：典型的回溯题
 *
 * AC!
 * Runtime: 232 ms
 * 速度还行
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        dfs(res, sb, n - 1, n, 2 * n);
        return res;

    }

    /**
     * @param res
     * @param sb
     * @param left   剩余的左括号数
     * @param right  剩余的右括号数
     * @param maxLen 最后list的长度
     */
    private void dfs(ArrayList<String> res, StringBuilder sb, int left, int right, int maxLen) {
        if (sb.length() == maxLen) {
            res.add(sb.toString());
            return;
        }

        if (left > 0) {
            sb.append("(");
            dfs(res, sb, left - 1, right, maxLen);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(")");
            dfs(res, sb, 0, right - 1, maxLen);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (left > 0 &&((maxLen/2-left)>(maxLen/2-right))) {          //当目前的左括号数>目前的右括号数时
            sb.append(")");
            dfs(res, sb, left, right - 1, maxLen);
            sb.deleteCharAt(sb.length() - 1);
        }


    }

    private boolean verify(StringBuilder sb) {

        return true;
    }
}
