package leetcode.BackTracing_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by felix on 15/4/14.
 * https://leetcode.com/problems/combination-sum/
 */
public class Solution {


    /**
     * Solution1:
     * 参考：
     * 基本思路是先排好序，然后每次递归中把剩下的元素一一加到结果集合中，
     * 并且把目标减去加入的元素，然后把剩下元素（包括当前加入的元素）放到下一层递归中解决子问题。
     * 算法复杂度因为是NP问题，所以自然是指数量级的。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);

        combinationSumSelf(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void combinationSumSelf(int[] candidates, int target, int start, ArrayList<Integer> item, List<List<Integer>> res) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1])
                continue;
            item.add(candidates[i]);
            combinationSumSelf(candidates, target - candidates[i], i, item, res);
            item.remove(item.size() - 1);
        }
        
    }


}
