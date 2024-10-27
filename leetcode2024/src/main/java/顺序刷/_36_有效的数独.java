package 顺序刷;

import java.util.HashMap;

/**
 * @author yangzhe14
 * @since 2024/8/21
 * <p>
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。      规则：每个字符一行一次，每个字符一列一次，每个字符 3*3 一次
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * [["8","3",".",".","7",".",".",".","."] ,
 * ["6",".",".","1","9","5",".",".","."] ,
 * [".","9","8",".",".",".",".","6","."] ,
 * <p>
 * <p>
 * 这题其实不怎么考察省空间，考察的就是你遍历这个数组的时候，不要越界
 */
public class _36_有效的数独 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        // 入参校验
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        // 每行的校验
        for (int i = 0; i < 9; i++) {
            HashMap<Character, Boolean> hashMap = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (hashMap.containsKey(board[i][j])) {
                    return false;
                }
                hashMap.put(board[i][j], true);
            }
        }

        // 每列的校验
        for (int i = 0; i < 9; i++) {
            HashMap<Character, Boolean> hashMap = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (hashMap.containsKey(board[j][i])) {
                    return false;
                }
                hashMap.put(board[j][i], true);
            }
        }
        // 3*3的矩阵的校验
        // 0-8，要遍历的范围是0-6，外层的两大块
        for (int i = 0; i <= 6; i = i + 3) {
            for (int j = 0; j <= 6; j = j + 3) {

                HashMap<Character, Boolean> hashMap = new HashMap<>();
                // 内层的9个数据的小循环
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i + k][j + l] == '.') {
                            continue;
                        }

                        if (hashMap.containsKey(board[i + k][j + l])) {
                            return false;
                        }
                        hashMap.put(board[i + k][j + l], true);
                    }
                }
            }
        }
        return true;
    }
}