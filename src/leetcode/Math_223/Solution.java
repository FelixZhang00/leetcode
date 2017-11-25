package leetcode.Math_223;

/**
 * Created by felix on 15/6/20.
 * https://leetcode.com/problems/rectangle-area/
 * <p/>
 * 题意：求两个矩形覆盖的面积
 *
 * AC!
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int res = (C - A) * (D - B) + (G - E) * (H - F);    //求两个矩形面积的中和

        //假设两个矩形相交，求它的两个点的坐标
        int A1 = Math.max(A, E);
        int B1 = Math.max(B, F);
        int C1 = Math.min(C, G);
        int D1 = Math.min(D, H);

        //根据上面求出来的两个点的坐标判断两个矩形是否相交
        if (A1 >= C1 || B1 >= D1) return res; //没有相交的两种情况


        return res -(C1-A1)*(D1-B1);
    }
}
