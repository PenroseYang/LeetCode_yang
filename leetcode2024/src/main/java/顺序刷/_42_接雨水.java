package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/20
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
public class _42_接雨水 {

    public static void main(String[] args) {
        int[] test = new int[]{4, 2, 3};
        System.out.println(trap(test));
    }

    public static int trap(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int result = 0;

        while (end < height.length) {
            if (height[end] >= height[start]) {
                if (end > start + 1) {
                    int minHeight = Math.min(height[end], height[start]);
                    for (int i = start + 1; i < end; i++) {
                        result += minHeight - height[i];
                    }
                }
                start = end;
            }
            end++;
        }

        int right = end = height.length - 1;
        while (right >= start) {
            if (height[right] >= height[end]) {
                if (end > right + 1) {
                    for (int i = right + 1; i < end; i++) {
                        result += height[end] - height[i];
                    }
                }
                end = right;
            }
            right--;
        }
        return result;
    }
}