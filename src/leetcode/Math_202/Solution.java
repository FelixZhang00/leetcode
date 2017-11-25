package leetcode.Math_202;

import java.util.HashMap;

/**
 * Created by felix on 15/6/16.
 * https://leetcode.com/problems/happy-number/
 * 思路：用hashmap保留所有中间结果，判断是否有重复的，有的话就直接退出
 *
 * AC!
 */
public class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        map.put(n, true);
        int sum = n;
        while (sum != 1) {
            sum=0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = sum;
            if (map.containsKey(n)){
                return false;
            }else{
                map.put(n, true);
            }
        }

        return true;

    }
}
