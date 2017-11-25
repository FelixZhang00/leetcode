package leetcode.String_58;

import junit.framework.TestCase;

/**
 * Created by felix on 15/6/16.
 */
public class SolutionTest extends TestCase {

    /**
     * @throws Exception
     */
    public void testLengthOfLastWord() throws Exception {
        Solution solution = new Solution();
        assertEquals(5, solution.lengthOfLastWord("Hello World"));
        assertEquals(0,solution.lengthOfLastWord(" "));
        assertEquals(1,solution.lengthOfLastWord("a"));
        assertEquals(1,solution.lengthOfLastWord("a "));
        assertEquals(0,solution.lengthOfLastWord(""));
    }

}