package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/20
 * <p>
 * <p>
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * 13 14 15 16
 * 运行了一下发现还是ok的
 */
public class _面试29_顺时针转圈打印 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        spiralOrder(matrix);
    }

    public static void spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int allRow = matrix.length - 1, allColumn = matrix[0].length - 1;
        int leftRow = 0, leftColumn = 0;
        while (leftRow < allRow && leftColumn < allColumn) {
            spiralOrder(matrix, leftRow, leftColumn, allRow, allColumn);
            // 这里的代码，简化的话，spiralOrder(matrix, leftRow++, leftColumn++, allRow--, allColumn--);
            leftRow++;
            leftColumn++;
            allRow--;
            allColumn--;
        }
    }

    public static void spiralOrder(int[][] matrix, int leftRow, int leftColumn, int rightRow, int rightColumn) {
        if (leftRow == rightRow) {
            while (leftColumn <= rightColumn) {
                System.out.print(matrix[leftRow][leftColumn] + " ");
                leftColumn++;
            }
        } else if (leftColumn == rightColumn) {
            while (leftRow <= rightRow) {
                System.out.print(matrix[leftRow][leftColumn] + " ");
                leftRow++;
            }
        } else {
            int row = leftRow, column = leftColumn;
            // 上来先往右遍历
            while (column < rightColumn) {
                System.out.print(matrix[row][column] + " ");
                column++;
            }
            while (row < rightRow) {
                System.out.print(matrix[row][column] + " ");
                row++;
            }
            while (column > leftColumn) {
                System.out.print(matrix[row][column] + " ");
                column--;
            }
            while (row > leftRow) {
                System.out.print(matrix[row][column] + " ");
                row--;
            }
        }
    }
}