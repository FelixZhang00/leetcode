package leetcode.HashTable_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by felix on 15/5/5.
 * https://leetcode.com/problems/anagrams/
 */
public class Solution {

    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();  //字符数组--位置索引

        for (int i = 0; i < strs.length; i++) {

            char[] chars = strs[i].toCharArray();    //目的是对当前读入的strs[i]的字符串排序
            Arrays.sort(chars);
            String anagram = new String(chars);

            if (map.containsKey(anagram)) {
                int index = map.get(anagram);
                if (index != -1) {                  //放置重复添加到结果集中
                    res.add(strs[index]);
                    map.put(anagram, -1);
                }
                res.add(strs[i]);
            } else {
                map.put(anagram, i);
            }

        }

        return res;
    }



    public static void main(String[] args) {
        String[] strs = new String[2];
        strs[0] = "tea";
        strs[1] = "apple";

        char[] temp = strs[0].toCharArray();
        Arrays.sort(temp);
        strs[0] = new String(temp);

        System.out.println(strs[0]);
    }
}
