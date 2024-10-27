package 顺序刷;

import java.util.Arrays;

/**
 * @author yangzhe14
 * @since 2024/8/23
 * <p>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * 进阶：
 * <p>
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class _75_颜色分类 {
    public static void main(String[] args) {
        int[] test = new int[]{2, 0, 1};
        sortColors(test);
        System.out.println(Arrays.toString(test));

    }

    // 数组里只有0、1、2，把0、1、2进行排序
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int notZeroIndex = 0;
        int notTwoIndex = nums.length - 1;

        int left = 0;
        while (left <= notTwoIndex) {
            if (nums[left] == 0) {
                if (left == notZeroIndex) {
                    left++;
                    notZeroIndex++;
                } else {
                    int swap = nums[notZeroIndex];
                    nums[notZeroIndex] = 0;
                    nums[left] = swap;
                    notZeroIndex++;
                }
            } else if (nums[left] == 2) {
                int swap = nums[notTwoIndex];
                nums[notTwoIndex] = 2;
                nums[left] = swap;
                notTwoIndex--;
            } else {
                // 如果碰上1的不处理
                left++;
            }
        }
    }
}