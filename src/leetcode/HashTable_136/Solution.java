package leetcode.HashTable_136;

import java.util.HashMap;

/**
 * Created by felix on 15/6/5.
 * https://leetcode.com/problems/single-number/
 * 题意：已知一个数组中除了一个元素外，其余元素都出现2次，找到那个独一无二的元素
 * <p/>
 * 思路：遍历数组，将元素存入hash表中，如果已经存在就删除它，最后在hash表中剩下的元素就是要找的元素。
 * Accepted!
 * 简单题。
 */
public class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], true);
            }
        }

        return map.keySet().iterator().next();

    }

    public static void main(String[] args) {

    }
}
