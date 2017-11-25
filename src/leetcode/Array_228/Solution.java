package leetcode.Array_228;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 15/7/23.
 * https://leetcode.com/problems/summary-ranges/
 * <p/>
 * <p/>
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 *
 *
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<String>();

        if (nums.length == 0) return res;

        int last = nums[0];
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(last);
        for (int i = 1; i < nums.length; i++) {

            if (last + 1 == nums[i]) {
                list.add(nums[i]);
            } else if (list.size() == 0) {
                list.add(last);
            } else {
                if (list.size() >= 2) {
                    res.add(list.get(0) + "->" + list.get(list.size() - 1));
                } else if (list.size() == 1) {
                    res.add(list.get(0) + "");
                }
                list = new ArrayList<Integer>();
            }
            last = nums[i];

        }


        if (list.size() >= 2) {
            res.add(list.get(0) + "->" + list.get(list.size() - 1));
        } else if (list.size() == 1) {
            res.add(list.get(0) + "");
        }

        return res;
    }

}
