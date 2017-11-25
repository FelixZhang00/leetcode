package leetcode.Tree_145;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 15/6/14.
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
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

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        dfs(root, res);

        return res;
    }

    private void dfs(TreeNode node, ArrayList<Integer> res) {
        if (node==null) return;

        dfs(node.left,res);
        dfs(node.right,res);
        res.add(node.val);
    }
}
