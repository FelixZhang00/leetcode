package leetcode.Greedy_45;

/**
 * Created by felix on 15/6/20.
 *
 * 输入太大时会报错：StackOverflowError
 */
public class Solution2 {
    private int minJumps = Integer.MAX_VALUE;

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        dfs(nums, 0, 0);
        return minJumps;
    }

    /**
     * @param nums
     * @param jumps 记录到达位置loc时总的跳数
     * @param loc 当前位置
     */
    private void dfs(int[] nums, int jumps, int loc) {
        if (loc >= nums.length - 1) { //说明已经可以达到终点
            minJumps = Math.min(minJumps, jumps);
            return;
        }
        int nextLoc=loc+nums[loc];
        if (nextLoc==loc) return;

        dfs(nums,jumps+1,nextLoc);


    }
}
