package leetcode.BinarySearch_74;

/**
 * Created by felix on 15/6/16.
 * <p/>
 * https://leetcode.com/problems/search-a-2d-matrix/
 * <p/>
 * 题意：利用matrix的一些特性，高效地查找target是否存在
 * <p/>
 * 思路：用二分查找
 * 关键问题：如何找target对应的行号
 * <p/>
 * AC!
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        //①查找target所在行
        int loRow = 0, hiRow = matrix.length - 1;
        int targetRow = 0;
        while (loRow <= hiRow) {
            int midRow = loRow + (hiRow - loRow) / 2;

            if (matrix[midRow][0] < target) {
                targetRow = midRow;
                loRow = midRow + 1;
            } else if (matrix[midRow][0] > target) {
                hiRow = midRow - 1;
            } else return true;
        }


        //②在已知的行中查找列
        int lo = 0, hi = matrix[targetRow].length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (matrix[targetRow][mid] < target) lo = mid + 1;
            else if (matrix[targetRow][mid] > target) hi = mid - 1;
            else return true;
        }

        return false;
    }
}
