package 顺序刷;

import java.util.Stack;

/**
 * @author yangzhe14
 * @since 2024/8/24
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * <p>
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 * <p>
 * 提示：
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 */
public class _84_柱状图中的最大矩形 {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 4}));
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        // 每一根柱子都要找左边比自己低的第一根，以及右边比自己低的第一根
        // 先从右边开始找
        Stack<Integer> stack = new Stack<>();
        int[] right = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.empty()) {
                right[i] = heights.length;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        stack = new Stack<>();
        int[] left = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.empty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
        }
        return result;
    }
}