package leetcode.String_6;

/**
 * Created by felix on 15/6/2.
 * https://leetcode.com/problems/zigzag-conversion/
 * <p/>
 * 在solution1的基础上修改了构造表table
 * <p/>
 * zigzag模式示例：
 * A  G
 * B FH
 * CE I
 * D  J
 *
 * 构造table失败
 */
public class Solution2 {
    public String convert(String s, int numRows) {

        // 设置table的大小
        int cols = calc(s.length(), numRows);

        int table[][] = new int[numRows][cols];     //记录字符在字符串中的下标,-1表示没有

        //根据zigzag模式填充table
        int index = 0;
        for (int c = 0; c < cols; c++) {            //遍历列
            for (int r = 0; r < numRows; r++) {     //遍历行
                if (c % numRows == 0) {             //每一组的第一列
                    if (index == s.length()) {      //处理成组剩余的情况
                        table[r][c] = -1;
                    } else {
                        table[r][c] = index++;
                    }
                } else {  //其它列，只在一个位置填编号，其余位置填-1
                    if (r == (numRows - 1 - c % numRows)) {
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
     * @return
     */
    public int calc(int strLength, int numRows) {
        int block = numRows * (numRows - 1);
        int members = numRows + numRows - 2;
        int group = strLength / members;        //members个元素为一组，共需几组
        int remain = strLength % members;
        boolean isRemain = (remain != 0);       //是否有剩余没成组的元素


        int total;  //总共需要多少方块，能容下这些元素
        if (isRemain) {     //有剩余的情况
            if (remain <= numRows) {
                total = group * block + numRows;
            } else {
                total = group * block + numRows * (1 + (remain - numRows));
            }
        } else {
            total = group * block;
        }

        return total / numRows;
    }
}
