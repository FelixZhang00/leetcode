package leetcode.HashTable_36;

import java.util.Hashtable;

/**
 * Created by felix on 15/4/6.
 * https://leetcode.com/problems/valid-sudoku/
 * <p/>
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        int n = board.length ;//判断n*n的方格
        Hashtable<Character, Boolean> table;

        //判断每一行是否为有效的数独
        for (int row = 0; row < n; row++) {
            table = new Hashtable<Character, Boolean>();
            for (int col = 0; col < n; col++) {
                char temp = board[row][col];
                if (temp != '.' && table.containsKey(temp)) { // . 代表空格
                    return false;
                } else {
                    table.put(temp, true);
                }
            }
        }

        //判断每一列是否为有效的数独
        for (int col = 0; col < n; col++) {
            table = new Hashtable<Character, Boolean>();
            for (int row = 0; row < n; row++) {
                char temp = board[row][col];
                if (temp != '.' && table.containsKey(temp)) { // . 代表空格
                    return false;
                } else {
                    table.put(temp, true);
                }
            }

        }

        //判断子方框是否为有效的数独
        int subLen = (int) Math.sqrt(n);
        for (int i = 0; i < subLen; i++) {  //子方格的行编号
            for (int j = 0; j < subLen; j++) { //子方格的列编号

                table = new Hashtable<Character, Boolean>();
                for (int colSub = i * subLen; colSub < (i + 1) * subLen; colSub++) {
                    for (int rowSub = j * subLen; rowSub < (j + 1) * subLen; rowSub++) {
                        char temp = board[rowSub][colSub];
                        if (temp != '.' && table.containsKey(temp)) { // . 代表空格
                            return false;
                        } else {
                            table.put(temp, true);
                        }
                    }
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board=new char[2][3];
        System.out.print(board.length);  //输出2 二维数组的length返回第一维的长度
    }

}
