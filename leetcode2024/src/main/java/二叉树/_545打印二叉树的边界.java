package 二叉树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangzhe14
 * @since 2024/7/28
 */
public class _545打印二叉树的边界 {
    public static void main(String[] args) {
        // 创建节点
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        // 构建树
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node7;
        node5.right = node8;
        node3.left = node6;
        node6.left = node9;
        node6.right = node10;

        // 根节点是node1
        TreeNode root = node1;
        printBorder(root);

    }


    public static Map<Integer, Integer> treeHighToValueLeftMap = new HashMap<>();
    public static Map<Integer, Integer> treeHighToValueRightMap = new HashMap<>();
    public static List<Integer> leafNode = new ArrayList<>();
    public static int highest = 0;

    public static void printBorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.println(root.val);
        }
        traverse(root, 1);
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= highest; i++) {
            result.add(treeHighToValueLeftMap.get(i));
        }
        for (Integer leaf : leafNode) {
            result.add(leaf);
        }
        for (int i = highest; i > 1; i--) {
            Integer rightValue = treeHighToValueRightMap.get(i);
            if (rightValue != null) {
                result.add(rightValue);
            }
        }
        System.out.println(result);
    }

    public static void traverse(TreeNode root, int high) {
        if (root == null) {
            return;
        }
        highest = Math.max(high, highest);
        if (treeHighToValueLeftMap.get(high) == null) {
            treeHighToValueLeftMap.put(high, root.val);
        } else {
            if (root.left == null && root.right == null) {
                leafNode.add(root.val);
                treeHighToValueRightMap.put(high, null);
            } else {
                treeHighToValueRightMap.put(high, root.val);
            }
        }
        traverse(root.left, high + 1);
        traverse(root.right, high + 1);
    }
}