package leetcode.DP_70;

/**
 * Created by felix on 15/5/9.
 * <p/>
 * https://leetcode.com/problems/climbing-stairs/
 * <p/>
 * 题目：你在爬楼梯。需要 n 步才能到顶部。
 * 每次你爬1 或 2 步。有多少种独立的爬到顶部的方式？
 */
public class Solution {
    public int climbStairs(int n) {

        int dp[] = new int[n + 1];  //dp[i]表示到达i位置时，共有几种不同的方法
        dp[0] = 1;                  //上梯子之前的初始态
        dp[1] = 1;
        if (n == 1) return dp[1];
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
