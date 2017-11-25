package leetcode.DFS_104;

/**
 * Created by felix on 15/5/7.
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }


    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode x, int d) {
        if (x == null) return d;
        return Math.max(dfs(x.left, d + 1), dfs(x.right, d + 1));
    }

//    private boolean isLeaf(TreeNode x) {
//        return x.left == null && x.right == null;
//    }
}
