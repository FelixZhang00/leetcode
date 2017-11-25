package leetcode.BinarySearch_50;

/**
 * Created by felix on 15/6/20.
 * https://leetcode.com/problems/powx-n/
 * <p/>
 * 超时
 *
 */
public class Solution {

    public double myPow(double x, int n) {
//        return Math.pow(x,n);

        return dfs(x, 0, n - 1);

    }

    private double dfs(double x, int lo, int hi) {
        if (lo>=hi){
            return x;
        }

        double midVal;
        if ((lo + hi) % 2 == 0) {
            midVal = x;
        } else {
            midVal = 1;
        }

        int mid = (lo + hi) / 2;
        double left=dfs(x,lo,mid-1);
        double right=dfs(x,mid+1,hi);

        return midVal*left*right;
    }


}
