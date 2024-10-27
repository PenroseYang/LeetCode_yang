package 字符串;

/**
 * @author yangzhe14
 * @since 2024/8/5
 * <p>
 * 给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。
 * <p>
 * “最近的”定义为两个整数差的绝对值最小。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = "123"
 * 输出: "121"
 * 示例 2:
 * <p>
 * 输入: n = "1"
 * 输出: "0"
 * 解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
 */
public class _564寻找最近的回文数 {
    public static void main(String[] args) {
//        12399,12321,12421   100
        System.out.println(nearestPalindromic("12399"));
        System.out.println(nearestPalindromic("12321"));
        System.out.println(nearestPalindromic("12421"));
    }

    public static String nearestPalindromic(String n) {
        if (n == null || n.length() == 0) {
            return "0";
        }
        if (n.length() == 1 || n.equals("10")) {
            return String.valueOf(Integer.valueOf(n) - 1);
        }
        Integer originValue = Integer.valueOf(n);
        int leftSize = n.length() / 2 + n.length() % 2;
        String leftString = n.substring(0, leftSize);
        int leftValue = Integer.valueOf(leftString);
        int leftValueMinueOne = leftValue - 1;
        int leftValuePlusOne = leftValue + 1;

        int leftValueInteger = calculate(leftValue, false);
        int leftValueMinueOneInteger = calculate(leftValueMinueOne, false);
        int leftValuePlusOneInteger = calculate(leftValuePlusOne, false);
        int leftScore = Math.abs(leftValueInteger - originValue);
        int leftPlusOneScore = leftValuePlusOneInteger - originValue;
        int leftMinusOneScore = Math.abs(leftValueMinueOneInteger - originValue);
        int resultValue = leftValuePlusOneInteger;
        int minScore = leftPlusOneScore;
        if (leftMinusOneScore <= minScore) {
            resultValue = leftValueMinueOneInteger;
        }
        if (leftScore <= minScore && leftScore > 0) {
            resultValue = leftValueInteger;
        }
        return String.valueOf(leftValueInteger);
    }

    public static int calculate(int value, boolean holdLast) {
        String stringValue = String.valueOf(value);
        StringBuilder sb = new StringBuilder();
        sb.append(stringValue);
        for (int i = stringValue.length() - 1; i >= 0; i--) {
            sb.append(stringValue.charAt(i));
        }
        return Integer.valueOf(sb.toString());
    }
}