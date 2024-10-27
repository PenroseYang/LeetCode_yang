package 顺序刷;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/8/22
 * <p>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 * Related Topics
 * 数组
 * 回溯
 */
public class _39_组合总和 {

    public static void main(String[] args) {
        int[] test = new int[]{2, 3, 5};
        System.out.println(combinationSum(test, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        // 最后一步应该是left挪到candidate前面最后一步
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temList = new ArrayList<>();
        recurse(candidates, 0, temList, target, result);
        return result;
    }

    /**
     * @param candidates 总的候选，这个肯定得有
     * @param index      遍历到第几位了
     * @param temList    当前的进度是多少
     * @param target     当前要找的是多少
     */
    public static void recurse(int[] candidates, int index, List<Integer> temList, int target, List<List<Integer>> result) {
        // 如果找到了target，把当前的结果保存
        if (target == 0) {
            List<Integer> resultTem = new ArrayList<>();
            resultTem.addAll(temList);
            result.add(resultTem);
        }
        // 如果target已经小于0了，寻找失败
        if (target < 0 || index >= candidates.length) {
            return;
        }

        // 如果寻找的元素大于0
        if (target > 0) {
            temList.add(candidates[index]);
            recurse(candidates, index, temList, target - candidates[index], result);
            temList.remove(temList.size() - 1);
            recurse(candidates, index + 1, temList, target, result);
        }
    }
}