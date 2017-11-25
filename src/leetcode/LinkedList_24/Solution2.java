package leetcode.LinkedList_24;

/**
 * Created by felix on 15/6/12.
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * <p/>
 * 题意：交换链表相邻的两个节点（而不是修改节点的值）
 * 比如：1->2->3->4 转化为2->1->4->3
 * <p/>
 * <p/>
 * 解法2：交换节点需要考虑前一个节点，指针变化时需要用中间节点。
 * AC!
 * Runtime: 336 ms
 */
public class Solution2 {
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
        ListNode prev = head;

        //先交换开头两个元素，注意修改head指向的位置
        if (p != null && p.next != null) {
            ListNode temp = p.next;
            p.next = p.next.next;
            temp.next = p;
            head = temp;

            prev = p;
            p = p.next;
        }

        while (p != null && p.next != null) {
            ListNode temp=p.next;
            prev.next = p.next;
            p.next=temp.next;
            temp.next = p;

            prev=p;
            p = p.next;
        }

        return head;

    }


}
