package leetcode.Math_728;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 2017/11/25.
 * https://leetcode.com/problems/self-dividing-numbers/description/
 */
public class Solution {

  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> results = new ArrayList<Integer>(right - left);
    int current = left;
    while (current <= right) {
      if (isDividingNumber(current)) {
        results.add(current);
      }

      current++;
    }
    return results;
  }

  private boolean isDividingNumber(int number) {
    int end = number % 10;
    int remainder = number;
    while (remainder != 0) {
      if (end != 0 && number % end == 0) {

      } else {
        return false;
      }

      remainder = remainder / 10;
      end = remainder % 10;
    }

    return true;
  }

  public static void main(String args[]) {
    Solution solution = new Solution();
    List<Integer> integerList = solution.selfDividingNumbers(1, 22);
    printList(integerList);
  }

  private static void printList(List<Integer> integerList) {
    for (int i : integerList) {
      System.out.print("," + i);
    }
  }
}
