package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/8
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * 提示：
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * 进阶：
 * <p>
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * <p>
 * 个人笔记：
 * （1） max的初始值一定要想明白，你在给result[1]赋初值的时候，一定要想着，最终结果的初值也要好好弄
 * （2） 动态规划的问题，一定要有Min和Max的操作，别忘了
 */
public class 最长上升子序列 {
    public static void main(String[] args) {
        int[] test = new int[]{7, 7, 7, 7, 7, 7, 7};
        System.out.println(lengthOfLIS(test));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        if (nums.length == 1) {
            return 1;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    result[i] = Math.max(result[j] + 1, result[i]);
                    max = Math.max(max, result[i]);
                }
            }
        }
        return max;
    }
}