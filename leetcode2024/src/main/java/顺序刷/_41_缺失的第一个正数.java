package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/22
 * <p>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 */
public class _41_缺失的第一个正数 {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minPositive = Integer.MAX_VALUE;
        // 先找一下最小的那个正整数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] < minPositive) {
                minPositive = nums[i];
            }
        }
        // 1不在的话直接输出1了
        if (minPositive > 1) {
            return 1;
        }
        int left = 0;
        while (left < nums.length) {
            if (nums[left] <= 0 || nums[left] > nums.length) {
                // 这个坑位就废了
                nums[left] = -1;
                left++;
            } else if (nums[left] == left + 1) {
                // 这个数字放的非常正确，不需要处理
                left++;
            } else {
                // 这个数是0以上的，而且放的还不对，应该放在 num[left] -1 这个位置上
                // 那个位置上放的也是对的
                if (nums[nums[left] - 1] == nums[left]) {
                    // 那说明重复了一个数字，不需要管
                    nums[left] = -1;
                    left++;
                } else {
                    // 把那个位置的数字换出来
                    int swap = nums[nums[left] - 1];
                    nums[nums[left] - 1] = nums[left];
                    nums[left] = swap;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}