package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/23
 * <p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */
public class _53_最大子数组和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] result = new int[nums.length];
        int max = nums[0];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i] + Math.max(0, result[i - 1]);
            max = Math.max(max, result[i]);
        }
        return max;
    }
}