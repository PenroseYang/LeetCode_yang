package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/22
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
public class _44_通配符匹配 {
    // todo 这题的边界就在于开局可能有好几个 * ，算了懒得做了

    public static void main(String[] args) {
        System.out.println(isMatch("ho", "**ho"));
    }

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        if (s.length() == 0) {
            if (p.length() == 0) {
                return true;
            } else {
                for (int i = 0; i < p.length(); i++) {
                    if (p.charAt(i) != '*') {
                        return false;
                    }
                }
                return true;
            }
        }
        if (p.length() == 0) {
            return false;
        }

        // tem[匹配符的第i位][字符串的第j位]
        boolean[][] tem = new boolean[p.length() + 1][s.length() + 1];
        // 开局的特殊处理
        tem[0][0] = true;
        if (p.charAt(0) == '*') {
            tem[1][0] = true;
        }

        // 遍历剩下的
        for (int i = 0; i < p.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (tem[i + 1][j + 1]) {
                    continue;
                }
                if (p.charAt(i) == '*') {
                    tem[i + 1][j + 1] = tem[i][j] || tem[i][j + 1] || tem[i + 1][j];
                } else if (p.charAt(i) == '?') {
                    tem[i + 1][j + 1] = tem[i][j];
                } else {
                    tem[i + 1][j + 1] = tem[i][j] && p.charAt(i) == s.charAt(j);
                }
            }
        }
        return tem[p.length()][s.length()];
    }
}