//
// Created by tmac on 15/6/10.
// Copyright (c) 2015 me.felix. All rights reserved.
//


/**
* https://leetcode.com/problems/remove-linked-list-elements/
*  AC!
*  同样的解法用c++写就快多了
*
*/


// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(nullptr) {
    }
};


class Solution {
public:
    ListNode *removeElements(ListNode *head, int val) {
        ListNode *p = head;
        ListNode *newHead = head;
        ListNode *preNode = head;
        bool isFirst = true;
        while (p != nullptr) {
            if (isFirst) {
                if (p->val == val) {
                    newHead = newHead->next;
                    preNode = newHead;
                } else {
                    isFirst = false;
                }
            } else {
                if (p->val == val) {
                    preNode->next = p->next;
                } else {
                    preNode = p;
                }
            }

            p = p->next;
        }

        return newHead;
    }
};
