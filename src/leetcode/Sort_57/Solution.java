package leetcode.Sort_57;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by felix on 15/5/30.
 * https://leetcode.com/problems/insert-interval/
 * 参考第56题的解法
 * Accepted!
 * Runtime: 440 ms`
 */
public class Solution {

    //      Definition for an interval
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static final Comparator<Interval> BY_START = new ByStart();

    private static class ByStart implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();

        intervals.add(newInterval);
        //按Interval的start对intervals排序
        Collections.sort(intervals, BY_START);

        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval temp = intervals.get(i);
            if (canMerge(last, temp)) {
                if (last.end <= temp.end) {
                    last = new Interval(last.start, temp.end);
                }
                //另外一种情况last保持不变
            } else {
                result.add(last);
                last = intervals.get(i);
            }

        }
        result.add(last);
        return result;


    }

    private boolean canMerge(Interval item1, Interval item2) {
        if (item1.end >= item2.start) {
            return true;
        }
        return false;
    }
}
