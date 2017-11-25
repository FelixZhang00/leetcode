package leetcode.BinarySearch_162;

/**
 * Created by felix on 15/5/31.
 * https://leetcode.com/problems/find-peak-element/
 * <p/>
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * Accepted!
 * 暴力解法。
 * Runtime: 268 ms
 */
public class Solution {
    public int findPeakElement(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (isPeek(nums, i)) {
                return i;
            }
        }
        return 0;
    }

    private boolean isPeek(int nums[], int index) {
        int mid = nums[index];
        int pre = index == 0 ? Integer.MIN_VALUE : nums[index - 1];
        int next = (index == nums.length - 1) ? Integer.MIN_VALUE : nums[index + 1];


        if (pre < mid && mid > next) {
            return true;
        } else {
            return false;
        }
    }
}
