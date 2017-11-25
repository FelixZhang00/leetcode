package leetcode.Array_119;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 15/4/4.
 */
public class Brute {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) throw new IllegalArgumentException();
        List<List<Integer>> list = generate(rowIndex+1);
        return list.get(rowIndex);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            if (i > 0) {
                for (int j = 1; j < result.get(i - 1).size(); j++) {
                    temp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
                temp.add(1);
            }
            result.add(i, temp);

        }

        return result;
    }

    public static void main(String[] args) {
        Brute solution=new Brute();
        List<Integer> row = solution.getRow(5);
        for (int i = 0; i < row.size(); i++) {
            System.out.println(row.get(i));
        }
    }

}
