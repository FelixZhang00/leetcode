package leetcode.Bit_191;

/**
 * Created by felix on 15/5/30.
 *https://leetcode.com/problems/number-of-1-bits/
 * 答案正确，但超时了
 *
 * 解法的缺陷：
 * 对于下面这种情况，
 * 2147483648 (10000000000000000000000000000000)
 * 因为会移动符号位，所以永远不会变成0，循环一直在跑。
 * 可以用位运算，见Solution2
 *
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int total = 0;
        while (n != 0) {
            if (n % 2 == 1) total++;
            n = n >> 1;     //算数右移，会移动符号位
        }
        return total;
    }

    /**
     * 将整型转化成以字符串表示的二进制
     */
    private String d2b(int n) {
        return null;
    }
}
