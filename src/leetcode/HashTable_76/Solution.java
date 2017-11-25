package leetcode.HashTable_76;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by felix on 15/6/10.
 * https://leetcode.com/problems/minimum-window-substring/
 * <p/>
 * 思路：
 * <p/>
 * 有两个指针b、e分别指向s的头尾，遍历s时同时移动这两个指针，直到b>e
 * 有一个map（t中的某个字符-->s中的位置）
 *
 * 错误！
 */
public class Solution {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int winSize = t.length();
        int minWin = s.length();
        for (int b = 0, e = s.length() - 1; b <= e; ) {
            if (finded(t, s.charAt(b))) {

                map.put(s.charAt(b), b);        //覆盖之前先判断当前窗体的长度
                if (map.size() == winSize) {
                    minWin = getWinLength(map);
                }


                b++;
            } else if (finded(t, s.charAt(e))) {
                map.put(s.charAt(e), e);
                e--;
            } else {
                b++;
                e--;
            }

        }


        //找起始位置和终止位置
        Integer[] array = new Integer[map.size()];
        map.values().toArray(array);

        Arrays.sort(array);

        return s.substring(array[0], array[array.length - 1] + 1);

    }

    private int getWinLength(HashMap<Character, Integer> map) {
        //找起始位置和终止位置
        Integer[] array = new Integer[map.size()];
        map.values().toArray(array);

        Arrays.sort(array);

        return array[array.length - 1]  - array[0]+1;
    }

    private boolean finded(String t, char c) {
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }
}
