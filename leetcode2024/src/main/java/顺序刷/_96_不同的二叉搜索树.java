package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/24
 * <p>
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n <= 19
 * Related Topics
 * 树
 * 二叉搜索树
 * 数学
 * 动态规划
 * 二叉树
 * <p>
 * 👍 2533
 */
public class _96_不同的二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }

    public static int numTrees(int n) {
        if (n <= 2) {
            return n;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        result[3] = 5;
        for (int i = 4; i <= n; i++) {
            int left = 0;
            int right = i - left - 1;
            int tem = 0;
            while (right >= 0) {
                tem += result[left] * result[right];
                left++;
                right--;
            }
            result[i] = tem;
        }
        return result[n];
    }

}