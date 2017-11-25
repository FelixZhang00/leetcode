package leetcode.BackTracing_51;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 15/5/6.
 * <p/>
 * 思路：用一个一维数组存放皇后所在位置，
 * 从第0行开始
 * Accepted！
 */
public class Solution2 {

    public List<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        int[] queenList = new int[n];     //索引表示皇后所在行号，值表示列号
        placeQueens(queenList, n, 0, res);
        return res;

    }

    private void placeQueens(int[] queenList, int n, int row, ArrayList<String[]> res) {
        if (row == n) {      //n行都安全放置了皇后，现在该向结果集中写数据了
            res.add(generate(queenList, n));
            return;
        }

        for (int col = 0; col < n; col++) {       //对当前行d，检查当前放置皇后的位置是否安全
            if (isSafe(queenList, row, col)) {
                queenList[row] = col;
                placeQueens(queenList, n, row + 1, res);
            }
        }

    }

    /**
     * 循环0~row之间的所有行，
     * 每次和（row，col）这个位置比较，看是否有冲突
     *
     * @return
     */
    private boolean isSafe(int[] queenList, int row, int col) {
        for (int preRow = 0; preRow < row; preRow++) {      //遍历row之前的所有行
            if (preRow == row) return false;
            if (queenList[preRow] == col) return false;

            //对角线
            int h = Math.abs(row - preRow);
            int w = Math.abs(col - queenList[preRow]);
            if (h == w) return false;
        }

        return true;
    }

    /**
     * 生成结果集
     *
     * @return
     */
    String[] generate(int[] queenList, int n) {
        StringBuilder[] sb = new StringBuilder[n];

        for (int i = 0; i < n; i++) {
            sb[i] = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb[i].append('.');
            }
        }
        for (int i = 0; i < n; i++) {           //在相应位置上放置Q
            sb[i].setCharAt(queenList[i], 'Q');
        }

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = sb[i].toString();
        }
        return result;
    }


}
