package leetcode.BinarySearch_33;

/**
 * Created by felix on 15/6/16.
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 题意：
 * 与#74题类似，利用nums数组的一些特殊属性，实现更快的查找算法。
 * <p/>
 * 思路：将旋转的数组首位拼接
 * AC! 顺便把#81也攻了。
 */
public class Solution {
    public int search(int[] nums, int target) {

        int[] aux = new int[nums.length * 2];
        int start =0;
        boolean found = false;
        //填充辅助数组，在nums数组的尾部再接一个nums
        //同时找到aux中有序的部分
        aux[0] = nums[0];
        for (int i = 1; i < aux.length; i++) {
            aux[i] = nums[i % nums.length];
            if (!found && aux[i] < aux[i - 1]) {     //更新开始位置，找到连接处位置
                start = i;
                found = true;
            }

        }

        int lo = start, hi = start + nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (aux[mid] < target) lo = mid + 1;
            else if (aux[mid] > target) hi = mid - 1;
            else return mid%nums.length;
        }

        return -1;
    }
}
