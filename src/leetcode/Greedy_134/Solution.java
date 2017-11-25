package leetcode.Greedy_134;

/**
 * Created by felix on 15/5/30.
 * https://leetcode.com/problems/gas-station/
 * 像一道图论题,简化了，是一个按自然数顺序排列的圆环
 * Time Limit Exceeded
 * 答案正确，但是超时了。
 *
 * 此解法的缺陷：如果没有找到可达的路，就需要重新走一遍整个圆环，
 * 时间复杂度为O(N^2)
 * 最好可以遍历一次就能得出答案，见Solution2
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++) {
            if (dfs(gas, i, cost,0, 0)){
                return i;
            }
        }
        return -1;
    }

    /**
     * @param index 当前的位置
     * @param d 当前遍历的深度
     * @param curr 当前的油量
     */
    private boolean dfs(int[] gas, int index, int[] cost, int d, int curr) {
        if (d==gas.length) return true;
        curr += gas[index];
        if (curr - cost[index] < 0) return false;

        int nextIndex = (index + 1) % (gas.length);
        return dfs(gas, nextIndex, cost,d+1, curr-cost[index]);

    }


}
