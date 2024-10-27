package 顺序刷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/8/23
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class _56_合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }

        // 二维排序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        int left = intervals[0][0];
        int rifht = intervals[0][1];

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > rifht) {
                result.add(new int[]{left, rifht});
                left = intervals[i][0];
                rifht = intervals[i][1];
            } else {
                rifht = Math.max(rifht, intervals[i][1]);
            }
        }
        result.add(new int[]{left, rifht});
        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i][0] = result.get(i)[0];
            resultArray[i][1] = result.get(i)[1];
        }
        return resultArray;
    }
}