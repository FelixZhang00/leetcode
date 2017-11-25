package leetcode.Backtracking_46;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by felix on 15/6/16.
 */
public class SolutionTest extends TestCase {

    public void testPermute() throws Exception {
        Solution solution = new Solution();
        int[] nums={1,2,3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.print("hello");
    }
}