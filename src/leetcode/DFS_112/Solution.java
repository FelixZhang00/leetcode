package leetcode.DFS_112;

/**
 * Created by felix on 15/5/29.
 * https://leetcode.com/problems/path-sum/
 *
 * Runtime: 376 ms
 * Accepted!
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

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    /**
     * @param node 当前达到的节点
     * @param curr 当前和
     * @param sum
     * @return
     */
    private boolean dfs(TreeNode node, int curr, int sum) {
        if (node == null) return false;
        curr += node.val;
        if (curr == sum && isLeaf(node)) return true;

        boolean leftHasPath = dfs(node.left, curr, sum);
        boolean rightHasPath = dfs(node.right, curr, sum);
        return leftHasPath || rightHasPath;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) throw new IllegalArgumentException("");
        if (node.left == null && node.right == null) return true;
        return false;
    }
}
