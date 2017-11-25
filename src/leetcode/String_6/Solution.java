package leetcode.String_6;

/**
 * Created by felix on 15/6/2.
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * 做法正确，但是答案不符合题意。
 */
public class Solution {
    public String convert(String s, int numRows) {

        // 设置table的大小
        int cols = calc(s.length(), numRows);

        int table[][] = new int[numRows][cols];     //记录字符在字符串中的下标,-1表示没有

        //根据zigzag模式填充table
        boolean isEvenRowNum = (numRows % 2 == 0);        //行数是否是偶数
        int index = 0;
        for (int c = 0; c < cols; c++) {         //遍历列
            for (int r = 0; r < numRows; r++) {     //遍历行
                if (c % 2 == 0) {        //偶数列
                    if (index == s.length()) {   //处理成组剩余的情况
                        table[r][c] = -1;
                    } else {
                        table[r][c] = index++;
                    }
                } else {  //奇数列，只在中间位置填编号，其余位置填-1
                    if ((isEvenRowNum && r == (numRows / 2 - 1) )||(!isEvenRowNum && r == (numRows / 2))) {
                        table[r][c] = index++;
                    } else {
                        table[r][c] = -1;
                    }
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        //遍历table，填充结果集
        for (int r = 0; r < numRows; r++) {     //遍历行
            for (int c = 0; c < cols; c++) {         //遍历列
                if (table[r][c] != -1) {
                    sb.append(s.charAt(table[r][c]));
                }
            }
        }

        return sb.toString();
    }

    /**
     * 计算需要的列数
     *
     * @param strLength
     * @param numRows
     * @return 以numRows=3为例。
     */
    public int calc(int strLength, int numRows) {
        int group = strLength / (numRows + 1);        //6个元素为一组，共需几组
        boolean isRemain = (strLength % (numRows + 1) != 0);       //是否有剩余没成组的元素

        int total;  //总共需要多少方块，能容下这些元素
        if (isRemain) {     //有剩余的情况
            total = group * (2 * numRows) + numRows;
        } else {
            total = group * (2 * numRows);
        }

        return total / numRows;
    }
}
