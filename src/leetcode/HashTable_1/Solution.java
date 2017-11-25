package leetcode.HashTable_1;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by felix on 15/4/6.
 * <p/>
 * https://leetcode.com/problems/two-sum/
 */
public class Solution {


    /**
     * Solution1:
     * 遍历数组，先定位一个元素，再从剩余的元素中查找符合条件的
     * 超时了！
     */
//    public int[] twoSum(int[] numbers, int target) {
//        if (numbers == null || numbers.length < 2) return null;
//
//        int index1 = 0, index2 = 1;
//        for (int i = 0; i < numbers.length - 1; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                if (numbers[i] + numbers[j] == target) {
//                    index1 = i;
//                    index2 = j;
//                    break;
//                }
//            }
//        }
//        return new int[]{index1 + 1, index2 + 1};
//    }

    /**
     * Solution2:失败！
     * 先排序，再查找相反数，不过下标和原来的不一样了
     *
     */
//    public int[] twoSum(int[] numbers, int target) {
//        if (numbers == null || numbers.length < 2) return null;
//
//        int index1 = 0, index2 = 1;
//        Arrays.sort(numbers); //执行二分查找需要先排序
//        for (int i = 0; i < numbers.length - 1; i++) {
//            int key = target - numbers[i];
//            int searchedIndex = Arrays.binarySearch(numbers, i + 1, numbers.length, key);
//            if (searchedIndex >= 0) {
//                index1 = i;
//                index2 = searchedIndex;
//                break;
//            }
//        }
//
//
//        return new int[]{index1 + 1, index2 + 1};
//    }


    /**
     * Solution3:失败！
     */
//    public int[] twoSum(int[] numbers, int target) {
//        if (numbers == null || numbers.length < 2) return null;
//
//        //hashtable不允许有相同的key，所以应该选择数组的下标作为key
//        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
//
//        //①将数组中的元素存储到hash表中
//        for (int i = 0; i < numbers.length; i++) {
//            table.put(i, numbers[i]);
//        }
//
//        int index1 = 0, index2 = 1;
//        //②定位一个元素，用在hash表中查找符合条件的合伙人（相加为target的元素）
//        for (int i = 0; i < numbers.length; i++) {
//            int key = target - numbers[i];
//            table.remove(i);  //避免找到自己
//            if (table.containsValue(key)) {
//                index1 = i;
//                //发现无法找到第二个元素的下标
////                index2=table.get()
//                break;
//            } else {
//                table.put(i, numbers[i]);
//            }
//
//        }
//        return new int[]{index1 + 1, index2 + 1};
//    }

    //  Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Solution4: 测试通过 Runtime: 299 ms
     * 构造hashtable时以数组元素作为键，值为保存数组索引的Node节点，这样一个键就可以有多个值了
     *
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return null;

        // hashtable不允许有相同的key
        Hashtable<Integer, ListNode> table = new Hashtable<Integer, ListNode>();
        //①将数组中的元素存储到hash表中
        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];
            if (table.containsKey(temp)) {
                ListNode node = table.get(temp);
                node.next = new ListNode(i);
            } else {
                table.put(temp, new ListNode(i));
            }
        }

        int index1 = 0, index2 = 1;
        //②定位一个元素，用在hash表中查找符合条件的合伙人（相加为target的元素）
        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];

            ListNode node = table.get(key);
            if (key == numbers[i] && node.next != null) {  //是否需要考虑相同元素的情况，此时table中的值有两个以上node
                index1 = i;
                index2 = node.next.val;
                break;
            } else if (key == numbers[i] && node.next == null) {  //表示数组中只有一个这样的元素，没有合伙人
                continue;
            }

            if (table.containsKey(key)) {  //此时不会找到自己
                index1 = i;
                index2 = table.get(key).val;
                break;
            }


        }
        return new int[]{index1 + 1, index2 + 1};

    }

    /**
     * Solution5:改进
     * Runtime: 235 ms
     * 构造hash表和查找同时进行
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result[] = new int[2];
        for (int i = 0; i < numbers.length; i++) {

            if (map.containsKey(numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(numbers[i]) + 1;
            } else {
                int temp = target - numbers[i];
                map.put(temp, i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.twoSum2(new int[]{3, 2, 4}, 6);
//        int[] ints = solution.twoSum(new int[]{0, 4, 3, 0}, 0);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}
