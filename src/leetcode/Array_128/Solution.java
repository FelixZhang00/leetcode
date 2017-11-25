package leetcode.Array_128;

import java.util.Arrays;

/**
 * Created by felix on 15/6/16.
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * AC!
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int cntMax = 1;
        int cntTemp = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) continue;    //重复的数字不算
            if (nums[i] - prev == 1) {       //属于连续的数字
                cntTemp++;
            } else {
                cntTemp = 1;
            }
            cntMax = Math.max(cntMax, cntTemp);
            prev = nums[i];
        }

        return cntMax;
    }

}
