package leetcode.DP_63;

import junit.framework.TestCase;

/**
 * Created by felix on 15/6/16.
 */
public class SolutionTest extends TestCase {

    public void testUniquePathsWithObstacles() throws Exception {
        Solution solution=new Solution();
        int[][] obstacleGrid={
                {1,0}
        };
        int pathCnt = solution.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(0,pathCnt);
    }
}