package leetcode.Greedy_134;

import junit.framework.TestCase;

/**
 * Created by felix on 15/5/30.
 */
public class SolutionTest extends TestCase {

    public void testCanCompleteCircuit() throws Exception {
        Solution solution=new Solution();
        assertEquals(-1,solution.canCompleteCircuit(new  int[]{2,4},new int[]{3,4}));
    }
}