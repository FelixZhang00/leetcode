package leetcode.Bit_191;

import junit.framework.TestCase;

/**
 * Created by felix on 15/5/30.
 */
public class SolutionTest extends TestCase {

    public void testHammingWeight() throws Exception {
        Solution solution = new Solution();
        assertEquals(3,solution.hammingWeight(11));
    }
}