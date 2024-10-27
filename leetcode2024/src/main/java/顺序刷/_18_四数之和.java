package 顺序刷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/8/19
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组
 * [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
public class _18_四数之和 {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // 固定两位，第一位跟自己不能重复
        for (int i = 0; i <= nums.length - 3; i++) {
            // todo 这里的边界非常有问题啊，到哪里结束
            // 比如一共取4位，正常思路是至少给后面留3个，如果从第二位开始留不出3个了，这怎么办，这里就应该直接往后跳，不考虑留不留的问题
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 固定第二位，第二位跟自己不能重复
            for (int j = i + 1; j <= nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    // 如果start跟前一位撞了，不取，直接往后跳
                    if (start > j + 1 && nums[start] == nums[start - 1]) {
                        start++;
                        continue;
                    }

                    // todo 这里还有一个int相加超界的问题！fuck
                    long search = (long) target - (long) nums[i] - (long) nums[j];
                    long getResult = (long) nums[start] + (long) nums[end];
                    if (getResult == search) {
                        List<Integer> tem = new ArrayList<>();
                        tem.add(nums[i]);
                        tem.add(nums[j]);
                        tem.add(nums[start]);
                        tem.add(nums[end]);
                        result.add(tem);
                        start++;
                    } else if (getResult > search) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }
}