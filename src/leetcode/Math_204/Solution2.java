package leetcode.Math_204;

/**
 * Created by felix on 15/6/23.
 * https://leetcode.com/discuss/36568/java-o-n-solution-for-count-primes
 * https://leetcode.com/problems/count-primes/
 * 其中的Hint中有详细的介绍
 * 用筛选法
 */
public class Solution2 {

    public int countPrimes(int n) {
        boolean isPrime[] = new boolean[n];
        for (int i = 2; i < n; i++) {       //先标志（2，n）的数都为素数
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;

            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }

        int cnt=0;
        for (int i = 2; i <n; i++) {
            if (isPrime[i]) cnt++;
        }

        return cnt;
    }

}
