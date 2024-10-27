package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/12
 * <p>
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * <p>
 * 空格：读入字符串并丢弃无用的前导空格（" "）
 * 符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
 * 转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
 * 舍入：如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被舍入为 −231 ，大于 231 − 1 的整数应该被舍入为 231 − 1 。
 * 返回整数作为最终结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "42"
 * <p>
 * 输出：42
 * <p>
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * <p>
 * 带下划线线的字符是所读的内容，插入符号是当前读入位置。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 * ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * ^
 * 第 3 步："42"（读入 "42"）
 * ^
 * 示例 2：
 * <p>
 * 输入：s = " -042"
 * <p>
 * 输出：-42
 * <p>
 * 解释：
 * <p>
 * 第 1 步："   -042"（读入前导空格，但忽视掉）
 * ^
 * 第 2 步："   -042"（读入 '-' 字符，所以结果应该是负数）
 * ^
 * 第 3 步："   -042"（读入 "042"，在结果中忽略前导零）
 * ^
 * 示例 3：
 * <p>
 * 输入：s = "1337c0d3"
 * <p>
 * 输出：1337
 * <p>
 * 解释：
 * <p>
 * 第 1 步："1337c0d3"（当前没有读入字符，因为没有前导空格）
 * ^
 * 第 2 步："1337c0d3"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * ^
 * 第 3 步："1337c0d3"（读入 "1337"；由于下一个字符不是一个数字，所以读入停止）
 * ^
 * 示例 4：
 * <p>
 * 输入：s = "0-1"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 第 1 步："0-1" (当前没有读入字符，因为没有前导空格)
 * ^
 * 第 2 步："0-1" (当前没有读入字符，因为这里不存在 '-' 或者 '+')
 * ^
 * 第 3 步："0-1" (读入 "0"；由于下一个字符不是一个数字，所以读入停止)
 * ^
 * 示例 5：
 * <p>
 * 输入：s = "words and 987"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 读取在第一个非数字字符“w”处停止。
 * <p>
 * <p>
 * todo 字符串这些真的不行啊！
 */
public class _8_字符串转换整数 {

    public static void main(String[] args) {
        System.out.println(myAtoi("1337c0d3"));
    }

    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 过滤掉空格和第一位有符号数
        int index = 0;
        while (s.charAt(index) == ' ') {
            index++;
        }
        // 判断负数
        boolean negative = false;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            if (s.charAt(index) == '-') {
                negative = true;
            }
            index++;
        }
        // 跳过正负号后面的0
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                break;
            }
            index = i;
        }
        if (index == s.length()) {
            return 0;
        }
        // 获取有效字符串部分
        int postIndex = -1;
        for (int i = index; i < s.length(); i++) {
            // 如果含有0-9之外的字符，校验不过就报错
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            postIndex = i;
        }
        if (postIndex < index) {
            return 0;
        }
        String validString = s.substring(index, postIndex + 1);

        String max = String.valueOf(Integer.MAX_VALUE);
        String min = String.valueOf(Integer.MIN_VALUE);

        // 这个负数的范围超限比较麻烦
        if (negative && compareTo(validString, min, negative) < 0) {
            return Integer.MIN_VALUE;
        }
        if (!negative && compareTo(validString, max, negative) > 0) {
            return Integer.MAX_VALUE;
        }
        return (negative ? -1 : 1) * Integer.valueOf(validString);
    }

    public static int compareTo(String str1, String str2, boolean str2Negative) {
        int str2Length = str2Negative ? str2.length() - 1 : str2.length();
        int str1Length = str1.length();
        // 范围不等的情况下，谁长谁大
        if (str1Length != str2Length) {
            return ((str1Length > str2Length) ^ str2Negative) ? 1 : -1;
        }
        for (int i = 0; i < str2Length; i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            if (char1 > char2) {
                return !str2Negative ? 1 : -1;
            } else if (char1 < char2) {
                return str2Negative ? 1 : -1;
            } else {
                continue;
            }
        }
        return 0;
    }
}