package leetcode.String_6;

/**
 * Created by felix on 15/6/2.
 * https://leetcode.com/problems/zigzag-conversion/
 * 参考：http://blog.csdn.net/zhouworld16/article/details/14121477
 * 用公式推。
 *
 * Accepted!
 * Runtime: 472 ms
 */
public class Solution3 {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() == 0) {
            return s;
        }

        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows && i < len; i++) {     //遍历行
            int idx = i;                        //用于向字符串s取数据的下标位置
            sb.append(s.charAt(idx));

            for (int j = 1; idx < len; j++) {   //遍历列
                if (i == 0 || i == numRows - 1) {
                    idx += 2 * numRows - 2;
                } else {
                    if (j % 2 == 1) {      //奇数列
                        idx += 2 * (numRows - 1 - i);
                    } else {
                        idx += 2 * i;
                    }
                }
                if (idx < len) {
                    sb.append(s.charAt(idx));
                }

            }

        }


        return sb.toString();

    }
}
