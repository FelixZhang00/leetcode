package leetcode.BFS_124;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by felix on 15/5/10.
 * <p/>
 * https://leetcode.com/problems/word-ladder/
 * <p/>
 * 思路：
 * 构造图，遍历两遍词典，将所有可以转换的单词在图中的所表示顶点间连一条双向边.
 * 估计会超时
 *
 * 失败！
 */
public class Solution {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");

        Solution solution = new Solution();
        int length = solution.ladderLength("a", "c", set);
        System.out.println("length = " + length);
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Graph G = new Graph(wordDict.size());
        String[] wordArray = new String[wordDict.size()];
        wordDict.toArray(wordArray);
        for (String word : wordArray) {
            System.out.println(word);
        }
        int beginIdx = 0, endIdx = 0;
        for (int i = 0; i < wordArray.length - 1; i++) {
            if (wordArray[i].equals(beginWord)) {
                beginIdx = i;
            }
            if (wordArray[i].equals(endWord)) {
                endIdx = i;
            }
            for (int j = i + 1; j < wordArray.length; j++) {
                if (canTrans(wordArray[i], wordArray[j])) {
                    G.addEdge(i, j);
                }
            }
        }

        BreadthFirstPaths paths = new BreadthFirstPaths(G, beginIdx);
        if (!paths.hasPathTo(endIdx)) return 0;
        return paths.distTo(endIdx)+1;

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

    private class Graph {
        private final int V;
        private int E;
        private List<Integer>[] adj;


        public Graph(int V) {
            this.V = V;
            this.E = 0;
            adj = (ArrayList<Integer>[]) new ArrayList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<Integer>();
            }
        }

        public int V() {
            return V;
        }

        public void addEdge(int v, int w) {
            E++;
            adj[v].add(w);
            adj[w].add(v);
        }

        public Iterable<Integer> adj(int v) {
            return adj[v];
        }

        public String toString() {
            StringBuilder s = new StringBuilder();
            String NEWLINE = System.getProperty("line.separator");
            s.append(V + " vertices, " + E + " edges " + NEWLINE);
            for (int v = 0; v < V; v++) {
                s.append(v + ": ");
                for (int w : adj[v]) {
                    s.append(w + " ");
                }
                s.append(NEWLINE);
            }
            return s.toString();
        }

    }

    private class BreadthFirstPaths {
        private static final int INFINITY = Integer.MAX_VALUE;
        private boolean[] marked;  // marked[v] = is there an s-v path
        private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
        private int[] distTo;      // distTo[v] = number of edges shortest s-v path


        public BreadthFirstPaths(Graph G, int s) {
            System.out.println(G.toString());
            marked = new boolean[G.V()];
            distTo = new int[G.V()];
            edgeTo = new int[G.V()];
            bfs(G, s);
        }

        private void bfs(Graph G, int s) {
            Queue<Integer> q = new LinkedList<Integer>();
            for (int v = 0; v < G.V(); v++) distTo[v] = INFINITY;
            distTo[s] = 0;
            marked[s] = true;
            q.offer(s);

            while (!q.isEmpty()) {
                int v = q.poll();
                for (int w : G.adj(v)) {
                    if (!marked[w]) {
                        edgeTo[w] = v;
                        distTo[w] = distTo[v] + 1;
                        marked[w] = true;
                        q.offer(w);
                    }
                }
            }
        }

        public boolean hasPathTo(int v) {
            return marked[v];
        }

        public int distTo(int v) {
            return distTo[v];
        }

    }

}
