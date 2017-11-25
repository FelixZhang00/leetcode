package leetcode.LinkedList_92;

/**
 * Created by felix on 15/5/31.
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * <p/>
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p/>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p/>
 * return 1->4->3->2->5->NULL.
 * <p/>
 * <p/>
 * 思路：
 * 分成左、中、右三条链路
 *
 * Accepted!
 * Runtime: 300 ms
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode p = head;          //一个移动的指针
        if (m == n) return head;    //不用变

        //处理的三分段结构的链表
        ListNode LE = null;    //记录下第一条链的末尾节点leftListEndNode
        int index = 1;                  //当前p在链表中的位置
        while (p != null && index < m) {
            LE = p;
            p = p.next;
            index++;
        }

        ListNode ME = null;
        ListNode MS = null;
        int loop = n - m + 1;                 //循环的次数
        ListNode lastNode = null;
        boolean firstLoop=true;
        while (loop != 0) {
            ListNode newNode = new ListNode(p.val);
            newNode.next = lastNode;
            lastNode = newNode;
            if (firstLoop){
                firstLoop=false;
                ME=lastNode;
            }
            MS = lastNode;
            p = p.next;
            loop--;
        }

        //把三条分散的链表连接起来
        ME.next = p;
        //没有左链的情况
        if (LE == null) {
            return MS;      //因为head指向的节点跑到后面去了。
        }
        LE.next = MS;

        return head;
    }
}
