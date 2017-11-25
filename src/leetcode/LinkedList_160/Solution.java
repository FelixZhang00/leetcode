package leetcode.LinkedList_160;

/**
 * Created by felix on 15/6/17.
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * <p/>
 * 思路：第一次遍历，获得两个链表的长度,
 * 第二次遍历时，使两个链表从同一个起跑线出发，
 * 这样做只需检查当前节点是否相同即可。
 *
 * AC!
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;

        int cntA = 0, cntB = 0;
        while (pa != null) {
            cntA++;
            pa = pa.next;
        }
        while (pb != null) {
            cntB++;
            pb = pb.next;
        }

        pa = headA;
        pb = headB;
        int dist = cntA - cntB;
        if (dist < 0) {
            while (dist < 0) {
                pb = pb.next;
                dist++;
            }
        } else {
            while (dist > 0) {
                pa = pa.next;
                dist--;
            }
        }

        while (pa != null && pb != null) {
            if (pa == pb) return pa;


            pa = pa.next;
            pb = pb.next;
        }


        return null;
    }
}
