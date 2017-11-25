package leetcode.Array_118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by felix on 15/4/4.
 * <p/>
 * https://leetcode.com/problems/pascals-triangle/
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 0) throw new IllegalArgumentException();

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) return result;

        int first, second;
        List<Integer> oldRowResult = Arrays.asList(1);
        result.add(0, oldRowResult);
        for (int i = 1; i < numRows; i++) {
            List<Integer> rowResult = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                first = (j - 1 < 0) ? 0 : oldRowResult.get(j - 1);
                second = (j >= oldRowResult.size()) ? 0 : oldRowResult.get(j);
                rowResult.add(j, first + second);
            }
            oldRowResult = rowResult;
            result.add(i, rowResult);
            rowResult=null;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> generate = solution.generate(5);

        System.out.println("[");
        for (List<Integer> row : generate) {
            System.out.print("[");
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

}
