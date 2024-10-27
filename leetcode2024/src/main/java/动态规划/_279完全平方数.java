package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/9
 * <p>
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * 提示：
 * <p>
 * 1 <= n <= 104
 */
public class _279完全平方数 {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        if (n <= 1) {
            return n;
        }
        int square = 1;
        int[] dp = new int[n + 1];
        // 默认都是1构成的
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j * j <= i; j++) {
                square = j * j;
                dp[i] = Math.min(dp[i - square] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}