package leetcode.LinkedList_237;

/**
 * Created by felix on 15/7/23.
 * <p/>
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * 题意：只给要删除的node，删除它
 * <p/>
 * 思路：将后面的的值往前复制
 *
 *
 * Accepted!
 */
public class Solution {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {


        ListNode lastNode = node;
        while (node != null && node.next != null) {
            node.val = node.next.val;
            lastNode = node;
            node = node.next;
        }


        if (lastNode != null) {
            lastNode.next = null;
        }


    }
}
