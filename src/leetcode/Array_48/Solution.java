package leetcode.Array_48;

/**
 * Created by felix on 15/6/15.
 * https://leetcode.com/problems/rotate-image/
 * <p/>
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise). 顺时针
 * <p/>
 * 思路：先用笨办法，用一个辅助数组
 * AC!
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int aux[][] = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                aux[c][rows-1-r]=matrix[r][c];
            }
        }

        //复制回去
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
               matrix[r][c]=aux[r][c];
            }
        }
    }


}
