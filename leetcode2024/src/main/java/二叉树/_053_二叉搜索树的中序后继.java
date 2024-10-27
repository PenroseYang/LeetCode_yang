package 二叉树;

import java.util.Stack;

/**
 * @author yangzhe14
 * @since 2024/9/21
 */
public class _053_二叉搜索树的中序后继 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = root;
        boolean next = false;
        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            head = stack.pop();
            if (next) {
                return head;
            }
            if (head == p) {
                next = true;
            }
            head = head.right;
        }
        return null;
    }
}