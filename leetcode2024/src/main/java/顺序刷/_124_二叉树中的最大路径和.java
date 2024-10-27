package 顺序刷;

import 二叉树.TreeNode;
import 二叉树._124二叉树中的最大路径和;

/**
 * @author yangzhe14
 * @since 2024/8/24
 * <p>
 * <p>
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * 提示：
 * <p>
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 * Related Topics
 * 树
 * 深度优先搜索
 * 动态规划
 * 二叉树
 * <p>
 * todo 这里是包含负数的，不过至少要取到一个节点上
 * 如果
 */
public class _124_二叉树中的最大路径和 {

    public static void main(String[] args) {
        // 构建二叉树
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        maxPathSum(root);
        System.out.println(result);
    }

    public static int result = Integer.MIN_VALUE;

    // 看起来使用一个全局变量之后这里就简单
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        result = Math.max(root.val + Math.max(left, 0) + Math.max(right, 0), result);
        return root.val + Math.max(0, Math.max(left, right));
    }
}