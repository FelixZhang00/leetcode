package leetcode.Tree_114;

/**
 * Created by felix on 15/6/23.
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * <p/>
 * 思路：前序遍历
 */
public class Solution_114 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        dfs(root);
    }


    private void dfs(TreeNode node) {
        if (isLeaf(node)) return;

        dfs(node.left);
        //换位
        TreeNode x = node.right;
        if (node.left != null) {

            node.left.right = x;
            node.right = node.left;
            node.left=null;

        }
        dfs(node.right);

    }

    private boolean isLeaf(TreeNode node) {
        return node == null || (node.left == null && node.right == null);
    }
}
