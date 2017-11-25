package leetcode.BackTracking_216;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 15/6/17.
 * https://leetcode.com/problems/combination-sum-iii/
 * <p/>
 * 相关题：#39、#40
 *
 * AC!
 */
public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        dfs(0, n, 1, k, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int curSum, int target, int d, int maxLen, ArrayList<Integer> item, ArrayList<List<Integer>> res) {
        if (item.size() > maxLen) return;

        if (curSum == target && item.size() == maxLen) {
            if (!res.contains(item)) {        //防止重复的结果
                res.add(new ArrayList<Integer>(item));
            }
            return;
        } else if (curSum > target) {
            return;
        }

        //当前sum小于target的情况
        for (int i = d; i <= 9; i++) {
            item.add(i);
            curSum += i;
            dfs(curSum, target, i + 1, maxLen, item, res); //与#39相比，唯一需要修改的地方
            curSum -= i;
            item.remove(item.size() - 1);
        }
    }
}
