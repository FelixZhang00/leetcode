package leetcode.Array_59;

/**
 * Created by felix on 15/6/16.
 * https://leetcode.com/problems/spiral-matrix-ii/
 *
 * 与第54题思路类似
 * AC!
 */
public class Solution {

    //遍历matrix时当前的状态
    enum STATE {
        toRight, toDown, toLeft, toTop
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int rows =n;
        int cols =n;
        int N = rows * cols;

        //初始化边界点
        int topBound = 0, rightBound = cols, bottomBound = rows, leftBound = -1;

        int cnt = 0;  //记录遍历matrix时，当前将遍历元素是第几个
        int r = 0, c = 0;   // 记录遍历matrix时当前的行号、列号
        STATE state = STATE.toRight;
        int data=1;     //存放到matrix中的内容
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
                matrix[r][c++]=data++;
            } else if (state == STATE.toDown) {
                if (r==bottomBound){
                    r--;
                    c--;
                    state=STATE.toLeft;
                    bottomBound--;
                    continue;
                }
                matrix[r++][c]=data++;
            }else if(state==STATE.toLeft){
                if (c==leftBound){
                    c++;
                    r--;
                    state=STATE.toTop;
                    leftBound++;
                    continue;
                }
                matrix[r][c--]=data++;
            }else if(state==STATE.toTop){
                if (r==topBound){
                    r++;
                    c++;
                    state=STATE.toRight;
                    topBound++;
                    continue;
                }
                matrix[r--][c]=data++;
            }



            cnt++;
        }


        return matrix;
    }

}
