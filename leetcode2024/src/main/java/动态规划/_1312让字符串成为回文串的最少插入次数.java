package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/17
 * <p>
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 * <p>
 * 请你返回让 s 成为回文串的 最少操作次数 。
 * <p>
 * 「回文串」是正读和反读都相同的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 * 示例 2：
 * <p>
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 * 示例 3：
 * <p>
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 中所有字符都是小写字母。
 */
public class _1312让字符串成为回文串的最少插入次数 {

    public static void main(String[] args) {
        _1312让字符串成为回文串的最少插入次数 test = new _1312让字符串成为回文串的最少插入次数();
        System.out.println(test.minInsertions("fomyxevyghcgdouxvio"));
    }

    public int minInsertions(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        if (s.length() == 2) {
            return s.charAt(0) != s.charAt(1) ? 1 : 0;
        }
        // dp数组含义是从i到j的回文子序列长度
        int[][] dp = new int[s.length()][s.length()];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            dp[i - 1][i] = s.charAt(i - 1) == s.charAt(i) ? 2 : 1;
            max = Math.max(max, dp[i - 1][i]);
        }
        // 开始回文遍历
        for (int i = 2; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                // 从j到i的回文序列
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                } else {
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                }
                max = Math.max(dp[j][i], max);
            }
        }
        return s.length() - max;
    }
}