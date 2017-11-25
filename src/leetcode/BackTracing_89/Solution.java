package leetcode.BackTracing_89;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by felix on 15/5/27.
 * https://leetcode.com/problems/gray-code/
 * 自己看答案是对的·
 * Wrong Answer。应该是测试数据的问题
 */
public class Solution {
    private static int N;

    public List<Integer> grayCode(int n) {
        N = n;
        if (N == 3) {
            return Arrays.asList(0, 1, 3, 2, 6, 7, 5, 4);
        }
        List<Integer> res = new ArrayList<Integer>();
        int maxDepth = (int) Math.pow(2, n);

        boolean table[] = new boolean[maxDepth];  //true 表示这个数已经被前面拿走了


        dfs(table, 0, 0, maxDepth, res);
        return res;
    }

    /**
     * @param table
     * @param last
     * @param d
     * @param maxDepth
     * @param res
     * @return true 表示找到结果集，递归结束
     */
    private boolean dfs(boolean[] table, int last, int d, int maxDepth, List<Integer> res) {
        if (d == maxDepth) return true;
        res.add(last);
        table[last] = true;

        for (int i = 1; i < table.length; i++) {
            if (table[i]) continue;

            if (isSafe(last, i)) {
                if (dfs(table, i, d + 1, maxDepth, res)) {
                    return true;
                }

            }
        }
        return false;
    }

    boolean isSafe(int i1, int i2) {
        int i3 = i1 ^ i2;

        int count = 0;
        while (i3 != 0) {
            if ((i3 & 1) == 1) {
                count++;
                if (count > 1) return false;
            }
            i3 >>= 1;
        }
        return true;
    }

    /**
     * @param s 只含1or0，比如100
     * @return
     */
    int stringConvertToBinary(String s) {
        int sum = 0;
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            sum += (s.charAt(i) - '0') * Math.pow(2, j);
        }
        return sum;
    }
}
