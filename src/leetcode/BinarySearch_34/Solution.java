package leetcode.BinarySearch_34;

/**
 * Created by felix on 15/6/17.
 * <p/>
 * https://leetcode.com/problems/search-for-a-range/
 * <p/>
 * 思路：用二分查找，定位一个位置，再看周围是否有相同的
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int index = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target) hi = mid - 1;
            else if (nums[mid] < target) lo = mid + 1;
            else {
                index = mid;
                break;
            }
        }

        if (index == -1) {         //没有找到
            return new int[]{-1, -1};
        }

        //查看周围有无相同的元素
        int start = index, end = index;
        boolean startFound = false, endFound = false;
        while (!startFound || !endFound) {      //只要没找到就继续找

            if (!startFound) {
                if (isSafe(start - 1, nums) && (nums[start - 1] != target)) {
                    startFound = true;
                } else if (start == 0) {
                    startFound = true;
                } else {
                    start--;
                }
            }


            if (!endFound) {
                if (isSafe(end + 1, nums) && (nums[end + 1] != target)) {
                    endFound = true;
                } else if (end == nums.length - 1) {
                    endFound = true;
                } else {
                    end++;
                }
            }
        }

        return new int[]{start, end};
    }

    private boolean isSafe(int i, int[] nums) {
        return i >= 0 && i <= nums.length - 1;
    }
}
