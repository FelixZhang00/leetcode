package leetcode.BinarySearch_29;

/**
 * Created by felix on 15/4/9.
 * https://leetcode.com/problems/divide-two-integers/
 * If it is overflow, return MAX_INT.
 */
public class Solution {


    /**
     * Solution 1：用除法转型成int
     * 小心结果超过int的范围造成溢出
     * <p/>
     * Runtime: 214 ms
     *
     * @return
     */
    public int divide(int dividend, int divisor) {
        long result = (long) dividend / divisor;
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        return (int) result;
    }

    /**
     * Solution 2：用暴力算法解决
     * Time Limit Exceeded
     */
    public int divide2(int dividend, int divisor) {
        if (dividend < divisor) return 0;
        int sum = 0, count = 0;
        for (; sum <= dividend; sum += divisor, count++)
            ;
        return count - 1;

    }


    /**
     * Solution 3：
     * 让除数左移直到大于被除数之前得到一个最大的基。
     * 然后接下来我们每次尝试减去这个基，如果可以则结果增加加2^k,
     * 然后基继续右移迭代，直到基为0为止。
     *
     * 测试通过！
     * @return
     */
    public int divide3(int dividend, int divisor) {

        //转型
        long dividend_long = (long) dividend;
        long divisor_long = (long) divisor;
        long res = 0;
        //关心两个数的符号位是否不同，按位异或，然后带符号地右移31位，暴露出符号位
        boolean isNeg = ((dividend ^ divisor) >>> 31 == 1) ? true : false;

        //先按正数处理
        dividend_long = Math.abs(dividend_long);
        divisor_long = Math.abs(divisor_long);
        int digit = 0;
        while (divisor_long <= (dividend_long >> 1)) { //将除数与被除数的一半进行比较，找到最大的基数
            divisor_long <<= 1;
            digit++;
        }

        while (digit >= 0) {  //拼凑商
            if (dividend_long >= divisor_long)  //尝试从被除数中减去一个多项式（除数*商的一部分）
            {
                res += 1 << digit;  //上用二进制多项式表示的一部分
                dividend_long -= divisor_long;
            }
            //回到上一个除数形态
            divisor_long >>= 1;
            digit--;
        }

        //只有一种情况会造成溢出：-2147483648，-1
        if (dividend==Integer.MIN_VALUE&&divisor==-1) {  //MAX:2147483647 MIN:-2147483648
            return Integer.MAX_VALUE;
        } else {
            res = isNeg ? -res : res;
            return (int) res;
        }


    }



    public static void main(String[] args) {

//        System.out.println(Integer.MAX_VALUE);

        Solution solution = new Solution();
        System.out.println(Integer.MIN_VALUE);  //-2147483648
        System.out.println(Integer.MAX_VALUE);  //2147483647
        System.out.println(Long.MIN_VALUE);  //-9223372036854775808
//        System.out.println(100>>1);  //输出50
//        System.out.println(1<<3);

        System.out.println(solution.divide3(-1010369383, -2147483648));
    }
}
