package leetcode.Greedy_55;

/**
 * Created by felix on 15/6/18.
 * https://leetcode.com/problems/jump-game/
 * <p/>
 * 思路：遍历数组，用maxLoc记录迄今位置能走到的最远的位置，nextMaxLoc记录下一个最远的位置，
 * 每次遍历时都判断下 是否还能再跳下去？ 是否已经至少能跳到终点了
 *
 * AC!在Java中排名前列。
 */
public class Solution {

    public boolean canJump(int[] nums) {
        if (nums.length==1) return true;

        int maxLoc = 0;   //最远能到的位置索引
        for (int i = 0; i < nums.length; i++) {
            int nextMaxLoc = i + nums[i];
            if (nextMaxLoc > maxLoc) {
                maxLoc = nextMaxLoc;
            }

            //再也无法往下走了
            if (nextMaxLoc == i && maxLoc == i) return false;

            if (maxLoc >= nums.length - 1) {    //是否已经至少能跳到终点了
                return true;
            }
        }
        return false;
    }
}
