package leetcode.BinarySearch_50;

import junit.framework.TestCase;

/**
 * Created by felix on 15/6/20.
 */
public class SolutionTest extends TestCase {

    public void testMyPow() throws Exception {
        Solution solution = new Solution();
        double myPow = solution.myPow(2, 5);
        assertEquals(32.0,myPow);
    }
}