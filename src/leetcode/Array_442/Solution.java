package leetcode.Array_442;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by felix on 2017/11/29.
 */
public class Solution {

  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<Integer>();

    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] == nums[i]) {
        result.add(nums[i]);
      }
    }

    return result;
  }

  public static void main(String args[]) {

  }
}
