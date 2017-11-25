package leetcode.Array_73;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by felix on 15/6/16.
 * https://leetcode.com/problems/set-matrix-zeroes/
 * <p/>
 * 题意：遍历二维数组，如果一个元素为0，则设置该元素所对的行和列都置为0.
 * 如果直接在本地修改的话，要注意考虑先后顺序，否则最后数组的元素全为0
 *
 * AC!
 * Runtime: 412 ms
 */
public class Solution {

    enum TYPE {
        ROW, COL
    }

    //用于记录更新数组的某行或某列
    class Pair {
        TYPE type;  //行或列
        int var;    //行号或列好

        public Pair(TYPE t, int i) {
            type=t;
            var=i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (var != pair.var) return false;
            return type == pair.type;

        }

        @Override
        public int hashCode() {
            int result = type != null ? type.hashCode() : 0;
            result = 31 * result + var;
            return result;
        }
    }

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        Set<Pair> set = new HashSet<Pair>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    set.add(new Pair(TYPE.ROW, r));
                    set.add(new Pair(TYPE.COL, c));
                }
            }
        }

        for (Pair pair : set) {
            if (pair.type==TYPE.ROW){
                for (int c = 0; c < cols; c++) {
                    matrix[pair.var][c]=0;
                }
            }else{
                for (int r = 0; r < rows; r++) {
                    matrix[r][pair.var]=0;
                }
            }
        }


    }

}
