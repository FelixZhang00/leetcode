package leetcode.HashTable_645;

import java.util.Arrays;

/**
 * Created by felix on 2017/11/25.
 * https://leetcode.com/problems/set-mismatch/description/
 */
public class Solution {
  public int[] findErrorNums(int[] nums) {
    int[] results = new int[2];
    results[0]=-1;
    results[1]=-1;

    int cusor = 0;
    int[] copy = new int[nums.length];

    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if(i>0 && nums[i-1]==nums[i]){
        results[0]=nums[i];
      }else{
        copy[cusor++] = nums[i];
      }
    }

    for (int i = 0; i < copy.length; i++) {
      if(i+1!=copy[i]){
        results[1]=i+1;
        break;
      }
    }

    return results;
  }

  public static void main(String args[]) {
    Solution solution = new Solution();
    int[] nums = {1, 2, 2, 4};
    int[] errorNums = solution.findErrorNums(nums);
  }
}
