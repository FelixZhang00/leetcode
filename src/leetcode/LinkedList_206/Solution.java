package leetcode.LinkedList_206;

/**
 * Created by felix on 15/5/31.
 * <p/>
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Accepted!
 * Runtime: 288 ms
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

    public ListNode reverseList(ListNode head) {
        ListNode p=head;
        ListNode lastNode=null;
        while (p!=null){
            ListNode newNode=new ListNode(p.val);
            newNode.next=lastNode;
            lastNode=newNode;
            p=p.next;
        }

        return lastNode;
    }
}
