package leetcode.Array_16;

import junit.framework.TestCase;

/**
 * Created by felix on 15/6/19.
 */
public class SolutionTest extends TestCase {

    public void testThreeSumClosest() throws Exception {
Solution s=new Solution();
        int[] nums={0,0,0};
        int sumClosest = s.threeSumClosest(nums, 1);
        assertEquals(0,sumClosest);



        int[] nums2={-1,2,1,-4};
        int sumClosest2 = s.threeSumClosest(nums2, 1);
        assertEquals(2,sumClosest2);



        int[] nums3={1,1,-1,-1,3};
        int sumClosest3 = s.threeSumClosest(nums3, -1);
        assertEquals(-1,sumClosest3);

        int[] nums4={4,0,5,-5,3,3,0,-4,-5};
        int sumClosest4 = s.threeSumClosest(nums4, -2);
        assertEquals(-2,sumClosest4);
    }
}