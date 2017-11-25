package leetcode.Greedy_134;

/**
 * Created by felix on 15/5/30.
 * 参考：
 * Accepted！
 * * Runtime: 396 ms
 * <p/>
 * 用两个变量存+= gas[i] - cost[i]。
 * 一个帮助判断当前这个点作为gas station的起点合不合适，一个帮助判断总的需求是不是大于供给。
 * 如果总的需求大于供给那么肯定是无解的，如果需求小于等于供给，就可以返回刚才找到的起始点
 */
public class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length)
            return -1;
        int sum=0;
        int total=0;
        int index=0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total+=gas[i]-cost[i];
            if (sum<0){
                sum=0;
                index=i+1;
            }
        }

        if (total<0)return -1;
        else return index;
    }
}
