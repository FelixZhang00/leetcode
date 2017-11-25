//
// Created by tmac on 15/6/10.
// Copyright (c) 2015 me.felix. All rights reserved.
//

/**
* AC!
* Runtime: 37 ms
*/

#include <vector>
#include <map>

using namespace std;

/**
* Definition for binary tree with next pointer.
**/
struct TreeLinkNode {
    int val;
    TreeLinkNode *left, *right, *next;

    TreeLinkNode(int x) : val(x), left(nullptr), right(nullptr), next(nullptr) {
    }
};

class Solution {

public:
    TreeLinkNode *dfs(TreeLinkNode *pNode, int d, map<int, TreeLinkNode *> &tier) {
        if (pNode == nullptr) return nullptr;

        //中序遍历
        dfs(pNode->left, d + 1, tier);
        TreeLinkNode *p = pNode;


        if (tier.find(d) == tier.end()) {  //没有当前层编号
            tier[d] = p;
        } else {
            tier[d]->next = p;
            tier[d] = p;
        }


        dfs(pNode->right, d + 1, tier);

        return pNode;
    }

    void connect(TreeLinkNode *root) {

        map<int, TreeLinkNode *> tier;      //层号-->当前节点
        dfs(root, 0, tier);
    }


};


