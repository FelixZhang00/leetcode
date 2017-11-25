package leetcode.BinarySearch_50;

/**
 * Created by felix on 15/6/20.
 * <p/>
 * 参考：http://www.cnblogs.com/remlostime/archive/2012/11/14/2769963.html
 * 用二分法，O(logn)。注意n < 0的处理
 */
public class Solution2 {


    double myPow(double x, int n) {
        if (n < 0)
            return 1.0 / power(x, -n);
        else
            return power(x, n);
    }

    double power(double x, int n) {
        if (n == 0)
            return 1;

        double v = power(x, n / 2);

        if (n % 2 == 0)
            return v * v;
        else
            return v * v * x;
    }
}
