package 顺序刷;

import java.util.Arrays;

/**
 * @author yangzhe14
 * @since 2024/8/21
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * 半递增的，中间有重复元素，找某一个固定元素，的开始位置和结束位置，找第一个出现的和最后一个出现的位置，两个位置
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));

    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = 0, end = nums.length - 1;
        int mid = 0;
        while ((start + 1) < end) {
            mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        int left = -1;
        if (nums[end] == target) {
            left = end;
        }
        if (nums[start] == target) {
            left = start;
        }

        start = 0;
        end = nums.length - 1;
        while ((start + 1) < end) {
            mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        int right = -1;
        if (nums[start] == target) {
            right = start;
        }
        if (nums[end] == target) {
            right = end;
        }
        return new int[]{left, right};
    }
}