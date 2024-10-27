package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/10
 * <p>
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 */
public class _32最长有效括号 {

    /**
     * todo 最长有效括号，最长最短极值的都是动态规划
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int[] left = new int[s.length() + 1];
        int[] dp = new int[s.length() + 1];
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (left[i] > 0) {
                    dp[i + 1] = 0;
                    left[i + 1] = 1;
                }
            } else {
                if (left[i] > 0) {
                    left[i + 1] = left[i] - 1;
                    dp[i + 1] = dp[i] + 1;
                    result = Math.max(result, dp[i + 1]+1);
                }
            }
        }
        return result;
    }
}