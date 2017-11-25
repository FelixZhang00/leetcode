package leetcode.Math_204;

/**
 * Created by felix on 15/6/23.
 * https://leetcode.com/problems/count-primes/
 *
 * 超时，尽管做了小范围的优化
 */
public class Solution {

    public int countPrimes(int n) {
        int cnt = 1;    //先记录2是素数
        for (int i = 3; i <= n; i+=2) {
            if (isPrime(i)) cnt++;
        }

        return cnt;
    }

    private boolean isPrime(int x) {
        int temp= (int) Math.ceil(Math.sqrt(x));
        for (int i = 2; i <=temp; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
