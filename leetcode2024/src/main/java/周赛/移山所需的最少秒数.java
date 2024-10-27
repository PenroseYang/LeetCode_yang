package 周赛;

import java.util.Arrays;

/**
 * @author yangzhe14
 * @since 2024/9/22
 * <p>
 * 给你一个整数 mountainHeight 表示山的高度。
 * <p>
 * 同时给你一个整数数组 workerTimes，表示工人们的工作时间（单位：秒）。
 * <p>
 * 工人们需要 同时 进行工作以 降低 山的高度。对于工人 i :
 * <p>
 * 山的高度降低 x，需要花费 workerTimes[i] + workerTimes[i] * 2 + ... + workerTimes[i] * x 秒。例如：
 * 山的高度降低 1，需要 workerTimes[i] 秒。
 * 山的高度降低 2，需要 workerTimes[i] + workerTimes[i] * 2 秒，依此类推。
 * 返回一个整数，表示工人们使山的高度降低到 0 所需的 最少 秒数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： mountainHeight = 4, workerTimes = [2,1,1]
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 将山的高度降低到 0 的一种方式是：
 * <p>
 * 工人 0 将高度降低 1，花费 workerTimes[0] = 2 秒。
 * 工人 1 将高度降低 2，花费 workerTimes[1] + workerTimes[1] * 2 = 3 秒。
 * 工人 2 将高度降低 1，花费 workerTimes[2] = 1 秒。
 * 因为工人同时工作，所需的最少时间为 max(2, 3, 1) = 3 秒。
 * <p>
 * 示例 2：
 * <p>
 * 输入： mountainHeight = 10, workerTimes = [3,2,2,4]
 * <p>
 * 输出： 12
 * <p>
 * 解释：
 * <p>
 * 工人 0 将高度降低 2，花费 workerTimes[0] + workerTimes[0] * 2 = 9 秒。
 * 工人 1 将高度降低 3，花费 workerTimes[1] + workerTimes[1] * 2 + workerTimes[1] * 3 = 12 秒。
 * 工人 2 将高度降低 3，花费 workerTimes[2] + workerTimes[2] * 2 + workerTimes[2] * 3 = 12 秒。
 * 工人 3 将高度降低 2，花费 workerTimes[3] + workerTimes[3] * 2 = 12 秒。
 * 所需的最少时间为 max(9, 12, 12, 12) = 12 秒。
 * <p>
 * 示例 3：
 * <p>
 * 输入： mountainHeight = 5, workerTimes = [1]
 * <p>
 * 输出： 15
 * <p>
 * 解释：
 * <p>
 * 这个示例中只有一个工人，所以答案是 workerTimes[0] + workerTimes[0] * 2 + workerTimes[0] * 3 + workerTimes[0] * 4 + workerTimes[0] * 5 = 15 秒。
 */
public class 移山所需的最少秒数 {

    public static void main(String[] args) {
        System.out.println(minNumberOfSeconds(4, new int[]{1, 1, 2}));
    }

    public static long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        Arrays.sort(workerTimes);
        long left = 0;
        long right = mountainHeight * mountainHeight;
        long mid = (left + right) / 2;
        while (left + 1 < right) {
            mid = (left + right) / 2;
            int moutainUsed = 0;
            for (int i = 0; i < workerTimes.length; i++) {
                moutainUsed += calculateHeight(workerTimes[i], mid);
            }
            if (moutainUsed >= mountainHeight) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 这里的值不对啊

        return 0;
    }

    public static long calculateHeight(long initSecond, long allSecond) {
        long usedSecond = 0;
        long times = 1;
        long moutainHeight = 0;
        while (usedSecond < allSecond) {
            usedSecond += times * initSecond;
            times++;
            if (usedSecond > allSecond) {
                return moutainHeight;
            } else {
                moutainHeight++;
            }
        }
        return moutainHeight;
    }

}