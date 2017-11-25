package leetcode.Heap_215;

import java.util.Arrays;

/**
 * Created by felix on 15/6/17.
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 思路：先排序
 *      其实题目要求构造Heap来做
 * AC!
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
