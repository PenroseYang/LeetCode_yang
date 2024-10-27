package 顺序刷;

import java.util.Arrays;

/**
 * @author yangzhe14
 * @since 2024/9/2
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 */
public class _189_轮转数组 {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5,6,7,8,9};
        rotate(test,5);
        System.out.println(Arrays.toString(test));
    }

    public static void rotate(int[] nums, int k) {
        // 如果想要原地，123456 7，
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 最简单的一种情况，两边直接就换了
        if (k * 2 == nums.length) {
            for (int i = 0; i < k; i++) {
                int swap = nums[i + k];
                nums[i + k] = nums[i];
                nums[i] = swap;
            }
            return;
        } else {
            // 并没有什么好办法，还是正常写
            for (int i = 0; i < k; i++) {
                int swap = nums[nums.length - 1];
                for (int j = nums.length - 1; j >= 0; j--) {
                    if (j == 0) {
                        nums[j] = swap;
                    } else {
                        nums[j] = nums[j - 1];
                    }
                }
            }
        }
    }
}