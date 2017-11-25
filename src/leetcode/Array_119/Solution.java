package leetcode.Array_119;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 15/4/4.
 * 题目要求只用O(k)额外空间，其实分析下杨辉三角的计算方式，就知道只要O(1)的额外空间就行了。
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result=new ArrayList<Integer>();

        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(1); //先给新的一行的末尾添加1
            for (int j = i-1; j>0; j--) {
                result.set(j,result.get(j-1)+result.get(j));
            }  //因为第一个元素没有动过，所以还是1，不需要设置
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution=new Solution();
        List<Integer> row = solution.getRow(5);
        for (int i = 0; i < row.size(); i++) {
            System.out.println(row.get(i));
        }
    }
}
