package leetcode.DP_64;

import junit.framework.TestCase;

/**
 * Created by felix on 15/6/14.
 */
public class Solution2Test extends TestCase {

    public void testMinPathSum() throws Exception {
        int[][] grid={
                {1,2},
                {1,1}
        };
        Solution2 solution2=new Solution2();
        int minPathSum = solution2.minPathSum(grid);
        assertEquals(3,minPathSum);
    }

}