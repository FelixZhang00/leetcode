package NPU_2015.小女警的异世界之战;

/**
 * Created by felix on 15/5/16.
 * <p/>
 * 测试后序遍历
 */
public class TestTreeTr {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] perTr = {3, 1, 0, 2, 4};
        Solution.Node root = null;

        root = Solution.performTree(root, 0, 4, perTr);
        printTreeAfterTr(root);
    }


    /**
     * 后续打印节点
     *
     * @param node
     */
    private static void printTreeAfterTr(Solution.Node node) {
        if (node == null) return;
        printTreeAfterTr(node.left);
        printTreeAfterTr(node.right);
        System.out.println(node.val);
    }
}
