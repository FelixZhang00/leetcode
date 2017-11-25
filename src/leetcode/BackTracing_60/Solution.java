package leetcode.BackTracing_60;

import java.util.ArrayList;

/**
 * Created by felix on 15/5/11.
 * <p/>
 * Time Limit Exceeded
 * Last executed input:	9, 273815
 */
public class Solution {


    private int total = 0;      //保存找到的全排列数组合中的编号，直到total==k

    public String getPermutation(int n, int k) {
        ArrayList<String> result = new ArrayList<String>();
        dfs(n, k, 0, "", result);
        return result.get(0);
    }

    /**
     * @param n
     * @param target
     * @param currNum
     * @param s
     * @param result
     */
    private void dfs(int n, int target, int currNum, String s, ArrayList<String> result) {

        if (currNum != 0) {
            s += currNum;
        }
        if (s.length() == n) {     //找到一个完整的排列
            total++;
        }
        if (total == target) {     //如果排列的序号与目标相同，则返回
            result.add(s);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isContain(s, i)) {
                dfs(n, target, i, s, result);
            }
        }
    }

    private boolean isContain(String s, int i) {
        if ("".equals(s)) return false;
        int parseInt = Integer.parseInt(s);
        while (parseInt != 0) {
            if (parseInt % 10 == i) {
                return true;
            }
            parseInt /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String permutation = solution.getPermutation(3, 6);
        System.out.println(permutation);
    }


}
