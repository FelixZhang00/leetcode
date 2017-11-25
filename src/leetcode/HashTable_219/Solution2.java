package leetcode.HashTable_219;

import java.util.HashMap;

/**
 * Created by felix on 15/6/24.
 * https://leetcode.com/problems/contains-duplicate-ii/
 * AC!
 */
public class Solution2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();       //值-->该值在数组中的下标
        map.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);     //更新
                }
            } else {
                map.put(nums[i], i);     //更新
            }

        }

        return false;

    }
}
