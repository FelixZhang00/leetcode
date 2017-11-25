package leetcode.LinkedList_141;

/**
 * Created by felix on 15/6/5.
 * https://leetcode.com/problems/linked-list-cycle/
 * 思路：从链表开头有一个慢指针（每次移动一格）和快指针（每次移动两格），
 * 如果在null之前最终两者碰到一起说明有环。
 *
 * Accepted!
 * 简单题，需要一定的技巧。
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) return true;
        }
        return false;
    }
}
