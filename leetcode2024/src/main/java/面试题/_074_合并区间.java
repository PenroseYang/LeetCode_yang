package 面试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yangzhe14
 * @since 2024/9/22
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
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
public class _074_合并区间 {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 10}, {2, 3}, {4, 5}, {6, 7}, {8, 9}};
        int[][] merge = merge(input);
        System.out.println(merge);
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        ArrayList<int[]> result = new ArrayList<>();
        int left = 0, right = 1;

        // todo 重点：合并区间这个题类似于一个双指针，不过重点在于右边界的维护上
        int rightValue = intervals[0][1];
        while (right < intervals.length) {
            // 如果当前right和前一个凑不上了
            if (intervals[right][0] > rightValue) {
                result.add(new int[]{intervals[left][0], rightValue});
                left = right;
                rightValue = intervals[right][1];
                right++;
            } else {
                rightValue = Math.max(rightValue, intervals[right][1]);
                right++;
            }
        }
        result.add(new int[]{intervals[left][0], rightValue});


        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < 2; j++) {
                resultArray[i][j] = result.get(i)[j];
            }
        }
        return resultArray;
    }

}