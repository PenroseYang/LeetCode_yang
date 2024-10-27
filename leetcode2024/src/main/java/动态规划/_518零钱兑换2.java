package 动态规划;

import java.util.Arrays;

/**
 * @author yangzhe14
 * @since 2024/7/9
 * <p>
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * <p>
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 假设每一种面额的硬币有无限个。
 * <p>
 * 题目数据保证结果符合 32 位带符号整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2：
 * <p>
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * 示例 3：
 * <p>
 * 输入：amount = 10, coins = [10]
 * 输出：1
 * 提示：
 * <p>
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * coins 中的所有值 互不相同
 * 0 <= amount <= 5000
 * <p>
 * <p>
 * 这个问题比较有趣，因为取得是最大的组合数量，组合类问题
 * 这里是组合，所以需要谨慎使用硬币，把硬币作为外层循环，组合类的问题需要确保硬币只能使用一次
 */
public class _518零钱兑换2 {
    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 5};
        System.out.println(change(5, test));
    }

    public static int change(int amount, int[] coins) {
        if (amount <= 0 || coins == null || coins.length == 0) {
            return 1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        Arrays.sort(coins);
        for (int coin : coins) {
            for (int target = coin; target < dp.length; target++) {
                dp[target] += dp[target - coin];
            }
        }
        return dp[amount];
    }
}