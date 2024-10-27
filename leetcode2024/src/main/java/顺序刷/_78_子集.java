package 顺序刷;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/8/24
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class _78_子集 {

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3};
        System.out.println(subsets(test));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            ArrayList<Integer> single = new ArrayList<>();
            single.add(nums[i]);
            result.add(single);
            for (int j = 0; j < size; j++) {
                List<Integer> subTemSet = result.get(j);
                List<Integer> subCopy = new ArrayList<>(subTemSet);
                subCopy.add(nums[i]);
                result.add(subCopy);
            }
        }
        result.add(new ArrayList<>());
        return result;
    }
}