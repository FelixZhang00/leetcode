package leetcode.HashTable_205;

import java.util.HashMap;

/**
 * Created by felix on 15/5/27.
 * https://leetcode.com/problems/isomorphic-strings/
 * You may assume both s and t have the same length.
 * Accept!
 * Runtime: 428 ms
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> map_s = new HashMap<Character, Integer>();     //字符--对应在字符串中的位置
        HashMap<Character, Integer> map_t = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char char_s = s.charAt(i);
            char char_t = t.charAt(i);

            boolean isContain_s = map_s.containsKey(char_s);
            boolean isContain_t = map_t.containsKey(char_t);
            if (isContain_s && isContain_t) {
                if (!map_s.get(char_s).equals(map_t.get(char_t)))
                    return false;     //如果都在前面出现过，但是位置不一样，那两个字符串就不是同质的
                else {
                    map_s.put(char_s, i);    //更新
                    map_t.put(char_t, i);
                }
            } else if (isContain_s || isContain_t) {
                return false;
            } else {    //在之前都没出现过
                map_s.put(char_s,i);
                map_t.put(char_t,i);
            }
        }

        return true;
    }

}
