package 顺序刷;

import java.util.Arrays;

/**
 * @author yangzhe14
 * @since 2024/8/19
 * <p>
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 */
public class _16_最接近的三数之和 {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 1}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minGap = Integer.MAX_VALUE;
        int minResult = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 从i+1到length-1这个范围内，找search这个数字
            int search = target - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int getResult = nums[start] + nums[end];
                // 刚好找到了
                if (getResult == search) {
                    return target;
                } else {
                    // 没找到那就得看看了，不分结果记录
                    if (Math.abs(search - getResult) < minGap) {
                        minGap = Math.abs(search - getResult);
                        minResult = getResult + nums[i];
                    }
                    if (getResult > search) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return minResult;
    }
}