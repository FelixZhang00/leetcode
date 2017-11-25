package leetcode.BackTracing_78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by felix on 15/5/28.
 */
public class Solution2 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(path));   //复制原来的集合到新集合

        for (int i = index; i < s.length; i++) {        //从某个位置遍历
            path.add(s[i]);
            dfs(s, i + 1, path, result);
            path.remove(path.size() - 1);       //移除最后一个元素
        }
    }

}
