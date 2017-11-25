package leetcode.HashTable_76;

import junit.framework.TestCase;

/**
 * Created by felix on 15/6/10.
 */
public class SolutionTest extends TestCase {

    public void testMinWindow() throws Exception {
        Solution solution=new Solution();
        String minWindow = solution.minWindow("ADOBECODEBANC", "ABC");
        assertEquals("BANC",minWindow);
    }
}