package leetcode.HashTable_217;

import java.util.Arrays;

/**
 * Created by felix on 15/6/11.
 *
 * 先排序,比较相邻两个是否相等。
 * AC!
 * 484 ms
 */
public class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        if (nums==null||nums.length==0) return false;
        Arrays.sort(nums);
        int temp=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(temp==nums[i]){
                return true;
            }else{
                temp=nums[i];
            }
        }

        return false;
    }
}
