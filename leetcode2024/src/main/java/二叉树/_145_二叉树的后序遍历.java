package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yangzhe14
 * @since 2024/9/21
 */
public class _145_二叉树的后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode head = root;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pre = null;
        while (head != null || !stack.isEmpty()) {
            // 左边有先遍历左边的
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            head = stack.pop();
            if (head.right == null || head.right == pre) {
                result.add(head.val);
                pre = head;

                // 弹出栈只能有一个地方弹出去
                head = null;
            } else {
                stack.push(head);
                head = head.right;
            }
        }
        return result;
    }
}