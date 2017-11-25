package leetcode.Array_16;

import java.util.Arrays;

/**
 * Created by felix on 15/6/19.
 * https://leetcode.com/problems/3sum-closest/
 * 思路：
 * 没有做出来：最后测试通过率为：117 / 120
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;
        boolean isFirst = true;
        int start = 0, end = nums.length - 1;
        while (end - start >= 2) {      //两个指针间能至少能容纳3个元素
            int twoSum = nums[start] + nums[end];
            int p = start + 1;       //设置第三个指针

            while (p != end) {
                if (isFirst) {       //初始化closest，放置closest - target的结果溢出
                    closest=twoSum + nums[p];
                    isFirst = false;
                } else {
                    if (Math.abs(twoSum + nums[p] - target) < Math.abs(closest - target)) {   //有更接近target的组合，更新之
                        closest = twoSum + nums[p];
                    }
                }
                p++;
            }

            if (closest < target) { //说明下次应该换个大点的试试，所以start往右移一位
                start++;
            } else if (closest > target) {
                end--;
            } else {        //如果相同,直接跳出
                break;
            }
        }

        return closest;
    }

}
