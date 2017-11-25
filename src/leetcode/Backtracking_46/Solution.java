package leetcode.Backtracking_46;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by felix on 15/6/16.
 * https://leetcode.com/problems/permutations/
 * <p/>
 * 题意：给一串数字，求出所有排列组合
 * <p/>
 * AC!
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        dfs(nums, 0, new ArrayList<Integer>(),new HashMap<Integer,Boolean>(), res);
        return res;
    }

    /**
     * @param nums
     * @param d
     * @param item
     * @param map 对访问过的元素做标记
     * @param res
     */
    private void dfs(int[] nums, int d, ArrayList<Integer> item, HashMap<Integer, Boolean> map, ArrayList<List<Integer>> res) {
        if (d == nums.length) {
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(i)){
                item.add(nums[i]);
                map.put(i,true);
                dfs(nums, d + 1, item, map, res);
                map.remove(i);
                item.remove(item.size() - 1);
            }
        }

    }

}
