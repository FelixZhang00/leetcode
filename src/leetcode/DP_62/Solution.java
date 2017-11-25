package leetcode.DP_62;

/**
 * Created by felix on 15/6/12.
 * https://leetcode.com/problems/unique-paths/
 * <p/>
 * 题意：
 * 有一个m*n的网格，有一个机器人在左上角，它的目的地在右下角，
 * 它只能向右或向下移动，问它到达目的地有多少条不同的路径。
 *
 * AC!
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int dp[] = new int[m * n];      //赋予每个格子一个编号，dp表示达到该位置的方法数
        for (int i = 0; i < m * n; i++) {   //遍历每个格子
            if ((i / n) == 0) {  //在网格的第一行
                dp[i] = 1;
            } else if ((i % n) == 0) {    //在网格的第一列
                dp[i] = 1;
            } else {      //中间
                dp[i] = dp[i - 1] + dp[i - n];     //到达当前位置的方法数有两种：由左来，由上来。
            }
        }
        return dp[m * n - 1];
    }
}
