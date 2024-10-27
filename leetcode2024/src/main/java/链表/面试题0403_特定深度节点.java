package 链表;

import 二叉树.TreeNode;
import 顺序刷.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yangzhe14
 * @since 2024/10/8
 */
public class 面试题0403_特定深度节点 {

    /**
     * 将数组转换为二叉树。
     *
     * @param arr 输入的数组
     * @return 二叉树的根节点
     */
    public static TreeNode arrayToBinaryTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        return createNode(arr, 0);
    }

    /**
     * 递归创建节点。
     *
     * @param arr   输入的数组
     * @param index 当前节点的索引
     * @return 当前节点
     */
    private static TreeNode createNode(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        TreeNode node = new TreeNode(arr[index]);
        node.left = createNode(arr, 2 * index + 1);
        node.right = createNode(arr, 2 * index + 2);
        return node;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, null, 7, 8};
        TreeNode root = arrayToBinaryTree(arr);
        // 这里可以添加代码来验证树的结构，例如通过层序遍历打印树的结构

        ListNode[] listNodes = listOfDepth(root);
        System.out.println(listNodes);
    }

    public static ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[]{};
        }

        List<ListNode> result = new ArrayList<>();

        /**
         * todo 广度遍历都不会了呀！！！fuck！！！
         * 广度遍历用的是Queue，不是Stack！天哪！
         */
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(tree);
        while (!stack.isEmpty()) {
            int size = stack.size();
            ListNode pre = new ListNode(0);
            ListNode head = pre;
            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.poll();
                if (pop.left != null) {
                    stack.add(pop.left);
                }
                if (pop.right != null) {
                    stack.add(pop.right);
                }
                ListNode popNode = new ListNode(pop.val);
                pre.next = popNode;
                pre = popNode;
            }
            result.add(head.next);
        }

        return transformToArray(result);
    }

    private static ListNode[] transformToArray(List<ListNode> result) {
        if (result.size() == 0) {
            return new ListNode[]{};
        }

        ListNode[] resultArray = new ListNode[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}