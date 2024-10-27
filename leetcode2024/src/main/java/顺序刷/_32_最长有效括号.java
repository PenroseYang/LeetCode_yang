package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/20
 * <p>
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 * <p>
 * <p>
 * 规则思考：括号的有效，左括号随便堆叠，右括号出来的时候判定规则，右括号如果匹配不上单出，就有问题
 */
public class _32_最长有效括号 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()()))))()()("));
    }

    // 输出的是最长的长度  (()
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        // 动态规划，如果后面那个是右括号的话，往前找一个左括号才行
        int[] num = new int[s.length()];
        int result = 0;
        if (s.charAt(0) == '(' && s.charAt(1) == ')') {
            num[1] = 2;
            result = 2;
        }

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    num[i] = num[i - 2] + 2;
                } else {
                    int left = i - num[i - 1] - 1;
                    // 如果能构成有效括号
                    if (left >= 0 && s.charAt(left) == '(') {
                        num[i] = num[i - 1] + 2;
                        // 这个括号前面一段也要包含进来
                        if (left >= 1) {
                            num[i] += num[left - 1];
                        }
                    }
                }
            }
            result = Math.max(result, num[i]);
        }
        return result;
    }
}