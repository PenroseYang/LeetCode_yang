package 动态规划;

import java.util.Arrays;

/**
 * @author yangzhe14
 * @since 2024/7/9
 * <p>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 * 这个题每一行都要好好梳理一遍！
 * （1）数组尽量多申请一个，别每次去做减一操作
 * （2）dp数组的第0个第1个，赋值都要好好搞
 * （3）索引和dp的value容易搞混，自己再看看！
 */
public class _322零钱兑换 {

    public static void main(String[] args) {
        int[] test = new int[]{2};
        System.out.println(coinChange(test, 3));
    }

    public static int coinChange(int[] coins, int amount) {
        if(amount <= 0){
            return -1;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }

        // 最小能凑出来的面值就这些了
        int[] dp = new int[amount + 1];
        // 赋初值
        Arrays.fill(dp, -1);
        Arrays.sort(coins);
        int minCoin = coins[0];
        if (minCoin > amount) {
            return -1;
        }
        dp[0] = 0;
        dp[minCoin] = 1;
        for (int dpAmount = minCoin + 1; dpAmount <= amount; dpAmount++) {
            for (int coin : coins) {
                int lastState = dpAmount - coin;
                if (lastState >= 0 && dp[lastState] >= 0) {
                    dp[dpAmount] = dp[dpAmount] > 0 ?
                            Math.min(dp[lastState] + 1, dp[dpAmount]) : dp[lastState] + 1;
                }
            }
        }

        return dp[amount];
    }
}