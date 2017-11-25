package leetcode.String_67;

/**
 * Created by felix on 15/4/8.
 * https://leetcode.com/problems/add-binary/
 * <p/>
 * 用字符串模拟二进制的加法
 */
public class Solution {

    /**
     * Solution1:
     * 现将二进制数转化成十进制数（用2的n次方相加），然后把这两个数相加，最后转化为二进制数
     * <p/>
     * 测试结果：
     * 195 / 294 test cases passed.
     * 数字一大就溢出了
     *
     * @return
     */
    public String addBinary1(String a, String b) {
        long inta = binaryToInt(a);
        long intb = binaryToInt(b);

        String s = Long.toBinaryString(inta + intb);  //十进制转化为二进制
        return s;
    }

    private long binaryToInt(String s) {
        long result = 0;
        int n = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int c = Integer.parseInt("" + s.charAt(i)); //系数
            System.out.println(i + ": " + c);
            result += c * Math.pow(2, n++);
        }

        return result;
    }


    /**
     * Solution2: 模拟二进制的加法
     * <p/>
     * Runtime: 232 ms
     * <p/>
     * 代码量太大，再找找更简洁的写法
     *
     * @return
     */
    public String addBinary2(String a, String b) {
        int lena = a.length(), lenb = b.length();
        StringBuilder result = new StringBuilder();

        char c = '0';//进位
        char remain = '0';
        int i = lena - 1, j = lenb - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            char char_a = a.charAt(i);
            char char_b = b.charAt(j);

            if (c == '1') {
                if (char_a == '1' && char_b == '1') {
                    remain = '1';
                    c = '1';
                } else if (char_a == '1' || char_b == '1') {
                    remain = '0';
                    c = '1';
                } else {
                    remain = '1';
                    c = '0';
                }

            } else if (c == '0') {
                if (char_a == '1' && char_b == '1') {
                    remain = '0';
                    c = '1';
                } else if (char_a == '1' || char_b == '1') {
                    remain = '1';
                    c = '0';
                } else {
                    remain = '0';
                    c = '0';
                }
            }

            result.append(remain);
        }

        if (j < 0) {  //如果字符串a的长度大于字符串b
            while (i >= 0) {
                char char_a = a.charAt(i--);
                if (c == '1') {
                    if (char_a == '1') {
                        remain = '0';
                        c = '1';
                    } else if (char_a == '0') {
                        remain = '1';
                        c = '0';
                    }
                } else if (c == '0') {
                    if (char_a == '1') {
                        remain = '1';
                        c = '0';
                    } else if (char_a == '0') {
                        remain = '0';
                        c = '0';
                    }
                }
                result.append(remain);
            }

        } else if (i < 0) {
            while (j >= 0) {
                char char_b = b.charAt(j--);
                if (c == '1') {
                    if (char_b == '1') {
                        remain = '0';
                        c = '1';
                    } else if (char_b == '0') {
                        remain = '1';
                        c = '0';
                    }
                } else if (c == '0') {
                    if (char_b == '1') {
                        remain = '1';
                        c = '0';
                    } else if (char_b == '0') {
                        remain = '0';
                        c = '0';
                    }
                }
                result.append(remain);
            }
        }

        if (c == '1') {  //最高位是否还有进位
            result.append(c);
        }


        //最后需要反转
        return result.reverse().toString();
    }


    /**
     * Solution3：用更简洁的代码
     * <p/>
     * Runtime: 223 ms
     *
     * @return
     */
    public String addBinary3(String a, String b) {
        StringBuilder result = new StringBuilder();
        int length_a = a.length();
        int length_b = b.length();
        int n = Math.max(length_a, length_b);
        int carry = 0, remain = 0;
        for (int i = n - 1; i >= 0; i--) {
            int int_a = (length_a > 0) ? a.charAt(--length_a) - '0' : 0;
            int int_b = (length_b > 0) ? b.charAt(--length_b) - '0' : 0;
            remain = (carry + int_a + int_b) % 2;
            carry = (carry + int_a + int_b) / 2;
            result.append(remain);
        }

        if (carry == 1) {
            result.append('1');
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String s = solution.addBinary3("1101", "101");
        System.out.println(s);
//        int i = solution.binaryToInt("111");
//        System.out.println(i);
    }
}
