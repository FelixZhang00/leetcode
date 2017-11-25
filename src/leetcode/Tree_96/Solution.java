package leetcode.Tree_96;

/**
 * Created by felix on 15/5/9.
 * <p/>
 * https://leetcode.com/problems/unique-binary-search-trees/
 * <p/>
 * 参考：
 * dp[i]表示共有i个节点时，能产生的BST树的个数
 * 以i为根节点时，其左子树构成为[0,...,i-1],其右子树构成为[i+1,...,n]构成
 * AC!
 */
public class Solution {

    public int numTrees(int n) {
        int dp[] = new int[n + 1];
        if (n == 0) return 1;

        dp[0] = 1; //空树的个数必然为1
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {      //遍历所有root点
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
