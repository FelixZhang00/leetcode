package leetcode.DivideAndConquer_4;

/**
 * Created by felix on 15/5/20.
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 题意：找两个数组的中位数
 * 暴力解法
 * Runtime: 596 ms
 * 参考：
 * http://blog.csdn.net/zxzxy1988/article/details/8587244
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return mergeAndReturnMedian(nums1, nums2);
    }

    private double mergeAndReturnMedian(int[] nums1, int[] nums2) {
        int num1_len = nums1.length;
        int num2_len = nums2.length;
        int length = num1_len + num2_len;
        int[] aux = new int[length];

        int i = 0, j = 0;
        for (int k = 0; k < length; k++) {
            if (i == num1_len) aux[k] = nums2[j++];
            else if (j == num2_len) aux[k] = nums1[i++];
            else if (less(nums1[i], nums2[j])) aux[k] = nums1[i++];
            else aux[k] = nums2[j++];
        }

        if (length % 2 == 1) {   //是奇数，直接返回中间的数
            return aux[length / 2];
        } else {
            return (aux[length / 2] + aux[length / 2 - 1]) / 2.0;
        }
    }

    public boolean less(int a, int b) {
        return a < b;
    }

}
