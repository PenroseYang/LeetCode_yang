package 顺序刷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/8/12
 * <p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class _15_三数之和 {

    public static void main(String[] args) {
        int[] num = new int[]{-1, 0, 1, 2, -1, -4};
//        System.out.println(threeSum(num));
//        num = new int[]{0, 1, 1};
//        System.out.println(threeSum(num));
//        num = new int[]{-1, 0, 1, 0};
//        System.out.println(threeSum(num));
        num = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        System.out.println(threeSum(num));
    }

    public static List<List<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(num);
        // key是要找的值，value是位置
        HashMap<Integer, Integer> tem = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            tem.put(num[i], i);
        }
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < num.length - 2; i++) {
            // 这里只能取第一位的
            if (i >= 1 && num[i] == num[i - 1]) {
                // todo 如果某一段不要了，跳过就行了，千万别乱加东西！j++不需要的！
                // 真的不写都不知道哟这种傻逼问题
                continue;
            }
            for (int j = i + 1; j < num.length - 1; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                Integer thirdIndex = tem.get(-num[i] - num[j]);
                if (thirdIndex != null && thirdIndex > j) {
                    List<Integer> oneResult = new ArrayList<>();
                    oneResult.add(num[i]);
                    oneResult.add(num[j]);
                    oneResult.add(num[thirdIndex]);
                    result.add(oneResult);
                }
            }
        }
        return result;
    }
}