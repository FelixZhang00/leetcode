package leetcode.Bit_191;

import junit.framework.TestCase;

/**
 * Created by felix on 15/5/30.
 */
public class Solution2Test extends TestCase {

    public Solution2 getInstance() {
        Solution2 solution2 = new Solution2();
        return solution2;
    }

    public void testHammingWeight() throws Exception {
        assertEquals(3, getInstance().hammingWeight(11));
    }

    public void testGetBit() throws Exception {
        getInstance().getBit(1, 1);
    }
}