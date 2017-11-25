package leetcode.Array_66;

/**
 * Created by felix on 15/4/3.
 * 将大数用数组表示，将+1的结果以数组的形式返回
 */
public class Solution {
    private static final int PULS_DIGIT = 1;

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int c = 0;  //进位
        int remain; //每位加1后剩余的数
        int temp;
        for (int i = length - 1; i >= 0; i--) {
            if (i != length - 1) {
                temp = digits[i];
            } else {
                temp = digits[length - 1] + PULS_DIGIT;
            }
            remain = (temp+c) % 10;
            digits[i] =remain;
            c = (temp+c) / 10;
        }

        if (c >= 1) { //最高位有进位，要扩充数组
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = c;
            return result;
        }else{
            return digits;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int digits[] = new int[]{9};
        int[] ints = solution.plusOne(digits);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
}
