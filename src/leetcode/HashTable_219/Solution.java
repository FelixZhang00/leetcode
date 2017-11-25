package leetcode.HashTable_219;

import java.util.Arrays;

/**
 * Created by felix on 15/6/24.
 * https://leetcode.com/problems/contains-duplicate-ii/
 * <p/>
 * 是#217的进阶题
 *
 * 题目理解错了，不应该排序的。
 */
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        Arrays.sort(nums);
        int temp = nums[0];
        int cnt = 0;      //当前temp重复的次数(不包含自己)

        for (int i = 1; i < nums.length - 1; i++) {
            if (cnt > k) return false;
            if (temp == nums[i]) {
                cnt++;
            } else {
                temp = nums[i];
                cnt = 0;
            }
        }
        if (cnt > 0) {
            return true;
        } else {
            return false;
        }

    }

}
