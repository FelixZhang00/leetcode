package leetcode.Math_172;

import junit.framework.TestCase;



/**
 * Created by felix on 15/6/29.
 */
public class SolutionTest extends TestCase {

    public void testTrailingZeroes() throws Exception {
        Solution solution=new Solution();
        int zeroes = solution.trailingZeroes(5);
        assertEquals(1,zeroes);


        int zeroes1 = solution.trailingZeroes(40);
        System.out.println(zeroes1);

        int zeroes2 = solution.trailingZeroes(2625);
        System.out.println(zeroes2);
    }
}