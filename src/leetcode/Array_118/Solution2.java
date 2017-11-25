package leetcode.Array_118;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 15/4/4.
 */
public class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp=new ArrayList<Integer>();
            temp.add(1);
            if (i>0){
                for (int j = 1; j <result.get(i-1).size(); j++) {
                    temp.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
                temp.add(1);
            }
            result.add(i,temp);

        }

        return result;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
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
