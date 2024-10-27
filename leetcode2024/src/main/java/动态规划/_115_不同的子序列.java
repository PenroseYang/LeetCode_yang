package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/14
 */
public class _115_不同的子序列 {
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
    public static int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    if (i == 0) {
                        dp[1][j + 1] = 1;
                    } else {
                        for (int k = 0; k < j; k++) {
                            dp[i + 1][j + 1] = dp[i + 1][j + 1] + dp[i][k + 1];
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= s.length(); i++) {
            result += dp[t.length()][i];
        }
        return result;
    }
}