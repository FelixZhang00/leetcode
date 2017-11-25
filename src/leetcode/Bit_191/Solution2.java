package leetcode.Bit_191;

/**
 * Created by felix on 15/5/30.
 * https://leetcode.com/problems/number-of-1-bits/
 * <p/>
 * 按位与，拿到所有1。
 */
public class Solution2 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i<32; i++){    //0~31共32位
            if(getBit(n, i)){
                count++;
            }
        }
        return count;
    }

    public boolean getBit(int n, int i){
        return (n & (1 << i)) != 0;
    }

}
