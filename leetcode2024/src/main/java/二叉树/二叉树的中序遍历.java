package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yangzhe14
 * @since 2024/7/27
 */
public class 二叉树的中序遍历 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;
        System.out.println(inorderTraversal(t1));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        Stack stack = new Stack();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return null;
    }
}