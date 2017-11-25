package leetcode.String_6;

import junit.framework.TestCase;

/**
 * Created by felix on 15/6/2.
 */
public class SolutionTest extends TestCase {

    public void testConvert() throws Exception {
        Solution solution = new Solution();
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3));
        assertEquals("ACB", solution.convert("ABC", 2));
        assertEquals("ACBD", solution.convert("ABCD", 2));
    }

    public void testCalc() throws Exception {
        Solution solution = new Solution();
        assertEquals(7, solution.calc(14, 3));
        assertEquals(3, solution.calc(4, 2));
    }
}