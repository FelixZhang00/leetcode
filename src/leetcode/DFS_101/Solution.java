package leetcode.DFS_101;

/**
 * Created by felix on 15/5/7.
 * <p/>
 * https://leetcode.com/problems/symmetric-tree/
 * <p/>
 * 对两课子树同时进行递归判断
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {

        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;
        if (leftNode.val != rightNode.val) return false;

        //当前深度d左右两个节点对称，下面该继续爬下去

        boolean isLeft = isSymmetric(leftNode.left, rightNode.right);
        boolean isRight = isSymmetric(leftNode.right, rightNode.left);

        return isLeft && isRight;
    }
}
