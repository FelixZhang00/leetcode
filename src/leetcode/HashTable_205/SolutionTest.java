package leetcode.HashTable_205;

import junit.framework.TestCase;

/**
 * Created by felix on 15/5/27.
 */
public class SolutionTest extends TestCase {

    public void testIsIsomorphic() throws Exception {
        Solution solution=new Solution();
        assertEquals(true,solution.isIsomorphic("egg","add"));
        assertEquals(false,solution.isIsomorphic("foo","bar"));
        assertEquals(true,solution.isIsomorphic("paper","title"));
    }
}