package leetcode.Bit_137;

/**
 * Created by felix on 15/6/12.
 * https://leetcode.com/problems/single-number-ii/
 * <p/>
 * 思路2：使用位操作
 * 参考:
 * 计算机是怎么存储数字的。考虑全部用二进制表示，如果我们把 第 ith  个位置上所有数字的和对3取余，
 * 那么只会有两个结果 0 或 1 (根据题意，3个0或3个1相加余数都为0).  因此取余的结果就是那个 “Single Number”.
 * <p/>
 * AC!
 * 344 ms
 */
public class Solution2 {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int count[] = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < n; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    count[i]++;
                }
            }
            result |= ((count[i] % 3) << i);
        }
        return result;
    }
}
