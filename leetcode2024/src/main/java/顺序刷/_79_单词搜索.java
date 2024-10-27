package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/24
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 */
public class _79_单词搜索 {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || board.length * board[0].length < word.length()) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                StringBuilder stringBuilder = new StringBuilder();
                boolean[][] used = new boolean[board.length][board[0].length];
                boolean search = searchString(board, word, stringBuilder, used, i, j);
                if (search) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchString(char[][] board, String word, StringBuilder stringBuilder, boolean[][] used, int row, int column) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || used[row][column]) {
            return false;
        }

        if (stringBuilder.length() == word.length()) {
            return true;
        }

        // 匹配上了
        if (stringBuilder.length() < word.length() && word.charAt(stringBuilder.length()) == board[row][column]) {
            used[row][column] = true;
            stringBuilder.append(board[row][column]);
            if (stringBuilder.length() == word.length()) {
                return true;
            } else {
                // 没拼凑满
                boolean b1 = searchString(board, word, stringBuilder, used, row - 1, column);
                boolean b2 = searchString(board, word, stringBuilder, used, row, column - 1);
                boolean b3 = searchString(board, word, stringBuilder, used, row + 1, column);
                boolean b4 = searchString(board, word, stringBuilder, used, row, column + 1);
                if (b1 || b2 || b3 || b4) {
                    return true;
                }
            }
            // 退出去之前恢复原状
            used[row][column] = false;
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        }
        return false;
    }
}