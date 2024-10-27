package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/11
 * <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 * <p>
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 */
public class _10正则表达式匹配 {

    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "a*"));
    }

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null || p.length() == 0 || s.length() == 0) {
            return false;
        }
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[i + 1][0] = dp[i - 1][0];
            }
        }
        for (int i = 0; i < p.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (p.charAt(i) == '*') {
                    // *把前一位消了
                    dp[i + 1][j + 1] = dp[i - 1][j + 1] ||
                            // 前一位只用一次，*不发挥作用
                            dp[i][j + 1] ||
                            //
                            (p.charAt(i - 1) == '.' && (dp[i][j] || dp[i + 1][j])) ||
                            (p.charAt(i - 1) == s.charAt(j) && (dp[i][j] || dp[i + 1][j]));
                } else if (p.charAt(i) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = dp[i][j] && s.charAt(j) == p.charAt(i);
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}