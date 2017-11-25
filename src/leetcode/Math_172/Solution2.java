package leetcode.Math_172;

/**
 * Created by felix on 15/6/29.
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 * <p/>
 * 题意：求出n的阶乘末尾有多少个0
 * <p/>
 * 思路2：一个更聪明的解法，考虑n！的质数因子。后缀为0总是由质因子2和质因子5相乘得来的。
 * 如果能计数2和5的个数，问题就解决了。
 * 并且通过观察发现质因子中2的个数总是大于5的个数，因此只要计数5的个数就可以了。
 * 如何计算n！的质因子中所有5的个数？
 * 一个简单的方法是计算floor(n/5),例如7!有一个5，10!中有2个5.
 * 但还有个特殊情况：25！=25*24...=(5*5)*24... 这里25有一个多余的5.
 * 总的思路是：首先对n/5,移除所有单个5，还要看n/5里面有多少个5，也就相当于看n里面有多少个25，还有125，625.。。
 * <p/>
 * 参考：http://www.tuicool.com/articles/RZZnQf
 *
 * AC!
 */
public class Solution2 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }

        return res;
    }

}
