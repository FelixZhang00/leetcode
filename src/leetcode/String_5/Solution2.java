package leetcode.String_5;

/**
 * Created by felix on 15/6/1.
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 题意：
 * 最长回文
 * <p/>
 * 解题思路：
 * 动态规划，
 * 假设dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串
 * dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]
 *
 * Accepted!
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        int length = s.length();

        int maxLen = 1;     //记录最长回文字的长度
        int begin = 0;        //记录最长回文字的开始位置
        //有了这两个数据就可以确定最长回文字了。

        //i:子串开始位置，j:子串结束位置；true表示该位置对应的子串是一个回文字
        boolean table[][] = new boolean[length][length];


        //先填充len=1、2时子串的情况到动态规划的table中
        for (int i = 0; i < length ; i++) {
            table[i][i] = true;
        }

        for (int i = 0; i <length - 1; i++) {

            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                begin = i;
                maxLen = 2;
            }

        }


        //对子串长度递增判断是否是回文
        for (int len = 3; len <=length; len++) {
            for (int i = 0; i <=length - len; i++) {
                int j = i + len - 1;
                if (table[i+1][j-1]&&(s.charAt(i) == s.charAt(j))){
                    table[i][j]=true;
                    begin=i;
                    maxLen=len;
                }
            }

        }

        return s.substring(begin, begin + maxLen);

    }
}
