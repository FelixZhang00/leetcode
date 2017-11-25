package leetcode.Array_189;

/**
 * Created by felix on 15/4/3.
 * Question:
 * https://leetcode.com/problems/rotate-array/
 */
public class Solution {

    public void rotate(int[] nums, int k) {
        int length = nums.length;

        //考虑k>=length的情况
        k=k%length;

        if (k==0||length==1)return;

        reverse(nums,0,length-1-k);
        reverse(nums,length-k,length-1);
        reverse(nums,0,length-1);
    }

    //从数组的start到end位置之间的部分翻转
    public void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;
        }
    }

}
