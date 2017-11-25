package leetcode.Array_73;

import junit.framework.TestCase;



/**
 * Created by felix on 15/6/16.
 */
public class SolutionTest extends TestCase {

    public void testSetZeroes() throws Exception {
        Solution solution =new Solution();
        int[][] matrix={
                {0,1},
                {0,1},
                {1,1},
        };
        solution.setZeroes(matrix);

    }
}