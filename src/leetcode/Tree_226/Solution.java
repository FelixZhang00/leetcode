package leetcode.Tree_226;

/**
 * Created by felix on 15/6/14.
 * <p/>
 * https://leetcode.com/problems/invert-binary-tree/
 * 很简单的一道题，只要做后序遍历即可（分别翻转左后子树自己的孩子节点，再翻转自己的左右节点）。
 *
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

    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) return null;

        dfs(node.left);
        dfs(node.right);
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;


        return node;
    }

}
