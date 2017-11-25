package leetcode.BinarySearch_35;

/**
 * Created by felix on 15/6/11.
 * https://leetcode.com/problems/search-insert-position/
 * <p/>
 * 题意：在一个排序好的数组中，找出target在数组中的下标，
 * 如果不存在的话，找出它应该被插入的位置
 * <p/>
 * 思路：二分查找
 * <p/>
 * AC!
 * 388 ms
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else if (nums[mid] > target) hi = mid - 1;
            else return mid;            //相等的情况
        }

        return lo;      //通过实验可以验证
    }
}
