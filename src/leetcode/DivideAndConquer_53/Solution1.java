package leetcode.DivideAndConquer_53;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by felix on 15/4/14.
 * https://leetcode.com/problems/maximum-subarray/
 *
 * 错！！
 *
 * 题目理解错了，是中间任意一连串的数据构成最大数
 */
public class Solution1 {

    public int maxSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();    //存放迄今为止构成最大和的数组中的索引--最大和

        int maxIndex = 0;
        int sum = nums[0];
        map.put(maxIndex, sum);
        for (int i = 1; i < nums.length; i++) {
            int max = map.get(maxIndex);
            sum += nums[i];
            if (sum >= max) {
                maxIndex = i;
                map.put(maxIndex, sum);
            }

        }

        return map.get(maxIndex);
    }

}
