package leetcode.DP_63;

/**
 * Created by felix on 15/6/16.
 * <p/>
 * https://leetcode.com/problems/unique-paths-ii/
 * <p/>
 * 题意：
 * 在#62的基础上加上障碍物
 * AC!
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;      //行数
        int n = obstacleGrid[0].length;   //列数

        int dp[][] = new int[m][n];

        //obstacleGrid与dp中检查是否有障碍物并不一样
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0) {    //在网格中的第一行
                    if (obstacleGrid[r][c] == 0) {  //没有障碍物
                        if (c != 0 && dp[r][c - 1] != 0) {   //前面也没有障碍物
                            dp[r][c] = 1;
                        } else if (c == 0) {
                            dp[r][c] = 1;
                        }
                    }
                } else if (c == 0) { //在网格的第一列
                    if (obstacleGrid[r][c] == 0) {   //没有障碍物
                        if (r != 0 && dp[r - 1][c] != 0) {   //上面也没有障碍物
                            dp[r][c] = 1;
                        } else if (r == 0) {
                            dp[r][c] = 1;
                        }
                    }
                } else { //中间
                    if (obstacleGrid[r][c] == 0) {  //没有障碍物
                        //到达当前位置的方法数有两种：由左来，由上来。
                        //检查左边或右边是否有障碍物（即是否为0）
                        if (dp[r][c - 1] != 0) {
                            dp[r][c] += dp[r][c - 1];
                        }
                        if (dp[r - 1][c] != 0) {
                            dp[r][c] += dp[r - 1][c];
                        }
                    }
                }
            }
        }

        return dp[m - 1][n - 1];

    }


}
