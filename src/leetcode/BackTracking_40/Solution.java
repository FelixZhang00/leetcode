package leetcode.BackTracking_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by felix on 15/6/17.
 * https://leetcode.com/problems/combination-sum-ii/
 * 题意：与#39 唯一的区别是不能重复选择candidates中的元素
 *  AC!
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            dfs(curSum,target,i+1,candi,item,res); //与#39相比，唯一需要修改的地方
            curSum-=candi[i];
            item.remove(item.size()-1);
        }
    }
}
