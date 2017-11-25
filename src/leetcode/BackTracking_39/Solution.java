package leetcode.BackTracking_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by felix on 15/6/17.
 * <p/>
 * 思路：典型的回溯方法
 *
 * AC!
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        dfs(0, target, 0, candidates, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int curSum, int target, int d, int[] candi, ArrayList<Integer> item, ArrayList<List<Integer>> res) {
        if (curSum == target) {
            if(!res.contains(item)){        //防止重复的结果
                res.add(new ArrayList<Integer>(item));
            }
            return;
        } else if (curSum > target) {
            return;
        }

        //当前sum小于target的情况
        for (int i = d; i < candi.length; i++) {
            item.add(candi[i]);
            curSum+=candi[i];
            dfs(curSum,target,i,candi,item,res);
            curSum-=candi[i];
            item.remove(item.size()-1);
        }
    }
}
