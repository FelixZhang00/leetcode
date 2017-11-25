package leetcode.LinkedList_86;

/**
 * Created by felix on 15/5/29.
 * https://leetcode.com/problems/partition-list/
 * <p/>
 * 题意：给定一个单链表和一个x，把链表中小于x的放到前面，大于等于x的放到后面，每部分元素的原始相对位置不变。
 * <p/>
 * 思路：其实很简单，遍历一遍链表，把小于x的都挂到head1后，把大于等于x的都放到head2后，最后再把大于等于的链表挂到小于链表的后面就可以了。
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


    public ListNode partition(ListNode head, int x) {
        ListNode head1=new ListNode(0);     //放置比x小的节点。当前这个节点是虚拟点，要删除
        ListNode head2=new ListNode(0);     //放置比x大的节点

        ListNode p=head;
        ListNode q1=head1;
        ListNode q2=head2;

        while (p!=null){
            if (p.val<x){
                q1.next=new ListNode(p.val);
                q1=q1.next;
            }else{
                q2.next=new ListNode(p.val);
                q2=q2.next;
            }
            p=p.next;
        }

        q1.next=head2.next;  //去掉head2的虚拟点
        return head1.next;      //去掉head1的虚拟点
    }


}
