package leetcode.Array_11;

import junit.framework.TestCase;

/**
 * Created by felix on 15/6/12.
 */
public class Solution2Test extends TestCase {

    public void testMaxArea() throws Exception {
        Solution2 solution2=new Solution2();
        int sample[]={4,6,2,6,7,11,2};
        int maxArea = solution2.maxArea(sample);
        System.out.println(maxArea);

        int sample2[]={1,2,3,4};
        int maxArea2 = solution2.maxArea(sample2);
        System.out.println(maxArea2);
    }
}