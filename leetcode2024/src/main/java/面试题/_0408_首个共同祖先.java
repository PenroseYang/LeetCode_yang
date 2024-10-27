package 面试题;

import 二叉树.TreeNode;

/**
 * @author yangzhe14
 * @since 2024/9/22
 */
public class _0408_首个共同祖先 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        root.left = left;
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode treeNode = lowestCommonAncestor(root, left, root);
        System.out.println(treeNode);
    }


    public static TreeNode resultNode = null;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int dfs = dfs(root, p, q);
        return resultNode;
    }

    public static int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || resultNode != null) {
            return 0;
        }

        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        int result = 0;
        if (root == p || root == q) {
            result++;
        }
        result += left + right;
        if (result >= 2) {
            resultNode = root;
        }
        return result;
    }
}