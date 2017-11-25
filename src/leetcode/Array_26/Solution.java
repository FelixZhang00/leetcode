package leetcode.Array_26;

/**
 * Created by felix on 15/4/3.
 * <p/>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * <p/>
 * Given a sorted array,(假设从小到大)
 * remove the duplicates in place such that
 * each element appear only once and return the new length.
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A==null||A.length==0)return 0;
        int len = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[len] == A[i]) continue;
            A[++len] = A[i];
        }
        return ++len;
    }
}
