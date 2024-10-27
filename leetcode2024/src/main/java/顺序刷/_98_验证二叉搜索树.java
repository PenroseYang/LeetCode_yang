package 顺序刷;

import 二叉树.TreeNode;

/**
 * @author yangzhe14
 * @since 2024/8/24
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 */
public class _98_验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Context context = doIsValid(root);
        return context.isValid;
    }


    public Context doIsValid(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Context(root.val, root.val, true);
        } else if (root.left == null && root.right != null) {
            Context rightContext = doIsValid(root.right);
            rightContext.isValid = rightContext.isValid && root.val < rightContext.min;
            if (rightContext.isValid) {
                rightContext.min = root.val;
            }
            return rightContext;
        } else if (root.left != null && root.right == null) {
            Context leftContext = doIsValid(root.left);
            leftContext.isValid = leftContext.isValid && root.val > leftContext.max;
            if (leftContext.isValid) {
                leftContext.max = root.val;
            }
            return leftContext;
        } else {
            Context leftContext = doIsValid(root.left);
            Context rightContext = doIsValid(root.right);
            boolean valid = leftContext.isValid && rightContext.isValid && root.val > leftContext.max && root.val < rightContext.min;
            if (valid) {
                return new Context(leftContext.min, rightContext.max, true);
            } else {
                return new Context(leftContext.min, rightContext.max, false);
            }
        }
    }

    public class Context {
        public int min;
        public int max;
        public boolean isValid;

        public Context(int min, int max, boolean isValid) {
            this.min = min;
            this.max = max;
            this.isValid = isValid;
        }
    }
}