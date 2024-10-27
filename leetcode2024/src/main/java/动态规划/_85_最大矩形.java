package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/13
 * <p>
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],
 *                ["1","0","1","1","1"],
 *                ["1","1","1","1","1"],
 *                ["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 *
 * 示例 2：
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 * 示例 3：
 * 输入：matrix = [["1"]]
 * 输出：1
 *
 * 这题估计没做出来！
 *
 */
public class _85_最大矩形 {

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int first = matrix.length;
        int second = matrix[0].length;

        int[][] dpRow = new int[first + 1][second + 1];
        int[][] dpColumn = new int[first + 1][second + 1];

        int max = 0;
        for (int i = 0; i < first; i++) {
            for (int j = 0; j < second; j++) {
                if (matrix[i][j] == '1') {
                    if (dpRow[i][j + 1] == 0 || dpRow[i + 1][j] + 1 == 0) {
                        dpRow[i + 1][j + 1] = Math.max(dpRow[i][j + 1], dpRow[i + 1][j] + 1);
                    } else {
                        dpRow[i + 1][j + 1] = Math.min(dpRow[i][j + 1], dpRow[i + 1][j] + 1);
                    }

                    if (dpColumn[i][j + 1] + 1 == 0 || 0 == dpColumn[i + 1][j]) {
                        dpColumn[i + 1][j + 1] = Math.min(dpColumn[i][j + 1] + 1, dpColumn[i + 1][j]);
                    } else {
                        dpColumn[i + 1][j + 1] = Math.max(dpColumn[i][j + 1] + 1, dpColumn[i + 1][j]);
                    }
                    max = Math.max(dpRow[i + 1][j + 1] * dpColumn[i + 1][j + 1], max);
                }
            }
        }
        return max;
    }
}