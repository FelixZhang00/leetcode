package leetcode.Array_287;

/**
 * Created by felix on 2017/11/26.
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class Solution {

  public int findDuplicate(int[] nums) {
    int result=0;
    for (int i = 0; i < nums.length; i++) {
      int cur = nums[i];
      for (int j = i+1; j < nums.length; j++) {
        if(cur==nums[j]){
          result=cur;
          break;
        }
      }
    }
    return result;
  }

  public static void main(String args[]) {

  }
}
