package leetcode.HashTable_94;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;


/**
 * Created by felix on 15/4/6.
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 中序遍历
 */
public class Solution {


    //      Definition for binary tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }


    /**
     * Solution1：用递归法中序遍历
     * Runtime: 197 ms
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderSelf(root, list);
        return list;
    }

    private void inorderSelf(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderSelf(node.left, list);
        list.add(node.val);
        inorderSelf(node.right, list);
//        list.add(node.val);
    }

    /**
     * Solution2:用迭代的方法中序遍历
     * 需要用Stack，依次压入右、根、左节点
     * 需要用HashSet判断节点是否
     *Runtime: 257 ms
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;

        Stack<TreeNode> st = new Stack<TreeNode>();
        HashSet<TreeNode> hs = new HashSet<TreeNode>();

        st.push(root);
        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            if (hs.contains(temp)) {
                list.add(temp.val);
                continue;
            }
            if (temp.right != null) st.push(temp.right);
            st.push(temp);
            hs.add(temp);
            if (temp.left != null) st.push(temp.left);

        }

        return list;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.right = node2;
        node2.left = new TreeNode(3);

        Solution solution = new Solution();
        List<Integer> list = solution.inorderTraversal2(root);
        for (int val : list) {
            System.out.println(val);
        }

    }

    private static void printTree(TreeNode root) {

    }
}
