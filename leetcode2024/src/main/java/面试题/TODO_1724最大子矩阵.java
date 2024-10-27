package 面试题;

/**
 * @author yangzhe14
 * @since 2024/9/21
 */
public class TODO_1724最大子矩阵 {

    public int[] getMaxMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int[][] tem = new int[matrix.length][matrix[0].length];
        tem[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            tem[i][0] += tem[i - 1][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            tem[0][i] += tem[0][i - 1];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                tem[i][j] = tem[i - 1][j] + tem[i][j - 1] - tem[i - 1][j - 1];
            }
        }
        // todo 这是个前缀和，好像还没仔细学过前缀和呢！再看看吧
        return new int[]{};
    }
}