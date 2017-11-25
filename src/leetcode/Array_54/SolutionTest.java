package leetcode.Array_54;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by felix on 15/6/16.
 */
public class SolutionTest extends TestCase {

    public void testSpiralOrder() throws Exception {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> list = solution.spiralOrder(matrix);
        int i=0;
    }

//    public void testContain() throws Exception {
//        Solution solution = new Solution();
//        assertEquals(true,solution.contain());
//    }
}