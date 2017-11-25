package leetcode.DivideAndConquer_169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by felix on 15/4/13.
 * https://leetcode.com/problems/majority-element/
 */
public class Solution {

    /**
     * Solution1:
     * 暴力解法
     * 循环遍历数组中的每个元素，每次都去table中查找键，如果存在该元素就将其值加1，如果不在，就添加此键，
     * 在遍历的过程中还要当前键对应的值是否超过阈值。
     * Runtime: O(n), Space: O(n)
     * — Hash table: Maintain a hash table of the counts of each element, then find the most common one.
     * <p/>
     * <p/>
     * 太慢了
     * Runtime: 372 ms
     */
    public int majorityElement(int[] num) {
        int top = num.length / 2;  //要找的最多元素的数量必须超过此数值
        // Arrays.sort(num);  //按从小到大排序
        Map<Integer, Integer> table = new HashMap<Integer, Integer>(); //数组中每个元素对应出现的次数
        int temp = 0, result = 0;
        for (int i = 0; i < num.length; i++) {
            temp = num[i];
            if (table.containsKey(temp)) {
                table.put(temp, table.get(temp) + 1);
            } else {
                table.put(temp, 1);
            }
            if (table.get(temp) > top) {
                result = temp;
                break;
            }
        }

        return result;
    }

    /**
     * Solution2:
     * 先排序，这样中间那个元素一定是超过一半的那个元素
     * Runtime: O(n log n) — Sorting
     * Runtime: 310 ms
     * 还是太慢
     */
    public int majorityElement2(int[] num) {
        Arrays.sort(num);  //按从小到大排序
        return num[num.length / 2];
    }

    /**
     * Solution3：
     * Runtime: O(n log n) — Divide and conquer
     * Runtime: 293 ms
     * <p/>
     * 类似于所有分治算法，对原数组先分为两部分，分别查找两个子数组的Majority Element，得到A和B两个元素，
     * 若A == B则说明该元素就是Majority Element，否则对A和B分别进行判断是否为Majority Element。
     * 时间复杂度为T(n)=T(n/2)+2n=O(nlogn)。
     */
    public int majorityElement3(int[] num) {
        return majorityElementSelf3(num, 0, num.length - 1);
    }

    private int majorityElementSelf3(int[] num, int lo, int hi) {
        if (lo >= hi) return num[hi];
        int mid = (lo + hi) / 2;
        int candi_A = majorityElementSelf3(num, lo, mid);
        int candi_B = majorityElementSelf3(num, mid + 1, hi);
        if (candi_A == candi_B) return candi_A;
        else {
            int cnt_A = 0, cnt_B = 0;
            for (int i = lo; i <= hi; i++) {
                if (num[i] == candi_A) cnt_A++;
                else if (num[i] == candi_B) cnt_B++;
            }
            if (cnt_A > cnt_B) return candi_A;
            else return candi_B;

        }
    }



    /**
     * Solution5:
     * 充分利用majority的定义（出现次数大于一半）
     * Runtime: O(n)
     * Runtime: 283 ms
     * <p/>
     * 用c运行这段程序：
     * Runtime: 11 ms
     */
    public int majorityElement5(int[] num) {
        int cnt = 0, res = num[0];
        for (int i = 0; i < num.length; i++) {
            if (cnt == 0) res = num[i];
            if (res == num[i]) cnt++;
            else cnt--;
        }

        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = new int[]{3, 3, 3, 4, 1,
                1, 3};
        solution.majorityElement(num);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + ",");
        }
    }
}
