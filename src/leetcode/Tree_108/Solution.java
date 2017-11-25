package leetcode.Tree_108;

/**
 * Created by felix on 15/6/11.
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * <p/>
 * 题意：有一个递增的数组，把它转化成一棵高度平衡的搜索二叉树（BST,即左<中<右），要求降低，并非完全二叉树
 * <p/>
 * <p/>
 * 思路2：
 * 给你一个array数组，让你求出这个数组所能组成的一个平衡的二叉树，
 * 很明显的递归问题哈，用分治的思想把中间的结点作为根结点，再一直递归下去就可以了
 *
 *
 * AC!
 * 324 ms
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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null||nums.length==0) return null;
        TreeNode root = dfs(nums, 0, nums.length-1);

        return root;
    }


    /**
     * @param nums
     * @param b    起点
     * @param e    终点
     * @return
     */
    private TreeNode dfs(int[] nums, int b, int e) {
        if (b > e) return null;

        int mid = b + (e - b) / 2;      //通过公式转化，可以写更简洁的方法 mid=(b+e)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, b, mid - 1);
        node.right = dfs(nums, mid + 1, e);
        return node;
    }
}
