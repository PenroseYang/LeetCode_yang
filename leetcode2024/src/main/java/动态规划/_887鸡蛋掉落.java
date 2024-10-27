package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/13
 * <p>
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * <p>
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * <p>
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 1, n = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。
 * 如果它没碎，那么肯定能得出 f = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
 * 示例 2：
 * <p>
 * 输入：k = 2, n = 6
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：k = 3, n = 14
 * 输出：4
 * <p>
 * todo 这个题就不优化了
 */
public class _887鸡蛋掉落 {
    public static void main(String[] args) {
        System.out.println(superEggDrop(2, 6));
    }

    public static int superEggDrop(int k, int n) {
        if (k <= 0 || n <= 0) {
            return 0;
        }
        if (n <= 2 || k == 1) {
            return n;
        }
        // 第一位是有多少个楼层待尝试，第二位是还剩几个鸡蛋
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j < k + 1; j++) {
                dp[i][j] = i;
            }
        }

        // 总层高的遍历
        for (int i = 3; i < n + 1; i++) {
            // 总鸡蛋数量的遍历
            for (int j = 1; j < k + 1; j++) {
                // 每一层数量的计算
                for (int l = 1; l < i; l++) {
                    if (j == 1) {
                        dp[i][j] = i;
                    } else if (dp[i][j] == 0) {
                        dp[i][j] = Math.max(dp[l - 1][j], dp[i - l][j - 1]) + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[l - 1][j], dp[i - l][j - 1]) + 1);
                    }
                }
            }
        }
        return dp[n][k];
    }
}