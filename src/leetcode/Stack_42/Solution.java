package leetcode.Stack_42;

import java.util.LinkedList;

/**
 * Created by felix on 15/6/16.
 * https://leetcode.com/problems/trapping-rain-water/
 * <p/>
 * 思路：见印象笔记
 * 没有做出来？！
 * 见Solution2
 */
public class Solution {
    public int trap(int[] height) {

        if (height == null || height.length == 0) return 0;

        //保存障碍物在数组中的编号。
        //并做如下规定：当新元素>=stack顶的元素时pop，并计算局部和；
        //当新元素<stack顶的元素时才push
        LinkedList<Integer> stack=new LinkedList<Integer>();

        boolean anoterPool=true;    //是否是一个与前面障碍物完全无关的池子。这个标记可以防止重复累加
        int temp = 0;                   //暂存小池子的面积
        int sum = 0;        //最后装水的面积
        if (height[0] != 0) stack.push(0);  //对第一个位置特殊考虑
        for (int i = 1; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else {            //栈顶的元素<=新加的元素，有可能装水


                int start = i, end = i;
                int local;

                while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                    start=stack.pop();
                }
                //找装水的起始位置总是在栈顶
                if (!stack.isEmpty()){
                    start=stack.getFirst();
                }

                if (stack.isEmpty()) {
                    local = height[start] * (end - start-1);
                    for (; start < end; ) {
                        local -= height[start++];
                    }
                } else {
                    local = height[end] * (end - start-1);
                    for (; start < end; ) {
                        local -= height[start++];
                    }
                }



                if (anoterPool){
                    sum+=local;
                }else{
                    sum += local-temp;
                }

                if (stack.isEmpty()){
                    anoterPool=true;
                }else {
                    anoterPool=false;
                }

                temp=local;
                stack.push(i);
            }


        }
        return sum;
    }
}
