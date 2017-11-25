package leetcode.BackTracing_51;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by felix on 15/5/6.
 */
public class SolutionTest extends TestCase {

    public void testAttacked() {
        Solution solution = new Solution();
        assertEquals(false, solution.isAttacked(4, 0, 14));
        assertEquals(true, solution.isAttacked(4, 0, 15));
        assertEquals(false, solution.isAttacked(4, 4, 13));

    }


    public void testCommon() {
        boolean grid[][] = new boolean[3][3];
        assertEquals(3, grid.length);
    }

    public void testGenerate() {
        Solution solution = new Solution();
        boolean grid[][] = new boolean[3][3];
        grid[2][2] = true;

        String[] generate = solution.generate(grid);

        for (String line : generate) {
            System.out.println(line);
        }
    }

    public void testCheckAttack() {
        Solution solution = new Solution();
        boolean grid[][] = new boolean[4][4];
//        grid[][]=true;
//        grid[][]=true;
//        grid[][]=true;
//        grid[][]=true;
        assertEquals(false,solution.checkAttack(grid,3));

    }

    /**
     *
     * 4s
     */
    public void testsolveNQueens() {
        Solution solution = new Solution();
        List<String[]> result = solution.solveNQueens(4);

        System.out.println(result.size());
        for (String[] generate : result) {
            System.out.println("================");
            for (String line : generate) {
                System.out.println(line);
            }
        }

    }


    /**
     * 这是参考的：
     * 0.019s
     */
    public void testS51(){
        S51 s=new S51();

        List<String[]> result = s.solveNQueens(7);

        System.out.println(result.size());
        for (String[] generate : result) {
            System.out.println("================");
            for (String line : generate) {
                System.out.println(line);
            }
        }

    }

}