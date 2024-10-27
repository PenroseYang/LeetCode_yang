package 二叉树;

/**
 * @author yangzhe14
 * @since 2024/7/28
 */
public class _124二叉树中的最大路径和 {

    public int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // 构建二叉树
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // 测试用例的二叉树已构建完成，可以在这里进行其他操作
        _124二叉树中的最大路径和 二叉树中的最大路径和 = new _124二叉树中的最大路径和();
        System.out.println(二叉树中的最大路径和.maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxSinglePath(root);
        return result;
    }

    public int maxSinglePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxSinglePath(root.left);
        int right = maxSinglePath(root.right);
        int max = Math.max(left, right);
        if (root.val < 0) {
            if ((root.val + Math.min(left, right)) > 0) {
                result = Math.max(result, root.val + left + right);
            } else {
                result = Math.max(result, max);
            }
        } else {
            if (Math.min(left, right) > 0) {
                result = Math.max(result, root.val + left + right);
            } else {
                result = Math.max(result, max + root.val);
            }
        }
        return max + root.val;
    }
}