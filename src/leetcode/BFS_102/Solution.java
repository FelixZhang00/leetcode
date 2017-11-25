package leetcode.BFS_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by felix on 15/5/10.
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Runtime: 344 ms
 */
public class Solution {


    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        ArrayList<Integer> level = null;
        while (!q.isEmpty()) {
            level = new ArrayList<Integer>();
            int size = q.size();                //当前层队列的大小代表了此层的节点数
            for (int i = 0; i < size; i++) {    //对当前层所有节点遍历找子节点入队
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}
