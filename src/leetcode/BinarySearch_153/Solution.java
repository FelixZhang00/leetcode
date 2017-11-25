package leetcode.BinarySearch_153;

/**
 * Created by felix on 15/4/12.
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Solution {

    /**
     * Solution1:
     * 在num数组后面再拼接一个数组，这样这个新数组里一定存在原来已经排好序的数组，
     * 用一个指针i遍历整个数组，判断i到length部分长度的数组是否有序，是的话，i对应的元素就是最小指，
     * 否则，增加i.
     * <p/>
     * <p/>
     * 测试时间太慢了，还有改进的空间
     * 时间复杂度 ~length*length
     * Runtime: 229 ms
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
     */
    public int findMin2(int[] num) {
        if (num.length == 1) {
            return num[0];
        }
        int lo = 0;
        int hi = num.length - 1;
        int mid = 0;
        if (num[lo] < num[hi]) {                        //单调递增的情况
            return num[0];
        } else {                                               //有拐点的情况
            while (lo + 1 != hi) {
                mid = (lo + hi) / 2;
                if (num[mid] > num[lo]) {         //说明mid的位置在前面的递增序列中
                    lo = mid;
                }
                if (num[mid] < num[hi]) {         //说明mid的位置在后面的递增序列中
                    hi = mid;
                }
            }
            return num[hi];
        }
    }


    /**
     * 借鉴：
     * 不太明白
     * <p/>
     * 通过左边界和中间的大小关系来得到左边或者右边有序的信息，
     * 如果左半边有序，那么左半边最小就是左边第一个元素，可以和当前最小相比取小的，
     * 然后走向右半边。否则，那么就是右半半边第一个元素，然后走向左半边。这样子每次可以截掉一半元素，
     * <p/>
     * <p/>
     * Runtime: 216 ms
     */
    public int findMin3(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        int l = 0;
        int r = num.length - 1;
        int min = num[0];
        while (l < r - 1) {
            int m = (l + r) / 2;
            if (num[l] < num[m]) {
                min = Math.min(num[l], min);
                l = m + 1;
            } else if (num[l] > num[m]) {
                min = Math.min(num[m], min);
                r = m - 1;
            } else {
                l++;
            }
        }
        min = Math.min(num[r], min);
        min = Math.min(num[l], min);
        return min;
    }


    /**
     * 用递归
     * O（lgn）
     * <p/>
     * 太慢
     * Runtime: 258 ms
     */
    public int findMin4(int[] num) {
        return find(num, 0, num.length - 1);
    }

    private int find(int[] num, int lo, int hi) {
        if (num[lo] < num[hi]) return num[lo];
        int mid = (lo + hi) / 2;
        if (num[mid] > num[hi]) return find(num, mid + 1, hi);
        return find(num, lo, mid - 1);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = new int[]{4, 5, 6, 7, 0, 1, 2};
        int min = solution.findMin3(num);
        System.out.print(min);

//        for (int i = 0; i < num.length; i++) {
//            System.out.print(num[i]+",");
//        }
    }


}
