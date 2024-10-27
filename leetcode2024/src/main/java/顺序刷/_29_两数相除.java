package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/19
 * <p>
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * <p>
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的 商 。
 * <p>
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
 */
public class _29_两数相除 {
    public static void main(String[] args) {
        System.out.println(divide(1, 1));
    }

    public static int divide(int dividend, int divisor) {
        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend < divisor) {
            return 0;
        }
        String dividendString = String.valueOf(dividend);

        int left = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dividendString.length(); i++) {
            left = left * 10 + (dividendString.charAt(i) - '0');
            if (left < divisor) {
                continue;
            } else {
                int divideResult = 0;
                while (left >= divisor) {
                    left = left - divisor;
                    divideResult++;
                }
                result.append(divideResult);
            }
        }
        return Integer.parseInt(result.toString()) * (positive ? 1 : -1);
    }
}