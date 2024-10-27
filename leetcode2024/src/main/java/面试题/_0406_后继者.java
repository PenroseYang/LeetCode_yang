package 面试题;

import 二叉树.TreeNode;

import java.util.Stack;

/**
 * @author yangzhe14
 * @since 2024/9/22
 */
public class _0406_后继者 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        boolean foundPre = false;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (foundPre) {
                return root;
            } else {
                if (root == p) {
                    foundPre = true;
                }
            }
            root = root.right;
        }
        return null;
    }
}