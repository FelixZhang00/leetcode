package leetcode.Tree_100;

/**
 * Created by felix on 15/6/5.
 * https://leetcode.com/problems/same-tree/
 * <p/>
 * 思路：同时对两棵树判断左右子树，如果有一个为空另一个不为空，返回false;值不相同也返回false.
 * 简单题
 * Accepted！
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (!(p != null && q != null)) return false;       //其中一个为空，另一个不为空

        //剩下的p、q都不为空
        if (p.val != q.val) return false;

        //p、q的值都相等的情况下
        boolean leftSame = dfs(p.left,q.left);
        boolean rightSame=dfs(p.right,q.right);
        return leftSame&&rightSame;
    }
}
