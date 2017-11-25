package leetcode.Stack_42;

import junit.framework.TestCase;

/**
 * Created by felix on 15/6/18.
 */
public class SolutionTest extends TestCase {

    public void testTrap() throws Exception {
        Solution solution = new Solution();
//        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height={5,2,1,2,1,5};
        int trap = solution.trap(height);
        assertEquals(14,trap);

        int[] height2={4,2,0,3,2,4,3,4};
        int trap2 = solution.trap(height2);
        assertEquals(10,trap2);


        int[] height3={0,7,1,4,6};
        int trap3 = solution.trap(height3);
        assertEquals(7,trap3);
    }


}