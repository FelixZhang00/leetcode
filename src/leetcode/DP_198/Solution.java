package leetcode.DP_198;

/**
 * Created by felix on 15/5/9.
 * <p/>
 * https://leetcode.com/problems/house-robber/
 * <p/>
 * <p/>
 * <p/>
 * 参考：
 * <p/>
 * 状态转移方程：
 * <p/>
 * dp[i] = max(dp[i - 1], dp[i - 2] + num[i - 1])
 * <p/>
 * 其中，dp[i]表示打劫到第i间房屋时累计取得的金钱最大值。
 * 注意dp[0]=0,dp[1]=nums[0]，dp[size]的含义
 */
public class Solution {

    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 0) return 0;
        if (size == 1) return nums[0];

        int dp[] = new int[size + 1];
        dp[1] = nums[0];
        for (int i = 2; i < size + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[size];
    }
}
