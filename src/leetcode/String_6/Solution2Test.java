package leetcode.String_6;

import junit.framework.TestCase;

/**
 * Created by felix on 15/6/2.
 */
public class Solution2Test extends TestCase {

    public void testConvert() throws Exception {
        Solution2 solution2 = new Solution2();
        assertEquals("PAHNAPLSIIGYIR", solution2.convert("PAYPALISHIRING", 3));
//        assertEquals("ACB", solution2.convert("ABC", 2));
//        assertEquals("ACBD", solution2.convert("ABCD", 2));
    }

    public void testCalc() throws Exception {
        Solution2 solution2 = new Solution2();
        assertEquals(2, solution2.calc(4, 2));
        assertEquals(6, solution2.calc(12, 4));
        assertEquals(7, solution2.calc(13, 4));
        assertEquals(7, solution2.calc(16, 4));
        assertEquals(8, solution2.calc(17, 4));
        assertEquals(9, solution2.calc(18, 4));
    }
}