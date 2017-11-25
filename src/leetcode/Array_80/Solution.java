package leetcode.Array_80;

/**
 * Created by felix on 15/6/22.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * <p/>
 * 题意：是#26的进阶题，不同之处在于最多重复两次
 * AC!
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = 0;
        int cnt = 1;  //累计重复的次数
        for (int i = 1; i < nums.length; i++) {
            if (nums[len] == nums[i] && cnt < 2) {
                cnt++;
                nums[++len] = nums[i];
            } else if (nums[len] == nums[i]) {
                continue;
            } else {
                cnt = 1;      //恢复初始化
                nums[++len] = nums[i];
            }
        }
        return ++len;
    }
}
