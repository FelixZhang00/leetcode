package leetcode.p477;

/**
 * Created by felix on 2017/11/30. https://leetcode.com/problems/total-hamming-distance/description/
 */
public class Solution {

  /**
   * 观察规律，其实就是每位0的个数*1的个数
   */
  public int totalHammingDistance(int[] nums) {
    int total = 0;
    int n = nums.length;
    for (int i = 0; i < 32; i++) {
      int cntOne = 0;
      for (int num : nums) {
        if ((num & (1 << i)) != 0) {
          cntOne++;
        }
      }
      total += cntOne*(n-cntOne);
    }
    return total;
  }
}
