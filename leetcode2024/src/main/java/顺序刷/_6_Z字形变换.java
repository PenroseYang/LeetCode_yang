package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/12
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 */
public class _6_Z字形变换 {
    public static void main(String[] args) {
        String paypalishiring = convert("AB", 1);
        System.out.println(paypalishiring);
        System.out.println(paypalishiring.equals("PINALSIGYAHRPI"));
    }

    /**
     * @param s
     * @param numRows 假设取值是4
     * @return
     */
    public static String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows || numRows == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        // 第一遍从上到下遍历
        for (int i = 1; i <= numRows; i++) {
            int index = i - 1;
            boolean flag = true;
            // 总和差距
            int twoLength = 2 * numRows - 2;
            // 第一次差距
            int firstGap = 2 * (numRows - i);
            // 第二次反差距
            int antiGap = twoLength - firstGap;
            result.append(s.charAt(index));
            System.out.print(index + " ");

            int gap = firstGap;
            index += gap;
            flag = false;

            /**
             * while循环有问题，这里需要判断的是做完状态跳跃之后，跳跃之后的那个状态是不是满足的
             * 所以进入循环之前，总是得自己手动跳跃一次，并且这里由于往往是后补的，总是能少抄一部分状态！
             */
            while (index < s.length()) {
                if (gap > 0) {
                    System.out.print(index + " ");
                    result.append(s.charAt(index));
                }
                gap = flag ? firstGap : antiGap;
                index += gap;
                flag = !flag;
            }
            System.out.println();
        }
        return result.toString();
    }
}