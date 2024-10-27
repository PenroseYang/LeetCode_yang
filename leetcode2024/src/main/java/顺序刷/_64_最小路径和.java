package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/23
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 */
public class _64_最小路径和 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] result = new int[grid.length][grid[0].length];

        result[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            result[i][0] += result[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            result[0][i] += result[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
            }
        }
        return result[grid.length - 1][grid[0].length - 1];
    }
}