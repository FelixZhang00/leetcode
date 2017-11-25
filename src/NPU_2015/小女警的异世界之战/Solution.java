package NPU_2015.小女警的异世界之战;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by felix on 15/5/16.
 * <p/>
 * 给出中序和先序，找后序
 */
public class Solution {

    public static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Map<String, Integer> map = new HashMap<String, Integer>(); //怪物词典:名字--序号
        String[] masters = new String[N];             //怪物词典:序号--名字

        String mon = null;
        int[] monsters1 = new int[N];       //中序
        for (int i = 0; i < N; i++) {
            mon = scanner.next();

            map.put(mon, i);
            masters[i] = mon;
            monsters1[i] = i;
        }

        int[] monsters2 = new int[N];       //先序
        for (int i = 0; i < N; i++) {
            monsters2[i] = map.get(scanner.next());
        }

//        //打印
//        for (int i = 0; i < N; i++) {
//            System.out.print(monsters1[i]);
//        }
//        System.out.println();
//        for (int i = 0; i < N; i++) {
//            System.out.print(monsters2[i]);
//        }

        int[] masters3 = new int[N];      //存储后序

//
        //由已知的先序和中序，构造一棵唯一的二叉树
        Node root = null;
        root = performTree(root, 0, N - 1, monsters2);

//        printTreeAfterTr(root);

        idx = 0;
        //输出后序的怪物名
        printMonsters(root, masters);

    }

    private static void printMonsters(Node node, String[] masters) {
        if (node == null) return;
        printMonsters(node.left, masters);
        printMonsters(node.right, masters);
        if (idx++ < masters.length - 1) {
            System.out.print(masters[node.val] + " ");
        } else {
            System.out.print(masters[node.val]);
        }
    }

    public static int idx = 0; //先序遍历中当前元素的编号

    /**
     * @param node  当前节点
     * @param start 中序的启示位置
     * @param end   中序的结束位置
     * @param perTr 先序序号
     * @return
     */
    public static Node performTree(Node node, int start, int end, int[] perTr) {
        int temp = perTr[idx++];
        if (node == null) {
            node = new Node(temp);
        }
        if (start >= end) return node;

        node.left = performTree(node.left, start, temp - 1, perTr);
        node.right = performTree(node.right, temp + 1, end, perTr);
        return node;
    }


    /**
     * 后续打印节点
     *
     * @param node
     */
    private static void printTreeAfterTr(Node node) {
        if (node == null) return;
        printTreeAfterTr(node.left);
        printTreeAfterTr(node.right);
        System.out.println(node.val);
    }

}
