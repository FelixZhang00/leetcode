package leetcode.DFS_111;

/**
 * Created by felix on 15/5/7.
 * <p/>
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
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

    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode x) {
        if (x == null) return 0;
        int leftNum = dfs(x.left);
        int rightNum = dfs(x.right);

        if (leftNum == 0 && rightNum == 0) return 1;
        if (leftNum == 0) leftNum = Integer.MAX_VALUE;
        if (rightNum == 0) rightNum = Integer.MAX_VALUE;
        return Math.min(leftNum, rightNum)+1;
    }
}
