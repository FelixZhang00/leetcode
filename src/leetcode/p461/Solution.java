package leetcode.p461;

/**
 * Created by felix on 2017/11/25. https://leetcode.com/problems/hamming-distance/description/
 */
public class Solution {

  public int hammingDistance(int x, int y) {
    int c = x^y;
    int distance = 0;
    while(c>0){
      if(c%2==1){
        distance++;
      }
      c=c>>1;
    }
    return distance;
  }

  public static void main(String args[]) {
    Solution solution = new Solution();
    int distance = solution.hammingDistance(1, 4);
    System.out.println("distance:" + distance);
  }
}
