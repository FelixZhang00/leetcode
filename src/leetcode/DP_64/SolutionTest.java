package leetcode.DP_64;

import junit.framework.TestCase;

/**
 * Created by felix on 15/6/14.
 */
public class SolutionTest extends TestCase {

    public void testMinPathSum() throws Exception {
//        int[][] grid = {
//                {1, 2},
//                {1, 1}
//        };
//        Solution solution = new Solution();
//        int minPathSum = solution.minPathSum(grid);
//        assertEquals(3, minPathSum);


//        int[][] grid2 = {
//                {1, 3, 1},
//                {1, 5, 1},
//                {4, 2, 1}
//        };
//        Solution solution = new Solution();
//        int minPathSum = solution.minPathSum(grid2);
//        assertEquals(7, minPathSum);


        int[][] grid2 = {
                {1, 2},
                {5, 6},
                {1, 1}
        };

        Solution solution = new Solution();
        int minPathSum = solution.minPathSum(grid2);
        assertEquals(8, minPathSum);
    }

    public void testCalcLength() throws Exception {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6}
        };
        Solution solution = new Solution();
        int length = solution.calcLength(grid);
        assertEquals(6, length);

    }
}