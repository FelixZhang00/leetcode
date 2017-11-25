package leetcode.Array_11;

/**
 * Created by felix on 15/6/5.
 * https://leetcode.com/problems/container-with-most-water/
 * 有两个指针分别指向头尾，计算此时的面积；
 * 比较头尾指针对应的高度，将较小高度的指针往后（头指针）或者往后移（尾指针）
 * 时间复杂度O(n)
 * Accepted!
 * Runtime: 468 ms
 */
public class Solution2 {
    public int maxArea(int[] height) {
        int lo = 0, hi = height.length - 1;
        int maxArea =0;
        while (lo <= hi) {
            maxArea = Math.max(maxArea, (hi - lo) * Math.min(height[lo], height[hi]));
            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }

        return maxArea;
    }


}
