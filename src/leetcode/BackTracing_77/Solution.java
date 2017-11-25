package leetcode.BackTracing_77;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 15/6/16.
 * https://leetcode.com/problems/combinations/
 * <p/>
 * 题意：排列组合题，从1~n中选出k个的所有可能（[4,2]和[2,4]只能算一个）
 * <p/>
 * 思路：
 * 与#46类似
 * AC!
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        dfs(1, n, k, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int d, int max, int maxLen, ArrayList<Integer> item, ArrayList<List<Integer>> res) {
        if (item.size() == maxLen) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = d; i <= max; i++) {
            item.add(i);
            dfs(i + 1, max, maxLen, item, res);
            item.remove(item.size() - 1);
        }
    }


}
