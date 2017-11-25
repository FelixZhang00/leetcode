package leetcode.HashTable_3;

/**
 * Created by felix on 15/6/1.
 * * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 例子：
 * "dvdf" 应该输出3
 * <p/>
 * 解题思路：
 * 历遍字符串，当当前字符出现过的时候，子串开始位置+1，否则更新locs数组中的hash值为当前位置。
 * Accepted!
 */
public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        int locs[] = new int[256];            //记录字符最新出现的位置。一开始为-1，表示没有出现过。
        for (int i = 0; i < locs.length; i++) {
            locs[i] = -1;
        }

        int max = 0;      //存放最后的结果，即最长子串
        int idx = -1;     //保存当前子串开始的位置,用于计算子串的长度，所以其实idx+1才是真正子串的开始位置
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (locs[c] > idx) {        //当前字符
                idx = locs[c];          //更新子串开始位置为重复字符中的前者的位置+1
            }

            max = Math.max(max, i - idx);   //最长的长度可能在遍历的中途得到

            locs[c] = i;
        }
        return max;

    }
}
