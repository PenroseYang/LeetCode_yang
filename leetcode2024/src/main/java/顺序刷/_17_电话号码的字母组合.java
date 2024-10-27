package 顺序刷;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/8/19
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class _17_电话号码的字母组合 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("999"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            List<String> selectableChar = getSelectableChar(digits.charAt(i));
            if (selectableChar == null) {
                continue;
            }
            int size = result.size();
            if (size == 0) {
                result = selectableChar;
            } else {
                // 把result里面每一个元素都迭代一遍
                for (int j = 0; j < size; j++) {
                    String remove = result.remove(0);
                    // 下一个元素再来一遍扔进去
                    for (String selectableCharElement : selectableChar) {
                        result.add(remove + selectableCharElement);
                    }
                }
            }
        }
        return result;
    }

    public static List<String> getSelectableChar(char c) {
        if (c == 1) {
            return null;
        } else if (c != '9' && c != '7' && c != '8') {
            List result = new ArrayList();
            int start = c - '2';
            for (int i = 0; i < 3; i++) {
                result.add(String.valueOf((char) ('a' + start * 3 + i)));
            }
            return result;
        } else if (c == '7') {
            List result = new ArrayList();
            result.add("p");
            result.add("q");
            result.add("r");
            result.add("s");
            return result;
        } else if (c == '8') {
            List result = new ArrayList();
            result.add("t");
            result.add("u");
            result.add("v");
            return result;
        } else {
            List result = new ArrayList();
            result.add("w");
            result.add("x");
            result.add("y");
            result.add("z");
            return result;
        }
    }
}