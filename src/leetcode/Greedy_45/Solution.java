package leetcode.Greedy_45;

/**
 * Created by felix on 15/6/19.
 * https://leetcode.com/problems/jump-game-ii/
 * 题意：在#55的基础上，求跳到终点最少的jumps
 * <p/>
 * 参考：http://www.cnblogs.com/ganganloveu/p/3761715.html
 *
 * AC!
 */
public class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int curLoc = 0;   //从nums[0]进行jumps次跳跃之后达到的最大位置
        int maxLoc = 0;   //从0~i这i+1个nums元素中能达到的最大位置
        for (int i = 0; i < nums.length; i++) {
            if (curLoc < i) {
                //说明jumps次已经不足以覆盖当前第i个元素，因此需要增加一次jump，使之达到
                //maxLoc
                jumps++;
                curLoc=maxLoc;
            }
            maxLoc=Math.max(maxLoc,nums[i]+i);
        }

        return jumps;
    }
}
