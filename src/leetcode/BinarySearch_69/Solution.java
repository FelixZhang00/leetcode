package leetcode.BinarySearch_69;

/**
 * Created by felix on 15/4/9.
 * <p/>
 * https://leetcode.com/problems/sqrtx/
 */
public class Solution {

    /**
     * Solution 1:调用系统函数
     * <p/>
     * Runtime: 217 ms
     *
     * @return
     */
    public int sqrt(int x) {
        return (int) Math.sqrt(x);
    }

    /**
     * Solution 2：暴力破解
     * <p/>
     * 遍历所有正式，用它的平方去试
     * <p/>
     * Time Limit Exceeded
     *
     * @return
     */
    public int sqrt2(int x) {
        int temp = 0;
        for (int i = 0; i < x; i++) {
            if (i * i <= x) {
                temp = i;
            } else {
                break;
            }
        }
        return temp;
    }

    /**
     * Solution 3：用二分查找
     * Time Limit Exceeded:
     * Last executed input:	2147483647
     *
     * @return
     */
    public int sqrt3(int x) {
        int lo = 0, hi = x;
        int result = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isFind(mid, x)) {
                result = mid;
                break;
            }

            if (mid * mid > x) hi = mid - 1;
            else if (mid * mid < x) lo = mid + 1;
        }

        return result;
    }

    /**
     * 整数candi是否是最接近target的平方根
     *
     * @return
     */
    private boolean isFind(int candi, int target) {
        return candi * candi <= target && (candi + 1) * (candi + 1) > target;
    }


    /**
     * Solution4:继续用二分法来做
     * 这次做一些优化
     * <p/>
     * Accepted!
     * Runtime: 231 ms
     *
     * @return
     */
    public int sqrt4(int x) {
        int lo = 1, hi = x / 2;
        int result = 1;
        if (x < 2) return x;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isFindSqr(mid, x)) {
                result = mid;
                break;
            } else if (x / mid < mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }

        }

        return result;
    }

    /**
     * 整数candi是否是最接近target的平方根
     *
     * @return
     */
    private boolean isFindSqr(int candi, int target) {
        return target / candi >= candi && target / (candi + 1) < (candi + 1);
        //   不要用乘法，会溢出
        //   candi * candi <= target && (candi + 1) * (candi + 1) > target;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int sqrt3 = solution.sqrt4(10001);
        System.out.println(sqrt3);
    }
}
