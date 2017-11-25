package leetcode.HashTable_3;

import java.util.HashMap;

/**
 * Created by felix on 15/5/20.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p/>
 * 题目理解不全面
 * 比如：
 * "dvdf" 应该输出3
 * <p/>
 * 修改后：
 * 超时
 * 还是超时
 *
 *测试不通过z
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int longest = 0;
        int tempLength = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                start = map.get(c) ;
                map.clear();
                tempLength = i - start;
                map.put(c,i);
            } else {
                map.put(c, i);
                tempLength++;
            }
            longest = Math.max(longest, tempLength);
        }

        return longest;
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring("dvdf");
        System.out.print(i);

    }
}
