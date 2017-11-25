package leetcode.LinkedList_203;

/**
 * Created by felix on 15/6/10.
 * https://leetcode.com/problems/remove-linked-list-elements/
 *
 * 思路：
 * 考虑开头的元素是否是要删除的元素：我需要一个节点表示第一个不删除的节点。
 *
 * AC！.但不够快
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode p=head;
        ListNode newHead=head;
        ListNode preNode=head;
        boolean isFirst=true;
        while(p!=null){
            if (isFirst){
                if (p.val==val){
                    newHead=newHead.next;
                    preNode=newHead;
                }else{
                    isFirst=false;
                }
            }else{
                if (p.val==val){
                    preNode.next=p.next;
                }else{
                    preNode=p;
                }
            }

            p=p.next;
        }

        return newHead;
    }
}
