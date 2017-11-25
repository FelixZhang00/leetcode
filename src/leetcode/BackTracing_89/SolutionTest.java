package leetcode.BackTracing_89;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by felix on 15/5/28.
 */
public class SolutionTest extends TestCase {

    public void testGrayCode() throws Exception {
        Solution solution = new Solution();
        assertEquals(4, solution.stringConvertToBinary("100"));
        assertEquals(0, solution.stringConvertToBinary("0"));
        assertEquals(7, solution.stringConvertToBinary("111"));
    }

    public  void testisSafe() throws  Exception{
        Solution solution = new Solution();
        assertEquals(true,solution.isSafe(3, 7));
        assertEquals(false,solution.isSafe(2, 7));
    }

    public  void testgrayCode() throws Exception{
        Solution solution = new Solution();
        List<Integer> list = solution.grayCode(2);
        for (Integer item : list) {
            System.out.println(item);
        }
    }
}