package leetcode.Sort_164;

import java.util.Arrays;

/**
 * Created by felix on 15/6/21.
 * https://leetcode.com/problems/maximum-gap/
 *
 * AC!
 */
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        Arrays.sort(nums);
        int maxGap = 0;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - temp);
            temp = nums[i];
        }

        return maxGap;
    }
}
