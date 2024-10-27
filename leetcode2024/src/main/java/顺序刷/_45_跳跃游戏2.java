package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/22
 * <p>
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 */
public class _45_跳跃游戏2 {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{0}));
    }

    public static int jump(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length - 1;
        }

        // 赋初值
        int[] tem = new int[nums.length];
        tem[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            tem[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            int rightTarget = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= rightTarget; j++) {
                tem[j] = Math.min(tem[j], tem[i] + 1);
            }
        }
        return tem[nums.length - 1];
    }

}