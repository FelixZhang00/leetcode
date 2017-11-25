package leetcode.LinkedList_83;

/**
 * Created by felix on 15/4/5.
 * <p/>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * <p/>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 思考：如果未排序该如何处理
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head; //这时不可能有重复的元素
        ListNode node = head;
        ListNode pre = node;
        int temp = node.val;
        node = node.next;
        while (node != null) {
            if (node.val == temp) {
                pre.next = node.next;
                node = pre.next;
            } else {
                temp = node.val;
                pre = node;
                node = node.next;
            }

        }
        return head;
    }
}
