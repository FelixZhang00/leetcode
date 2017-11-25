package leetcode.String_5;

/**
 * Created by felix on 15/6/1.
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 题意：
 * 最长回文
 * <p/>
 * 解题思路：
 * 暴力破解，对于每个可能的子串判断它是否是回文字。
 *
 * 超时！
 */
public class Solution {
    public String longestPalindrome(String s) {

        int maxLen=0;
        String longestPalindrome=null;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <=s.length(); j++) {
                String currStr=s.substring(i,j);
                int len=currStr.length();

                if (isPalindrome(currStr)){
                    if (len>maxLen){
                        maxLen=len;
                        longestPalindrome=currStr;
                    }
                }
            }
        }
        return longestPalindrome;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0,j=s.length()-1;i<j; i++,j--) {
            if (s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }


}
