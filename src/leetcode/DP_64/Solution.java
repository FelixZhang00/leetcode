package leetcode.DP_64;

/**
 * Created by felix on 15/6/14.
 * https://leetcode.com/problems/minimum-path-sum/
 * <p/>
 * 和62题类似
 * <p/>
 * 状态方程
 * DP，f[i][j] = min(f[i-1][j], f[i][j-1]) + a[i][j]
 * 调bug
 * AC!
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int N = rows * cols;
        int[] dp = new int[N];

        int idx = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0) {
                    if (c == 0) {   //第一行第一个元素
                        dp[idx] = grid[r][c];
                    } else {
                        dp[idx] = grid[r][c] + dp[idx - 1];
                    }
                } else if (c == 0) {        //从第二行开始的第一列元素
                    dp[idx] = grid[r][c] + dp[idx-cols];
                } else {        //中间的元素
                    dp[idx] = grid[r][c] + Math.min(dp[idx - 1], dp[idx - cols]); //从当前位置的左边或上边选一个迄今为止路程最小的
                }


                idx++;
            }
        }


//        for (int item : dp) {
//            System.out.print(item+",");
//        }
        return dp[idx - 1];
    }

    public int calcLength(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        return rows * cols;
    }


}
