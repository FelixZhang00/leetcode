package leetcode.Array_88;

/**
 * Created by felix on 15/6/16.
 * https://leetcode.com/problems/merge-sorted-array/
 * <p/>
 * nums1有足够的空间，将nums2的前n个元素归并到nums1的前m个元素中
 *
 * AC!
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int aux[] = new int[m + n];

        int i = 0, j = 0;        //分别指向nums1和nums2
        for (int k = 0; k < aux.length; ) {
            if (i == m) aux[k++] = nums2[j++];
            else if (j == n) aux[k++] = nums1[i++];
            else if (nums1[i] > nums2[j]) aux[k++] = nums2[j++];
            else aux[k++] = nums1[i++];
        }

        //将辅助数组的元素转移过去
        for (int k = 0; k < aux.length; k++) {
            nums1[k] = aux[k];
        }

    }

}
