package 动态规划;

import java.util.Arrays;

/**
 * @author yangzhe14
 * @since 2024/7/9
 * <p>
 * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 * <p>
 * 沿途有加油站，用数组 stations 表示。其中 stations[i] = [positioni, fueli] 表示第 i 个加油站位于出发位置东面 positioni 英里处，并且有 fueli 升汽油。
 * <p>
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 * <p>
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 * <p>
 * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 1, startFuel = 1, stations = []
 * 输出：0
 * 解释：可以在不加油的情况下到达目的地。
 * 示例 2：
 * <p>
 * 输入：target = 100, startFuel = 1, stations = [[10,100]]
 * 输出：-1
 * 解释：无法抵达目的地，甚至无法到达第一个加油站。
 * 示例 3：
 * <p>
 * 输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * 输出：2
 * 解释：
 * 出发时有 10 升燃料。
 * 开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
 * 然后，从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
 * 并将汽油从 10 升加到 50 升。然后开车抵达目的地。
 * 沿途在两个加油站停靠，所以返回 2 。
 * 提示：
 * <p>
 * 1 <= target, startFuel <= 109
 * 0 <= stations.length <= 500
 * 1 <= positioni < positioni+1 < target
 * 1 <= fueli < 109
 */
public class _871_最低加油次数 {

    public static void main(String[] args) {
        int[][] test = new int[][]{{25, 25}, {50, 25}, {75, 25}};
        System.out.println(minRefuelStops(100, 25, test));
    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }
        if (stations.length == 0) {
            return -1;
        }
        int length = stations.length;
        boolean[] used = new boolean[length];
        Arrays.sort(stations, (o1, o2) -> o2[1] - o1[1]);
        // 剩下来的汽油
        int leftFuel = startFuel;
        // 当前的位置
        int position = 0;
        // 加油的次数
        int times = 0;
        // 当位置比目标要大或者等于的时候退出
        while (position + leftFuel < target) {
            // i是第几个加油站
            for (int i = 0; i < length; i++) {
                // 如果已经路过了
                if (position >= stations[i][0] && !used[i]) {
                    leftFuel = leftFuel + stations[i][1];
                    times++;
                    used[i] = true;
                    break;
                } else if (stations[i][0] <= leftFuel + position && !used[i]) {
                    leftFuel = leftFuel - stations[i][0] + position + stations[i][1];
                    position = stations[i][0];
                    times++;
                    used[i] = true;
                    break;
                } else if (i == length - 1) {
                    // 走到最后一个也没有能加油的地方，直接报错了
                    return -1;
                }
            }
        }
        return times;
    }
}