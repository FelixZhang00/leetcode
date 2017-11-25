package leetcode.Graph_207;

import java.util.ArrayList;

/**
 * Created by felix on 15/5/7.
 * <p/>
 * https://leetcode.com/problems/course-schedule/
 * <p/>
 * 测试数据：
 * 8, [[1,0],[2,6],[1,7],[5,1],[6,4],[7,0],[0,5],[5,1],[6,4]]
 *
 * Runtime: 379 ms
 */
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Digraph G = new Digraph(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = 0; j < prerequisites[i].length; j++) {
                G.addEdge(prerequisites[i][j], prerequisites[i][++j]);
            }
        }
        DirectedCycle dag = new DirectedCycle(G);

        return !dag.hasCycle();

    }


    private class Digraph {

        private final int V;
        private ArrayList<Integer>[] adj;

        public Digraph(int V) {
            if (V < 0)
                throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
            this.V = V;
            adj = (ArrayList<Integer>[]) new ArrayList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<Integer>();
            }
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
        }

        public int V() {
            return V;
        }

        public Iterable<Integer> adj(int v) {
            return adj[v];
        }

    }


    private class DirectedCycle {
        private boolean[] marked;        // marked[v] 顶点v是否被访问过
        private boolean[] onStack;       //保存递归调用期间栈上的所有顶点。 onStack[v] = ？顶点v是否在栈中
        private boolean hasCycle;       // 有向图中是否环

        public DirectedCycle(Digraph G) {
            marked = new boolean[G.V()];
            onStack = new boolean[G.V()];
            hasCycle = false;
            for (int v = 0; v < G.V(); v++)   //对图中每一个没有被访问过的点做深度优先遍历
                if (!marked[v]) dfs(G, v);
        }


        /**
         * 从v顶点开始做深度优先遍历
         */
        private void dfs(Digraph G, int v) {
            onStack[v] = true;
            marked[v] = true;
            for (int w : G.adj(v)) {        //遍历所有顶点v的相连点
                if (hasCycle) return;       //如果已经找到一个环就不再dfs
                else if (!marked[w]) {      //对每一个未访问过的点继续dfs
                    dfs(G, w);
                } else if (onStack[w]) {    //顶点w在之前的递归调用栈中，并且已经被访问过，构成环
                    hasCycle = true;
                }
            }
            onStack[v] = false;             //顶点v所有的相连点遍历结束,顶点v退出当前调用栈
        }

        public boolean hasCycle() {
            return hasCycle;
        }
    }


}
