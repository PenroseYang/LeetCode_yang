package 动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/7/9
 * <p>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
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
 */
public class _39组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return new ArrayList<>();
        }
        // 初始化
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 0; i <= target; i++) {
            dp.add(new ArrayList<>());
        }
        for (int candidate : candidates) {
            for (int i = candidate; i <= target; i++) {
                if (candidate == i) {
                    List<Integer> tem = new ArrayList<>();
                    tem.add(candidate);
                    dp.get(i).add(tem);
                } else {
                    List<List<Integer>> oldState = dp.get(i - candidate);
                    if (oldState == null || oldState.size() == 0) {
                        continue;
                    }
                    for (List<Integer> integers : oldState) {
                        List<Integer> copyList = new ArrayList<>();
                        copyList.addAll(integers);
                        copyList.add(candidate);
                        dp.get(i).add(copyList);
                    }
                }
            }
        }
        return dp.get(target);
    }
}