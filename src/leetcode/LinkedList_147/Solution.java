package leetcode.LinkedList_147;

/**
 * Created by felix on 15/6/20.
 * https://leetcode.com/problems/insertion-sort-list/
 * 题意：用插入排序法，对链表排序
 *
 * 思路：
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
            ListNode p=head;

            while (p!=null){
                ListNode q=head;
                while (q!=p){
                    if (p.val<=q.val){

                    }else {

                    }

                    q=q.next;
                }

                p=p.next;
            }

        return null;
    }
}
