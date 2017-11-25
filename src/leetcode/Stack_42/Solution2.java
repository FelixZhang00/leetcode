package leetcode.Stack_42;

/**
 * Created by felix on 15/6/19.
 * https://leetcode.com/problems/trapping-rain-water/
 * 参考：http://blog.csdn.net/nokiaguy/article/details/14023225
 * 其实很简单，我的算法并不是累加的，而是用的减法。
 * 只需要找到所有墙中最高的，然后再找出第二高的。
 * 如果两堵墙紧邻者，就忽略它，
 * 否则算一下如果墙之间没有任何其他的砖的情况下可以有多少水（只是一个乘法而已），然后扫描两堵墙之间有多少块砖，减去这个砖数就可以了。
 * 最后用递归处理。将两堵墙两侧到各自的左右边界再重新进行前面的操作（递归处理）。直到无墙可处理。
 * 用递归方法很容易理解。
 *
 * AC!
 */
public class Solution2 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int end = height.length - 1;
        while (end >= 0 && height[end] == 0) {  //过滤末尾的0
            end--;
        }
        if (end<0) return 0;
        return process(0, end, height);
    }

    /**
     * @param start
     * @param end
     * @param height
     * @return 在start和end之间（不包含）能装多少水
     */
    private int process(int start, int end, int[] height) {
        int result = 0;

        //  first：start和end之间最高的墙
        //  second：start和end之间第二高的墙
        int first = 0, second = 0;

        //  firstIndex：第一高的墙在height中的索引
        //  secondIndex：第二高的墙在height中的索引
        int firstIndex = start, secondIndex = start;
        //  两堵墙必须至少有一堵墙的距离
        if (end - start <= 1)
            return 0;

        //  开始获取第一高和第二高墙的砖数
        for (int i = start; i <= end; i++) {
            if (height[i] > first) {
                second = first;
                secondIndex = firstIndex;
                first = height[i];
                firstIndex = i;
            } else if (height[i] > second) {
                second = height[i];
                secondIndex = i;
            }
        }

        //  获取左侧墙的索引
        int startIndex = Math.min(firstIndex, secondIndex);
        //  获取右侧墙的索引
        int endIndex = Math.max(firstIndex, secondIndex);

        //计算距离
        int dis = endIndex - startIndex;
        //  如果第一高的墙和第二高的墙之间至少有一堵墙，那么开始计算这两堵墙之间可以放多少个单位的水
        if (dis > 1) {
            result += (dis - 1) * second;
            //  减去这两堵墙之间的砖数
            for (int i = startIndex + 1; i < endIndex; i++) {
                result -= height[i];
            }
        }

        int leftResult = process(start, startIndex, height);
        int rightResult = process(endIndex, end, height);

        return result + leftResult + rightResult;
    }

}
