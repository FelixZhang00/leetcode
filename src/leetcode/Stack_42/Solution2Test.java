package leetcode.Stack_42;

import junit.framework.TestCase;

/**
 * Created by felix on 15/6/19.
 */
public class Solution2Test extends TestCase {

    public void testTrap() throws Exception {
        Solution2 solution = new Solution2();
        int[] height = {5, 4, 1, 2};
        int trap = solution.trap(height);
        assertEquals(1, trap);

        int[] height2={5,2,1,2,1,5};
        int trap2 = solution.trap(height2);
        assertEquals(14,trap2);

        int[] height3={4,2,0,3,2,4,3,4};
        int trap3 = solution.trap(height3);
        assertEquals(10,trap3);


        int[] height4={0,7,1,4,6};
        int trap4 = solution.trap(height4);
        assertEquals(7,trap4);


        int[] height5 = {8,5,4,1,8,9,3,0,0};
        int trap5 = solution.trap(height5);
        assertEquals(14, trap5);
    }
}