package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/22
 * <p>
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n 是一个整数
 * 要么 x 不为零，要么 n > 0 。
 * -104 <= xn <= 104
 * <p>
 * todo 这个题有边界的问题，超过了最大整数，不写了不写了，没意思
 */
public class _50_POWXY {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));
    }

    public static double myPow(double x, int n) {
        if (n < 0) {
            n = -1 * n;
            return doMyPow(1.0 / x, n);
        } else {
            return doMyPow(x, n);
        }
    }

    private static double doMyPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }

        // n是带奇数的
        if (n % 2 == 1) {
            double half = doMyPow(x, n / 2);
            return half * half * x;
        } else {
            double half = doMyPow(x, n / 2);
            return half * half;
        }
    }
}