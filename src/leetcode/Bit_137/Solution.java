package leetcode.Bit_137;

import java.util.Arrays;

/**
 * Created by felix on 15/6/12.
 * https://leetcode.com/problems/single-number-ii/
 * <p/>
 * 思路1：
 * 先排序，遍历数组，根据下一个位置判断前一个位置的元素是否是single
 *
 * AC!
 * 344ms
 */
public class Solution {
    public int singleNumber(int[] nums) {
        if ( nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int count = 0;
        int temp = nums[0];
        int i = 1;
        for (; i < nums.length; i++) {
            if (temp == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    break;
                }
                count = 0;
                temp=nums[i];
            }
        }
         return nums[i-1];

    }
}
