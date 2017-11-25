package leetcode.HashTable_217;

import java.util.HashMap;

/**
 * Created by felix on 15/6/11.
 * https://leetcode.com/problems/contains-duplicate/
 * <p/>
 * Easy.
 * AC!
 * 444 ms
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], true);
            }
        }

        return false;

    }
}
