package leetcode.Array_189;

/**
 * Created by felix on 15/4/3.
 */
public class Brute {

    public void rotate(int[] nums, int k) {
        int n = nums.length - 1;  //比如输入[1,2,3,4,5,6,7] 3
        for (int i = 0; i < k; i++) {
            reverse(nums, 0, n - 1);   //第一组第一次旋转后数组变为[6,5,4,3,2,1,7]
            reverse(nums, 0, n);       //第一组第二次旋转后数组变为[7,6,5,4,3,2,1]
        }                              //第一组旋转结束后，成功将1移到了右边，将7移到了左边
    }

    //从数组的start到end位置之间的部分翻转
    public void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;
        }
    }

    public static void main(String[] args) {

    }
}
