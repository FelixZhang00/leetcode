package leetcode.Math_171;

/**
 * Created by felix on 15/6/5.
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 题意：转化示例
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * <p/>
 * 思路：形同16进制的转换方法   AB=A*26^1+B=26+2=28
 * Accepted！
 * 简单题
 */
public class Solution {
    public int titleToNumber(String s) {
        int total = 0;
        int ex=0;
        for (int i = s.length() - 1; i >=0; i--) {
            total += convertToDigit(s.charAt(i)) * Math.pow(26, ex++);
        }
        return total;
    }

    private double convertToDigit(char c) {
        return c - 'A' + 1;
    }
}
