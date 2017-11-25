package leetcode.BinarySearch_154;

import java.util.Arrays;

/**
 * Created by felix on 15/4/12.
 */
public class Solution {

    /**
     * Solution1:
     * 解法和#153一样
     * 在num数组后面再拼接一个数组，这样这个新数组里一定存在原来已经排好序的数组，
     * 用一个指针i遍历整个数组，判断i到length部分长度的数组是否有序，是的话，i对应的元素就是最小指，
     * 否则，增加i.
     * <p/>
     * 测试时间太慢了，还有改进的空间
     * 时间复杂度 ~length*length
     * Runtime: 280 ms
     */
    public int findMin(int[] num) {
        int length = num.length;

        //首尾拼接num给newNum
        int[] newNum = new int[2 * length];
        for (int i = 0; i < newNum.length; i++) {
            newNum[i] = num[i % length];
        }

        for (int i = 0; i < length; i++) {
            if (isSorted(newNum, i, i + length)) {
                return newNum[i];
            }
        }
        return -1;
    }

    /**
     * 判断数组指定部分是否从小到大排序
     *
     * @param lo inclusive
     * @param hi exclusive
     * @return
     */
    private boolean isSorted(int[] array, int lo, int hi) {

        for (int i = lo + 1; i < hi; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1、 设置两个指针，初始状态第一个指针指向前面子数组的第一个元素，第二个指针指向后面子数组的最后一个元素；
     * <p/>
     * 2、 找到两个指针的中间元素；
     * <p/>
     * 3、若其大于等于第一个指针指向的元素，则说明其在前面的子数组中，且显然最小元素在中间元素的右边，
     * 若其小于等于第二个指针指向的元素，则说明其在后面的子数组中，且显然最小元素在中间元素的左边。
     *
     *
     * Runtime: 228 ms
     */
    public int findMin2(int[] num) {
        if (num.length == 1) {
            return num[0];
        }
        int lo = 0;
        int hi = num.length - 1;
        int mid = 0;
        int min=num[0];
        if (num[lo] < num[hi]) {                        //单调递增的情况
            return num[0];
        } else {                                               //有拐点的情况
            while (lo + 1 <= hi) {
                mid = (lo + hi) / 2;
                if (num[mid] > num[lo]) {         //说明mid的位置在前面的递增序列中
                    min=Math.min(num[lo],min);
                    lo = mid;
                } else if (num[mid] < num[hi]) {         //说明mid的位置在后面的递增序列中
                    min=Math.min(num[mid],min);
                    hi = mid;
                } else {
                    lo++;
                }
            }
            min=Math.min(num[lo],min);
            min=Math.min(num[hi],min);
            return min;
        }
    }


    /**
     * Runtime: 228 ms
     */
    public int findMin3(int[] num) {
        if (num.length == 1) return num[0];
        if (num.length == 2) return Math.min(num[0], num[1]);
        int mid = num.length / 2;
        if (num[0] < num[num.length - 1])
            return num[0];
        else if (num[0] == num[num.length - 1]) {
            if (num[mid] > num[0]) return findMin2(Arrays.copyOfRange(num, mid + 1, num.length));
            else if (num[mid] < num[0]) return findMin2(Arrays.copyOfRange(num, 0, mid + 1));
            else
                return Math.min(findMin2(Arrays.copyOfRange(num, mid + 1, num.length)), findMin2(Arrays.copyOfRange(num, 0, mid + 1)));
        } else {
            if (num[mid] >= num[0]) return findMin2(Arrays.copyOfRange(num, mid + 1, num.length));
            else return findMin2(Arrays.copyOfRange(num, 0, mid + 1));
        }
    }


}
