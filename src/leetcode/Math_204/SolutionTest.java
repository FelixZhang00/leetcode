package leetcode.Math_204;

import junit.framework.TestCase;

/**
 * Created by felix on 15/6/23.
 */
public class SolutionTest extends TestCase {

    public void testCountPrimes() throws Exception {
        Solution solution = new Solution();
        int primes = solution.countPrimes(10);
        assertEquals(4, primes);
    }
}