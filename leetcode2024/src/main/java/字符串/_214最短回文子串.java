package 字符串;

/**
 * @author yangzhe14
 * @since 2024/8/2
 * <p>
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aacecaaa"
 * 输出："aaacecaaa"
 * 示例 2：
 * <p>
 * 输入：s = "abcd"
 * 输出："dcbabcd"
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 仅由小写英文字母组成
 */
public class _214最短回文子串 {

    public static void main(String[] args) {
        String test = "aacecaaa";
        System.out.println(shortestPalindrome(test));
    }

    public static String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int right = 0;
        for (int i = s.length() - 1; i >= 1; i--) {
            // 如果从末尾开始找到了
            if (checkReverse(s, 0, i)) {
                // 目前从0--right这个区间内是回文的
                right = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= right + 1; i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }

    public static boolean checkReverse(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}