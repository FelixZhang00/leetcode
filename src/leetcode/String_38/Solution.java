package leetcode.String_38;

/**
 * Created by felix on 15/5/28.
 * https://leetcode.com/problems/count-and-say/
 *
 * 答案正确，但超时了
 */
public class Solution {
    public String countAndSay(int n) {
        StringBuilder last = new StringBuilder();
        last.append(1);
        return generate(last, 0, n);
    }

    String generate(StringBuilder last, int d, int n) {
        if (d == n) {
            return last.toString();
        }

        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < last.length(); i++) {
            char c = last.charAt(i);
            if (c == '1' && (last.length() - i) > 1 && last.charAt(i + 1) == '1') {     //11->21
                newStr.append(21);
                if ((last.length() - i) == 2) break;       //已经用完了
            } else if (c == '1') {      //1*->11
                newStr.append(11);
            } else if (c == '2') {
                newStr.append(12);
            }
        }

        return generate(newStr, d + 1, n);
    }

}
