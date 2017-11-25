package leetcode.Sort_75;

import java.util.Arrays;

/**
 * Created by felix on 15/5/28.
 * https://leetcode.com/problems/sort-colors/
 * Accepted!
 */
public class Solution {

    //方法1：调用系统的排序函数
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    /**
     * ********************************************************************************
     */


    //ACCEPTED!
    //方法2：遍历一遍数组，记录下0、1、2的个数，再重写覆盖数组
    public void sortColors2(int[] nums) {
        int ctn0 = 0, ctn1 = 0, ctn2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur=nums[i];
            if (cur== 0) ctn0++;
            else if (cur == 1) ctn1++;
            else if (cur == 2) ctn2++;
        }

//        Arrays.fill(nums, 0, ctn0, 0);
//        Arrays.fill(nums, ctn0, ctn0 + ctn1, 1);
//        Arrays.fill(nums, ctn0+ctn1, ctn0+ctn1+ctn2, 2);

        for (int i = 0; i < ctn0; i++) {
            nums[i]=0;
        }

        for (int i = ctn0; i < ctn0+ctn1; i++) {
            nums[i]=1;
        }

        for (int i = ctn0+ctn1; i < ctn0+ctn1+ctn2; i++) {
            nums[i]=0;
        }
    }


}
