package leetcode.BackTracing_78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by felix on 15/5/28.
 * https://leetcode.com/problems/subsets/
 * Accepted!
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, ArrayList<Integer> path, ArrayList<List<Integer>> res) {
        res.add(new ArrayList<Integer>(path));  //复制原来的集合到新集合

        for (int i = start; i < nums.length; i++) {  //从下一个位置遍历
            path.add(nums[i]);
            dfs(nums, i + 1, path, res);
            path.remove(path.size() - 1);//移除最后一个元素
        }
    }
}
