package leetcode.Tree_144;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 15/6/5.
 *https://leetcode.com/problems/binary-tree-preorder-traversal/
 * Accepted！
 * 简单题
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

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        peroder(root, res);
        return res;
    }

    private void peroder(TreeNode node, ArrayList<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        peroder(node.left,res);
        peroder(node.right,res);
    }
}
