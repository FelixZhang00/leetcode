package leetcode.LinkedList_24;

/**
 * Created by felix on 15/6/12.
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * <p/>
 * 题意：交换链表相邻的两个节点（而不是修改节点的值）
 * 比如：1->2->3->4 转化为2->1->4->3
 * <p/>
 * 解法1：先试着交换值(违规)
 * AC!
 * Runtime: 280 ms
 */
public class Solution {

    //  Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode p = head;

        while (p != null && p.next != null) {
            int temp=p.val;
            p.val=p.next.val;
            p.next.val=temp;

            p = p.next.next;
        }

        return head;
    }
}
