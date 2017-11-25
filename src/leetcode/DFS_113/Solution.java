package leetcode.DFS_113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 15/5/29.
 * <p/>
 * https://leetcode.com/problems/path-sum-ii/
 * 参考第112题
 * Runtime: 440 ms
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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(root, 0, new ArrayList<Integer>(), sum, res);

        return res;
    }

    private void dfs(TreeNode node, int curr, ArrayList<Integer> item, int sum, ArrayList<List<Integer>> res) {
        if (node == null) return;

        curr += node.val;
        item.add(node.val);

        if (curr == sum && isLeaf(node)) {
            res.add(new ArrayList<Integer>(item));      //拷贝原来的列表
            return;   //没必要执行下去了，反正到这里说明已经是叶子节点了
        }


        dfs(node.left, curr, new ArrayList<Integer>(item), sum, res);       //传一个拷贝就不用担心，原来的列表被后来添加的问题
        dfs(node.right, curr, new ArrayList<Integer>(item), sum, res);
//        item.remove(item.size() - 1);                 //原来的列表可能还会被上个递归栈使用
    }


    private boolean isLeaf(TreeNode node) {
        if (node == null) throw new IllegalArgumentException("");
        if (node.left == null && node.right == null) return true;
        return false;
    }

}
