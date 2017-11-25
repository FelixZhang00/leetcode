package leetcode.Tree_110;

/**
 * Created by felix on 15/6/14.
 * <p/>
 * https://leetcode.com/problems/balanced-binary-tree/
 * <p/>
 * 题意：
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * <p/>
 * <p/>
 * <p/>
 * 思路：
 * 后序遍历，比较左右子树的高度
 * AC!
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

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return dfs(root, 0) != -1;
    }

    /**
     * @param node
     * @param d
     * @return -1表示其中有一棵子树不符合条件
     */
    private int dfs(TreeNode node, int d) {

        if (node == null) return d - 1;

        int leftHeight = dfs(node.left, d + 1);
        int rightHeight = dfs(node.right, d + 1);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight);
        } else {
            return -1;
        }
    }
}
