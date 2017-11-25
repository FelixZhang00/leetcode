package leetcode.LinkedList_19;

/**
 * Created by felix on 15/4/5.
 * <p/>
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * <p/>
 * <p/>
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p/>
 * For example,
 * <p/>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p/>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //两个指针，相距为n,当第二个指针到达末尾时，
        ListNode first = head, second = head;
        for (int i = 0; i < n; i++) {
            second = second.next;
        }
        if (second == null) { //second指针指向了末尾，说明删除的是头节点
            head = head.next;
        } else {
            while (second.next != null) {
                second = second.next;
                first = first.next;
            }
            first.next = first.next.next;
        }

        return head;
    }

    /**
     * 暴力解法
     *
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        //第一次遍历，得到节点的个数
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        node = head;
        //第二次遍历，找到要删除节点的前一个节点
        for (int i = 0; i < count - n - 1; i++) {
            node = node.next;
        }
        if (n == count) {  //需要删除头节点的情况
            head = head.next;
        } else {
            node.next = node.next.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
