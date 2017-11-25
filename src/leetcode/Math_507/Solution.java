package leetcode.Math_507;

/**
 * Created by felix on 2017/11/25.
 * https://leetcode.com/problems/perfect-number/description/
 */
public class Solution {

  public boolean checkPerfectNumber(int num) {
    if (num == 1 || num == 0) {
      return false;
    }
    int sum = 1;
    int start = 2;

    while (start <= Math.sqrt(num)) {
      if (num % start == 0) {
        sum += start;
        sum += num / start;
      }
      start++;
    }

    return sum == num;
  }

  public static void main(String args[]) {
    Solution solution = new Solution();
    boolean perfectNumber = solution.checkPerfectNumber(28);
    System.out.println("perfectNumber+" + perfectNumber);
  }
}
