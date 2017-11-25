package leetcode.BackTracing_51;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by felix on 15/5/6.
 */
public class Solution2Test extends TestCase {

    public void testSolveNQueens() {
        Solution2 solution2 = new Solution2();
        List<String[]> result = solution2.solveNQueens(4);

        System.out.println(result.size());
        for (String[] generate : result) {
            System.out.println("================");
            for (String line : generate) {
                System.out.println(line);
            }
        }

    }

    public void testGenerate() {
        Solution2 solution = new Solution2();
        int queenList[] = new int[]{1,1,1,1};

        String[] generate = solution.generate(queenList, 4);

        for (String line : generate) {
            System.out.println(line);
        }
    }

}