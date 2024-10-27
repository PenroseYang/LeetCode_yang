package 顺序刷;

import java.util.Stack;

/**
 * @author yangzhe14
 * @since 2024/8/19
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * todo 括号的题目，最关键的就是，右括号必须有一个最近的左括号匹配上
 * 最近的这个左括号找到匹配的右括号之前，中间不允许插入任何其他的右括号，插入左括号无所谓
 * 所以需要记住左括号之间的顺序
 */
public class _20_有效的括号 {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char indexChar = s.charAt(i);
            if (indexChar == '(' || indexChar == '[' || indexChar == '{') {
                stack.push(indexChar);
            } else {
                // 弹不出来不行，弹出来不对不行
                if (stack.size() == 0) {
                    return false;
                }
                Character pop = stack.pop();
                if ((pop == '[' && indexChar != ']') ||
                        (pop == '(' && indexChar != ')') ||
                        (pop == '{' && indexChar != '}')) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}