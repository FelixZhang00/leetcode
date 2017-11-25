package leetcode.String_14;

import java.util.Arrays;

/**
 * Created by felix on 15/6/20.
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * AC!
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        if (strs.length==0) return "";
        int end = 0;
        String s1 = strs[0], s2 = strs[strs.length - 1];
        while (end<s1.length()&&end<s2.length()&&s1.charAt(end) == s2.charAt(end)) {
            end++;
        }

        return strs[0].substring(0, end);
    }
}
