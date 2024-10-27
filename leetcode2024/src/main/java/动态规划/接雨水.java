package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/8
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
 * 提示：
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class 接雨水 {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        // 左边最高
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                leftMax[i] = height[0];
            } else {
                if (height[i] > leftMax[i - 1]) {
                    leftMax[i] = height[i];
                } else {
                    leftMax[i] = leftMax[i - 1];
                }
            }
        }

        // 右边最高
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                rightMax[i] = height[height.length - 1];
            } else {
                if (height[i] > rightMax[i + 1]) {
                    rightMax[i] = height[i];
                } else {
                    rightMax[i] = rightMax[i + 1];
                }
            }
        }
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            result = result + Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;
    }
}