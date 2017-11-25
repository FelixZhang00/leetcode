package leetcode.BackTracing_60;

import java.util.HashMap;

/**
 * Created by felix on 15/5/11.
 *
 * 正确性没问题，
 * 但发布到网上测试（2，2）结果是“hello”
 */
public class Solution2 {

    private int total = 0;      //保存找到的全排列数组合中的编号，直到total==k

    public String getPermutation(int n, int k) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        StringBuilder sb = new StringBuilder();
        return dfs(n, k, 0, sb, map);
    }

    private String dfs(int n, int target, int currNum, StringBuilder sb, HashMap<Integer, Boolean> map) {
        if (currNum != 0) {
            sb.append(currNum);
        }
        if (sb.length() == n) {     //找到一个完整的排列
            total++;
        }
        if (total == target) {     //如果排列的序号与目标相同，则返回
            return sb.toString();
        }

        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {      //每一遍找全排列数不能有重复的数字
                map.put(i, true);
             return   dfs(n, target, i, sb,map);
            }
        }

        return "hello";     //一般不会运行到这里
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String permutation = solution.getPermutation(3, 3);
        System.out.println(permutation);
    }
}
