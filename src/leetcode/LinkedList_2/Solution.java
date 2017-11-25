package leetcode.LinkedList_2;

/**
 * Created by felix on 15/5/20.
 * https://leetcode.com/problems/add-two-numbers/
 * <p/>
 * 仔细看例子会发现很简单
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * 技巧：创建不输出的虚拟点
 */
public class Solution {

    // Definition for singly-linked list.

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newHead = new ListNode(0);     //创建一个不输出的虚拟点
        ListNode nextNode = newHead;

        ListNode p1 = l1;
        ListNode p2 = l2;
        int sum = 0;
        boolean flag = false;     //是否进位


        while (p1 != null && p2 != null) {

            if (flag) {
                sum = p1.val + p2.val + 1;
            } else {
                sum = p1.val + p2.val;
            }

            if (sum >=10) {
                flag = true;
            } else {
                flag = false;
            }

            nextNode.next = new ListNode(sum%10);
            nextNode=nextNode.next;

            p1 = p1.next;
            p2 = p2.next;
        }

        //处理长度不相同的情况
        if (p1 == null && p2 != null) {
            while (p2 != null) {
                if (flag) {
                    sum = p2.val + 1;
                } else {
                    sum = p2.val;
                }
                if (sum >=10) {
                    flag = true;
                } else {
                    flag = false;
                }

                nextNode.next = new ListNode(sum%10);
                nextNode=nextNode.next;

                p2 = p2.next;
            }

        } else if (p1 != null && p2 == null) {
            while (p1 != null) {
                if (flag) {
                    sum = p1.val + 1;
                } else {
                    sum = p1.val;
                }
                if (sum >= 10) {
                    flag = true;
                } else {
                    flag = false;
                }

                nextNode.next = new ListNode(sum % 10);
                nextNode=nextNode.next;
                p1 = p1.next;
            }
        }


        //处理剩余进位的情况
        if (flag) {
            nextNode.next = new ListNode(1);
            nextNode=nextNode.next;
        }

        return newHead.next;
    }


    public static void main(String[] args) throws Exception {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        printNode(result);
    }

    private static void printNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " --> ");
            node = node.next;
        }

    }
}
