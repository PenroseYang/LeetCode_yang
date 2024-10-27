package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/13
 * <p>
 * 恶魔们抓住了公主并将她关在了地下城 dungeon 的 右下角 。地下城是由 m x n 个房间组成的二维网格。我们英勇的骑士最初被安置在 左上角 的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快解救公主，骑士决定每次只 向右 或 向下 移动一步。
 * <p>
 * 返回确保骑士能够拯救到公主所需的最低初始健康点数。
 * <p>
 * 注意：任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 * <p>
 * <p>
 * todo 从最后一步开始往前倒推的，最后一步状态非常确定，推到第一步！！！fuck！
 */
public class _174_龙与地下城游戏 {

    public static void main(String[] args) {
        int[][] input = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int i = calculateMinimumHP(input);
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 0;
        }

        // 走每个格子的时候，最大的最少血量是多少
        int[][] maxMinHealth = new int[dungeon.length][dungeon[0].length];
        // 如果维持了maxMin策略，在这个格子上的血量是多少
        int[][] currentHealth = new int[dungeon.length][dungeon[0].length];

        maxMinHealth[0][0] = dungeon[0][0];
        // 第一行的初始化
        for (int i = 1; i < dungeon[0].length; i++) {
            maxMinHealth[0][i] = maxMinHealth[0][i - 1] + dungeon[0][i];
        }
        // 第一列初始化
        for (int i = 1; i < dungeon.length; i++) {
            maxMinHealth[i][0] = maxMinHealth[i - 1][0] + dungeon[i][0];
        }




        return 0;

    }
}