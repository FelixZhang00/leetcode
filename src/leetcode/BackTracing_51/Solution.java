package leetcode.BackTracing_51;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 15/5/6.
 * https://leetcode.com/problems/n-queens/
 * <p/>
 * 错误解法
 */
public class Solution {


    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();

        boolean grid[][] = new boolean[n][n];

        brackTracing(grid, res, 0);

        return res;
    }


    /**
     * @param grid
     * @param res
     * @param d
     */
    void brackTracing(boolean grid[][], List<String[]> res, int d) {
        if (d == grid.length) {
            res.add(generate(grid));
            return;
        }

        int N = grid.length;
        for (int j = 0; j < N; j++) {
            grid[d][j] = true;            //放个皇后试试

            if (!checkAttack(grid, d)) {     //检查当前皇后的位置和之前的位置是否冲突，如果不冲突的话，继续找下一个皇后的位置
                brackTracing(grid, res, d + 1);
            }

            grid[d][j] = false;           //取消当前皇后的位置
        }


    }


    /**
     * 判断两个皇后是否碰撞
     *
     * @param n n*n的格子
     * @param x 皇后位置
     * @param y 皇后位置
     * @return true 会碰撞
     */
    boolean isAttacked(int n, int x, int y) {

        if (x % n == y % n) return true;
        if (x / n == y / n) return true;

        //判断斜线
        int height = Math.abs(x / n - y / n);
        int width = Math.abs(x % n - y % n);
        if (height == width) return true;
        else return false;
    }


    /**
     * 生成结果集
     *
     * @return
     */
    String[] generate(boolean grid[][]) {
        int N = grid.length;

        StringBuilder[] resSb = new StringBuilder[N];
        for (int i = 0; i < N; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if (grid[i][j]) {
                    s.append('Q');
                } else {
                    s.append('.');
                }
            }
            resSb[i] = s;
        }

        String[] resStr = new String[N];
        for (int i = 0; i < N; i++) {
            resStr[i] = resSb[i].toString();
        }
        return resStr;
    }


    /**
     * @param grid
     * @param d    当前皇后们所在的最大深度
     * @return true 当前所有皇后会碰撞
     */
    public boolean checkAttack(boolean[][] grid, int d) {
        int N = grid.length;

        int x = 0;
        for (int j = 0; j < N; j++) {
            if (grid[0][j]) {        //找到第一个皇后的位置
                x = j;
                break;
            }
        }

        for (int i = 1; i <= d; i++) {
            int y = 0;
            for (int j = 0; j < N; j++) {
                if (grid[i][j]) {    //找到另一个皇后的位置
                    y = i * N + j;
                    break;
                }
            }
            if (isAttacked(N, x, y)) {
                return true;
            } else {
                x = y;
            }
        }
        return false;
    }


}
