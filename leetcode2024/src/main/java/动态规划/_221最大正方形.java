package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/10
 */
public class _221最大正方形 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            result = Math.max(result, dp[i][0]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] - '0';
            result = Math.max(result, dp[0][i]);
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        return result * result;
    }

    public static void main(String[] args) {
        _221最大正方形 solution = new _221最大正方形();
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println(solution.maximalSquare(matrix));
    }
}
