package leetcode.DP_120;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 15/6/19.
 *

 */
public class SolutionTest extends TestCase {

    public void testMinimumTotal() throws Exception {
        Solution solution = new Solution();
        int[][] array = {
                {1},
                {2,3},
        };
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> row1=new ArrayList<Integer>();
        row1.add(1);
        List<Integer> row2=new ArrayList<Integer>();
        row2.add(2);
        row2.add(3);
        triangle.add(row1);
        triangle.add(row2);

        solution.minimumTotal(triangle);
    }
}