package leetcode.DP_152;

/**
 * Created by felix on 15/5/9.
 * <p/>
 * https://leetcode.com/problems/maximum-product-subarray/
 * <p/>
 * Runtime: 356 ms
 */
public class Solution_152 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int maxLocal = nums[0];
        int minLocal = nums[0];
        int global = maxLocal;

        for (int i = 1; i < nums.length; i++) {
            int maxCopy = maxLocal;
            maxLocal = Math.max(
                    Math.max(nums[i] * maxLocal, nums[i]),      //考虑到某个元素可能为0，就不延续原先的子序列了
                    nums[i] * minLocal);
            minLocal = Math.min(
                    Math.min(nums[i] * maxCopy, nums[i]),
                    nums[i] * minLocal);
            global = Math.max(global, maxLocal);
        }

        return global;
    }

}
