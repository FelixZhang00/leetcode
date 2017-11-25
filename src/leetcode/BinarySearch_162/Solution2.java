package leetcode.BinarySearch_162;

/**
 * Created by felix on 15/5/31.
 * https://leetcode.com/problems/find-peak-element/
 * <p/>
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * <p/>
 * 用二分法：
 * 按照题意，num[0]是大于左边的不存在的那个元素的，num[size-1]也是大于右边那个不存在的元素的，
 * 假如不存在，那么就会有num[0]<num[1]，num[1]<num[2]，就是增序，num[size-2]<num[size-1]，
 * 这样num[size-1]就是peak elem了，所以一定存在。
 *
 * 不太理解？？
 */
public class Solution2 {

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low < high)
        {
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            if(nums[mid1] < nums[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }
}
