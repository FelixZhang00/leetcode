package leetcode.BackTracing_52;

import java.util.ArrayList;

/**
 * Created by felix on 15/6/12.
 * https://leetcode.com/problems/n-queens-ii/
 *  AC!
 *  Runtime: 216 ms
 */
public class Solution {
    public int totalNQueens(int n) {
        ArrayList<String[]> ret = new ArrayList<String[]>();
        int[] queenList = new int[n];
        placeQueen(queenList, 0, n, ret);
        return ret.size();
    }
    // 递归回溯8皇后，关键记录下到达了哪一行了
    public static void placeQueen(int[] queenList, int row, int n, ArrayList<String[]> ret){
        // Base Case, 已经完成任务了
        if(row == n){
            StringBuilder[] sol = new StringBuilder[n];

            // 对数组内每一个对象都要new出其对象
            for(int i=0; i<n; i++){
                sol[i] = new StringBuilder();
                for(int j=0; j<n; j++){
                    sol[i].append(".");
                }
            }
            // 在相应的地方放置queen
            for(int i=0; i<n; i++){
                sol[i].setCharAt(queenList[i], 'Q');
            }
            String[] ss = new String[n];
            for (int i=0; i<n; i++) {
                ss[i] = sol[i].toString();
            }
            ret.add(ss);
            return;
        }

        // 开始这一行的查找
        // 遍历第row行的所有列，测试哪一个位置是安全的
        for(int col=0; col<n; col++){
            if(isSafe(queenList, row, col)){
                queenList[row] = col;
                placeQueen(queenList, row+1, n, ret);
            }
        }
    }

    // 判断是否坐标(row,col)的位置是安全的（检查行，列，正反对角线）
    // queenList里面存放行，列坐标pair，即queenList[row] = col
    public static boolean isSafe(int[] queenList, int row, int col){
        for(int preRow=0; preRow<row; preRow++){
            int preCol = queenList[preRow];
            if(preRow == row){      // 理论上不必检查，因为preRow是总是小于row的
                return false;
            }
            if(preCol == col){          // 检查是否在同一列
                return false;
            }
            if(row-preRow == col-preCol){       // 反对角线
                return false;
            }
            if(preRow+preCol == row+col){       // 正对角线
                return false;
            }
        }
        return true;
    }
}
