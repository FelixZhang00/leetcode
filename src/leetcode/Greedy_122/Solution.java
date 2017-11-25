package leetcode.Greedy_122;

/**
 * Created by felix on 15/6/5.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 题意：一个数组，下标表示第几天，值为这天股票的价格（只有一张）。设计算法获得最大的收益。
 * <p/>
 * 参考：
 * 这个更简单了，题目要求可以多次买卖，但是同一时间只能有一股在手里。
 * 这样就可以在每次上升子序列之前买入，在上升子序列结束的时候卖出。相当于能够获得所有的上升子序列的收益。
 * 而且，对于一个上升子序列，比如：5，1，2，3，4，0 中的1，2，3，4序列来说，对于两种操作方案：
 * 一，在1买入，4卖出；
 * 二，在1买入，2卖出同时买入，3卖出同时买入，4卖出；
 * 这两种操作下，收益是一样的。
 *
 * Accepted!
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int p = 0;
        for (int i = 1; i < prices.length; ++i) {
            int delta = prices[i] - prices[i - 1];
            if (delta > 0) {
                p += delta;
            }
        }
        return p;

    }
}
