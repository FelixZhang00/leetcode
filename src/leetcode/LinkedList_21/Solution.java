package leetcode.LinkedList_21;

/**
 * Created by felix on 15/4/5.
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * <p/>
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Solution {

    //  Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "->" + val;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node,head;
        //找到第一个节点
        if (l1.val <= l2.val) {
            node = l1;
            l1 = l1.next;
        } else {
            node = l2;
            l2 = l2.next;
        }
        head=node;

        //找较小的节点，挂到node指针的后面，再移动node指针到该节点上
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                node=l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                node=l2;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            node.next = l2;
        } else if (l2 == null) {
            node.next = l1;
        }

        return head;
    }

    private int compare(int i, int j) {
        if (i < j) return -1;
        else if (i > j) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(5);
        printNode(l1);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(7);
        printNode(l2);

        ListNode node = solution.mergeTwoLists(l1, l2);
        printNode(node);


    }

    private static void printNode(ListNode node) {
        //打印链表
        while (node != null) {
            System.out.print(node);
            node = node.next;
        }
        System.out.println();
    }
}
