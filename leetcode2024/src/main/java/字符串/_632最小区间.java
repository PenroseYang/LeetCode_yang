package 字符串;

import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/8/2
 * <p>
 * 你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * <p>
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [[4,10,15,24,26],
 * [0,9,12,20],
 * [5,18,22,30]]
 * 输出：[20,24]
 * 解释：
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 * 示例 2：
 * <p>
 * 输入：nums = [[1,2,3],[1,2,3],[1,2,3]]
 * 输出：[1,1]
 * <p>
 * todo 这个解出来多指针就都会了
 *
 * todo 多指针的思路倒是会了，但是堆这块不是很会，算了，之后再把堆看看
 */
public class _632最小区间 {

    public int[] smallestRange(List<List<Integer>> nums) {
        // 第一位记录最小值，第二位记录最大值
        int[] result = new int[2];
        if (nums == null || nums.size() == 0) {
            return result;
        }
        int numSize = nums.size();
        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MIN_VALUE;
        // 初始化一个最初的数组出来，有位置和数值
        for (int i = 0; i <= numSize - 1; i++) {
            if (nums.get(i).get(0) < result[0]) {
                result[0] = nums.get(i).get(0);
            }
            if (nums.get(i).get(0) > result[0]) {
                result[1] = nums.get(i).get(0);
            }
        }

        int[] cache = new int[numSize];
        int completedNum = 0;

        // 先找第一个元素的min和max，找到0--5
        // 左边的区间不断往后延伸，构造出新的问题来，再次进行求解
        while (true) {
            for (int i = 0; i < cache.length; i++) {
                // 如果左指针划到头了直接就返回
                if (cache[i] == nums.get(i).size() - 1 && nums.get(i).get(cache[i]) == result[0]) {
                    return result;
                }
                int lastValue = nums.get(i).get(cache[i]);
                if (lastValue == result[0]) {
                    cache[i] = cache[i] + 1;
                    // 最大值维护一下
                    result[1] = Math.max(result[1], nums.get(i).get(cache[i] + 1));
                    // 最小值也看看
                    result[0] = nums.get(i).get(cache[i] + 1);
                }
            }
        }


    }


}