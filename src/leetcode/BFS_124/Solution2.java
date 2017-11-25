package leetcode.BFS_124;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by felix on 15/5/10.
 * <p/>
 * 参考：
 * 从beginWord开始，放入队列q,并放入map（键：单词，值：距离）。
 * 然后变换单词的每个字母为a-z，期间在词典中找这个新造的词，
 * 如果找到了，就在map中记录，并把它放到队列中。
 * 经典的BFS模型！
 *
 * Runtime: 783 ms
 */
public class Solution2 {

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (beginWord == null || endWord == null || beginWord.equals(endWord) || beginWord.length() != endWord.length())
            return 0;

        if (isOneWordDiff(beginWord, endWord))
            return 2;

        Queue<String> queue = new LinkedList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        queue.offer(beginWord);
        map.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String headWord = queue.poll();
            int headDist = map.get(headWord);

            for (int i = 0; i < headWord.length(); i++) {  //从每一个位置开始替换成a~z
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (headWord.charAt(i) == ch) continue;    //新造的单词和原来的一样，重新造过

                    StringBuilder sb = new StringBuilder(headWord);
                    sb.setCharAt(i, ch);
                    String createdWord= sb.toString();

                    if (createdWord.equals(endWord)) {
                        return headDist + 1;       //找到了直接返回
                    }


                    if (wordDict.contains(createdWord)                   //在字典中找到了新造的词
                            && !map.containsKey(createdWord)) {          //并且没有路径更短的词存在
                        queue.offer(createdWord);
                        map.put(createdWord, headDist + 1);
                    }

                }

            }
        }
        return 0;

    }



    /**
     * 已知word1和word2长度相同
     * 判断word1和word2能否互换：只有一个字符不同
     *
     * @return
     */
    private boolean canTrans(String word1, String word2) {
        int size = word1.length();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isOneWordDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff >= 2)
                    return false;
            }
        }

        return diff == 1;
    }

}
