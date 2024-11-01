package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/10
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *
 *
 * 如果涉及到0这种初始条件的话，最好把数组+1位，能解决很多的问题
 * 但是加了1位之后dp[length][length]就行了，本来是需要减一的
 */
public class _1143最长公共子序列 {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 ||
                text2 == null || text2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = Math.max(Math.max(dp[i][j + 1], dp[i + 1][j]), dp[i][j] + 1);
                } else {
                    dp[i + 1][j + 1] = Math.max(Math.max(dp[i][j + 1], dp[i + 1][j]), dp[i][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}