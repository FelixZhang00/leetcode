package leetcode.DP_121;

/**
 * Created by felix on 15/5/9.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 未完成
 */
public class Solution2 {
    public int maxProfit(int[] prices) {

        int local = 0;      //当前一天的最佳收益
        int global = 0;     //到目前为止最好的收益


        for (int i = 2; i < prices.length + 1; i++) {
            local = Math.max(0, local + prices[i - 1] - prices[i - 2]);
            global = Math.max(global, local);
        }

        return global;

    }
}
