package leetcode.Array_16;

import java.util.Arrays;

/**
 * Created by felix on 15/6/19.
 * https://leetcode.com/problems/3sum-closest/
 * <p/>
 * 参考：《算法》(第4版)
 *
 * AC!
 */
public class Solution2 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int N = nums.length;
        int closest = Integer.MAX_VALUE;
        boolean isFirst = true;
        for (int i = 0; i < N-2; i++) {
            for (int j = i + 1; j < N-1; j++) {
                int twoSum = nums[i] + nums[j];
                int k = rank(target - nums[i] - nums[j], j + 1, nums);    //找到在j右边的使能最接近target的第三个数的下标

                if (isFirst) {       //初始化closest，放置closest - target的结果溢出
                    closest = twoSum + nums[k];
                    isFirst = false;
                } else {
                    if (Math.abs(twoSum + nums[k] - target) < Math.abs(closest - target)) {   //有更接近target的组合，更新之
                        closest = twoSum + nums[k];
                    }
                }
            }
        }
        return closest;
    }

    /**
     * 使用二分法查找数组nums中最接近third的下标
     *
     * @param third
     * @param start
     * @param nums
     * @return
     */
    private int rank(int third, int start, int[] nums) {
        int lo = start, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < third) lo = mid + 1;
            else if (nums[mid] > third) hi = mid - 1;
            else return mid;
        }

        if (lo>nums.length-1) lo=nums.length-1;


        return lo;
    }
}
