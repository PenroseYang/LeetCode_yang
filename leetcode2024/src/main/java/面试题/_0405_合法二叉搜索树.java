package 面试题;

import 二叉树.TreeNode;

import java.util.Stack;

/**
 * @author yangzhe14
 * @since 2024/9/22
 */
public class _0405_合法二叉搜索树 {

    public static Integer pre = null;

    public static boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return recurse(root);
    }

    public static boolean recurse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre == null) {
                pre = root.val;
            } else {
                if (pre < root.val) {
                    pre = root.val;
                } else {
                    return false;
                }
            }
            root = root.right;
        }
        return true;
    }
}