package leetcode.Math_172;

import java.math.BigDecimal;

/**
 * Created by felix on 15/6/29.
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 * <p/>
 * 题意：求出n的阶乘末尾有多少个0
 * <p/>
 * 思路1：暴力解法。先用循环算出阶乘的结果。再对结果做%10运算，统计末尾0的个数
 *
 * 注意大数，阶乘的过程中很可能产生整数溢出，所以换用BigDecimal
 *
 * 超时：当n=2625时
 * 时间复杂度为2n
 * 而题目中要求logn
 *
 *
 */
public class Solution {

    public int trailingZeroes(int n) {
        BigDecimal result =BigDecimal.ONE;
        int trail = 0;
        while (n != 0) {
            result=result.multiply(new BigDecimal(n));
            n--;
        }

        StringBuilder sb=new StringBuilder(result.toPlainString());
        for (int i = sb.length()-1; i>=0; i--) {
            if (sb.charAt(i)=='0')trail++;
            else break;

        }



        return trail;
    }


}
