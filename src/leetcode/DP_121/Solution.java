package leetcode.DP_121;

/**
 * Created by felix on 15/5/9.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * <p/>
 * 关键：
 * 预知未来
 *
 * Runtime: 298 ms
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int local = 0;  //在当前一天卖出的最佳交易,需要先知道都一天的情况
        int global = 0; //到目前为止最好的交易

        for (int i = 0; i < prices.length - 1; i++) {
            local = Math.max(0, local + prices[i + 1] - prices[i]);
            global = Math.max(global, local);
        }

        return global;

    }
}
