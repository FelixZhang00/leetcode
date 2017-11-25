package leetcode.BinarySearch_33;

import junit.framework.TestCase;

/**
 * Created by felix on 15/6/16.
 */
public class SolutionTest extends TestCase {

    public void testSearch() throws Exception {
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(6, solution.search(nums, 2));
    }
}