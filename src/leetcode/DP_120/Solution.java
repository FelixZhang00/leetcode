package leetcode.DP_120;

import java.util.Arrays;
import java.util.List;

/**
 * Created by felix on 15/6/19.
 * https://leetcode.com/problems/triangle/
 * <p/>
 * 思路：基本的动态规划
 * AC!
 * OK，题目要求空间限制：O(n) extra space, where n is the total number of rows in the triangle
 * 而我的算法用的空间是最后一行的个数的大小，和行数是一样的。
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int maxLen = triangle.get(triangle.size() - 1).size();  //最后一行有多少个

        int[] dp = new int[maxLen];     //记录从top到当前行第i个位置时的path sum

        dp[0] = triangle.get(0).get(0);

        for (int r = 1; r < rows; r++) {
            List<Integer> item = triangle.get(r);
            int len = item.size();

            for (int i = len - 1; i >= 0; i--) { //反过来，放置覆盖
                if (i == 0) {
                    dp[i] = dp[i] + item.get(i);
                } else if (i == len - 1) {     //当前行中最后一个元素
                    dp[i] = dp[i - 1] + item.get(i);
                } else {                  //中间的元素，都可以从上一行用两种方式到达，取最小的
                    dp[i] = Math.min(dp[i - 1] + item.get(i), dp[i] + item.get(i));
                }
            }
        }

        Arrays.sort(dp);
        return dp[0];
    }
}
