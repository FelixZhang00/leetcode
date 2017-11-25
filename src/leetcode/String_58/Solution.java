package leetcode.String_58;

/**
 * Created by felix on 15/6/16.
 * https://leetcode.com/problems/length-of-last-word/
 *
 * AC!
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || "".equals(s)) return 0;

        int n = s.length() - 1;
        while ((n >= 0) && s.charAt(n) == ' ') n--;     //直到最后一个字母不为空格

        int i = 0;  //对单词长度计数
        for (; (n >= 0) && s.charAt(n) != ' '; n--, i++) ;

        return i;
    }
}
