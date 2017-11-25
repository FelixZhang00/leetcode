package leetcode.HashTable_76;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by felix on 15/6/10.
 * 参考：
 * 双指针，动态维护一个区间。尾指针不断往后扫，
 * 当扫到有一个窗口包含了所有T的字符后，然后再收缩头指针，
 * 直到不能再收缩为止。最后记录所有可能的情况中窗口最小的
 */
public class Solution2 {

    public String minWindow(String S, String T) {
        if (S == null || T == null) {
            return null;
        }
        if (T.equals("") || S.equals("")) {
            return "";
        }

        //需要找到的字符-->个数
        Map<Character, Integer> needFind = new HashMap<Character, Integer>();
        //记录已经找到的字符
        Map<Character, Integer> hasFind = new HashMap<Character, Integer>();

        int lenS = S.length();
        int lenT = T.length();
        for (int i = 0; i < lenT; i++) {
            char ch = T.charAt(i);
            if (!needFind.containsKey(ch)) {
                needFind.put(ch, 1);
                hasFind.put(ch, 0);
            } else {
                needFind.put(ch, needFind.get(ch) + 1);
            }
        }

        int newBegin = -1;
        int newEnd = S.length();
        int count = 0;
        for (int begin = 0, end = 0; end < lenS; end++) {
            char ch = S.charAt(end);
            if (needFind.containsKey(ch)) {
                hasFind.put(ch, hasFind.get(ch) + 1);
                if (hasFind.get(ch) <= needFind.get(ch)) {
                    count++;
                }
                if (count == lenT) {
                    char temp = S.charAt(begin);
                    while (!needFind.containsKey(temp) || hasFind.get(temp) > needFind.get(temp)) {

                        if (needFind.containsKey(temp) && hasFind.get(temp) > needFind.get(temp)) {
                            hasFind.put(temp, hasFind.get(temp) - 1);
                        }

                        begin = begin + 1;
                        temp = S.charAt(begin);
                    }

                    if (end - begin < newEnd - newBegin) {
                        newEnd = end;
                        newBegin = begin;
                    }
                }
            }
        }

        if (newBegin == -1) {
            return "";
        } else {
            return S.substring(newBegin, newEnd + 1);
        }
    }
}
