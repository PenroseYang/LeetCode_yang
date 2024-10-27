package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/21
 */
public class _LCR183_望远镜中的最高海拔 {

    public static void main(String[] args) {

    }

    public int[] maxAltitude(int[] heights, int limit) {
        if (heights == null || heights.length == 0 || limit < 1) {
            return new int[]{};
        }
        // 如果长度特别长
        if (heights.length <= limit) {
            int max = heights[0];
            for (int i = 0; i < heights.length; i++) {
                max = Math.max(max, heights[i]);
            }
            return new int[]{max};
        }

        int left = 0, right = limit - 1;
        int max = 0;
        int[] result = new int[heights.length - limit + 1];
        for (int i = left; i <= right; i++) {
            max = Math.max(max, heights[i]);
        }
        int index = 0;
        result[0] = max;
        while (right < (heights.length - 1)) {
            index++;
            right++;
            if (heights[right] > max) {
                max = heights[right];
            } else if (heights[left] == max) {
                max = heights[left + 1];
                for (int i = left + 2; i <= right; i++) {
                    max = Math.max(max, heights[i]);
                }
            }
            left++;
            result[index] = max;
        }
        return result;
    }

}