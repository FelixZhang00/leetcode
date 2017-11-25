package leetcode.Array_11;

/**
 * Created by felix on 15/6/5.
 * https://leetcode.com/problems/container-with-most-water/
 * 先用暴力解法
 * 每两条边一组，遍历之，找到最大的面积
 * 时间复杂度O(n^2)
 * Time Limit Exceeded!
 */
public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tempArea = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, tempArea);
            }
        }
        return maxArea;
    }
}
