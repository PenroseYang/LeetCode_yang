package 顺序刷;

import java.util.Stack;

/**
 * @author yangzhe14
 * @since 2024/8/24
 * <p>
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：matrix = [["1"]]
 * 输出：1
 * 提示：
 * <p>
 * rows == matrix.length
 * cols == matrix[0].length
 * 1 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 * <p>
 * <p>
 * todo 这是个好题啊，最大矩形面积，都是单调栈的题目
 * 每一根柱子，找到的状态是这根柱子能完全用上去，不能半截；
 * 如果要完全用上去，那就得左边找找右边找找，左边找比自己更矮的，右边找比自己更矮的
 * fixme 单调栈学岔劈了，怪不得写的东西很奇怪啊！！！！fuck！
 */
public class _85_最大矩形 {

    public static void main(String[] args) {
        char[][] test = new char[][]{
                {'1', '0'}
        };
        System.out.println(maximalRectangle(test));
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[] dp = new int[matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[j]++;
                } else {
                    dp[j] = 0;
                }
            }
            result = Math.max(result, calculateMax(dp));
        }
        return result;
    }

    private static int calculateMax(int[] dp) {
        // stack里存的是位置
        Stack<Integer> stack = new Stack<>();
        int[] right = new int[dp.length];
        int[] left = new int[dp.length];
        int result = 0;

        // 构建nextSmall，找右边比当前小的
        for (int i = dp.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && dp[stack.peek()] >= dp[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = dp.length;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        stack = new Stack<>();
        // 构建nextSmall，左边维度的
        for (int i = 0; i < dp.length; i++) {
            while (!stack.isEmpty() && dp[stack.peek()] >= dp[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i] * (right[i] - left[i] - 1));
        }
        return result;
    }
}