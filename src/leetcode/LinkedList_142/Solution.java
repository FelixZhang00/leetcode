package leetcode.LinkedList_142;

/**
 * Created by felix on 15/6/16.
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * 参考《程序员面试金典》
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

    public ListNode detectCycle(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr){    //碰撞
                break;
            }
        }

        //检查是否碰撞
        if(fastPtr==null||fastPtr.next==null){
            return null;
        }

        /**
         * 将slow指向首部，fast指向碰撞处，
         * 两者距离环路起始处k步，若两者以同样的速度移动，
         * 则必定会在环路起始处碰在一起
         */
        slowPtr=head;
        while(slowPtr!=fastPtr){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next;
        }

        return fastPtr;
    }

}
