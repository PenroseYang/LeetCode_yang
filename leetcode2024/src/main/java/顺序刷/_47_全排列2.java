package 顺序刷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/8/22
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class _47_全排列2 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 2, 3, 3}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        // 含重复数字的全排列，取某一个数字的时候，不能越级来取了
        boolean[] used = new boolean[nums.length];
        List<Integer> tem = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        recurse(nums, used, tem, result);
        return result;
    }

    public static void recurse(int[] num, boolean[] used, List<Integer> tem, List<List<Integer>> result) {
        if (tem.size() == num.length) {
            result.add(new ArrayList<>(tem));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (used[i]) {
                continue;
            }
            // 如果这个没被用掉，就把这个用掉，但是要注意重复
            if (i > 0 && !used[i - 1] && num[i] == num[i - 1]) {
                continue;
            }
            used[i] = true;
            tem.add(num[i]);
            recurse(num, used, tem, result);
            used[i] = false;
            tem.remove(tem.size() - 1);
        }
    }
}