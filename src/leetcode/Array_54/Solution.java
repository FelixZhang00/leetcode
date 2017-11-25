package leetcode.Array_54;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 15/6/16.
 * <p/>
 * https://leetcode.com/problems/spiral-matrix/
 * 题意：
 * 返回一个二维数组的螺旋序列
 * 思路：设置4个拐角变量，当遍历matrix中遇到这些点时就变换方向
 *
 * AC!
 */
public class Solution {

    //遍历matrix时当前的状态
    enum STATE {
        toRight, toDown, toLeft, toTop
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix==null||matrix.length==0) return res;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int N = rows * cols;

        //初始化边界点
        int topBound = 0, rightBound = cols, bottomBound = rows, leftBound = -1;

        int cnt = 0;  //记录遍历matrix时，当前将遍历元素是第几个
        int r = 0, c = 0;   // 记录遍历matrix时当前的行号、列号
        STATE state = STATE.toRight;

        while (cnt != N) {
            if (state == STATE.toRight) {
                    if (c == rightBound) {
                        //一些更新操作
                        c--;
                        r++;
                        state = STATE.toDown;
                        rightBound--;
                        continue;
                    }
                    res.add(matrix[r][c++]);
            } else if (state == STATE.toDown) {
                if (r==bottomBound){
                    r--;
                    c--;
                    state=STATE.toLeft;
                    bottomBound--;
                    continue;
                }
                res.add(matrix[r++][c]);
            }else if(state==STATE.toLeft){
                if (c==leftBound){
                    c++;
                    r--;
                    state=STATE.toTop;
                    leftBound++;
                    continue;
                }
                res.add(matrix[r][c--]);
            }else if(state==STATE.toTop){
                if (r==topBound){
                    r++;
                    c++;
                    state=STATE.toRight;
                    topBound++;
                    continue;
                }
                res.add(matrix[r--][c]);
            }



            cnt++;
        }

        return res;
    }


//    public boolean contain() {
//        List<Integer> list = new ArrayList<Integer>();
////        list.add(1, 10);      //当前为空，向下标为1插入值会报错。
//        list.add(0, 10);
//
//        return list.get(0) != null;
//    }
}
