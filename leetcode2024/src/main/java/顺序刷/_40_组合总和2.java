package 顺序刷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/8/22
 * <p>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 提示:
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class _40_组合总和2 {

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates, 8));
    }


    // 全排列问题
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        // 这里要去重了，先排个序
        Arrays.sort(candidates);

        List<Integer> tem = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        recurse(candidates, 0, target, tem, result);
        return result;
    }

    /**
     * @param candidates 原数组
     * @param index      走到第几个
     * @param target     要找多少
     * @param tem        要找多少
     * @param result     目前的结果
     */
    public static void recurse(int[] candidates, int index, int target, List<Integer> tem, List<List<Integer>> result) {
        if (target == 0) {
            List<Integer> resultTem = new ArrayList<>();
            resultTem.addAll(tem);
            result.add(resultTem);
        }
        if (target < 0 || index == candidates.length) {
            return;
        }
        if (target > 0) {
            // 取当前字段
            tem.add(candidates[index]);
            recurse(candidates, index + 1, target - candidates[index], tem, result);
            tem.remove(tem.size() - 1);
            // 不取当前字段
            int nextDistinctKey = findNextDistinctKey(candidates, index);
            if (nextDistinctKey > 0) {
                recurse(candidates, nextDistinctKey, target, tem, result);
            }
        }
    }

    public static int findNextDistinctKey(int[] candidates, int index) {
        for (int i = index + 1; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                return i;
            }
        }
        return -1;
    }
}