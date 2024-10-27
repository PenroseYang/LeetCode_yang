package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/9
 * <p>
 * 给你一个输入字符串 ( s) 和一个字符模式 ( p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符序列（包括空字符序列）。
 * 判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2：
 * <p>
 * 输入：s = "aa", p = "*"
 * 输出：true
 * 解释：'*' 可以匹配任意字符串。
 * 示例 3：
 * <p>
 * 输入：s = "cb", p = "?a"
 * 输出：false
 * 解释：'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 提示：
 * <p>
 * 0 <= s.length, p.length <= 2000
 * s 仅由小写英文字母组成
 * p 仅由小写英文字母、'?' 或 '*' 组成
 */
public class _44通配符匹配 {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "*****"));
    }

    public static boolean isMatch(String s, String p) {
        // 第一位是pattern，第二位是待匹配字符串
        boolean[][] pass = new boolean[p.length() + 1][s.length() + 1];
        pass[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                pass[i + 1][0] = true;
            } else {
                break;
            }
        }
        if (s == null || s.length() == 0 || p.length() == 0) {
            return pass[p.length()][s.length()];
        }

        for (int i = 0; i < p.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (p.charAt(i) == '*') {
                    pass[i + 1][j + 1] = pass[i][j] || pass[i + 1][j] || pass[i][j + 1];
                }
                if (p.charAt(i) == '?') {
                    pass[i + 1][j + 1] = pass[i][j];
                }
                if (p.charAt(i) == s.charAt(j)) {
                    pass[i + 1][j + 1] = pass[i][j];
                }
            }
        }
        return pass[p.length()][s.length()];
    }
}