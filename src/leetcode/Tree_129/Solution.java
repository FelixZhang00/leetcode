package leetcode.Tree_129;

/**
 * Created by felix on 15/6/16.
 * <p/>
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * <p/>
 * 题意：
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * <p/>
 * 思路：
 * 从最小的子树算起，回溯累加
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

    public int sumNumbers(TreeNode root) {
        int sum = dfs(root, 0);
        return sum;
    }

    /**
     * @param node
     * @param curSum
     * @return
     */
    private int dfs(TreeNode node, int curSum) {
        if (node == null) {
            return 0;
        }

        curSum = curSum * 10 + node.val;
        if (isLeaf(node)) {
            return curSum;
        }

        int leftSum = dfs(node.left, curSum);
        int rightSum = dfs(node.right, curSum);
        return leftSum + rightSum;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
