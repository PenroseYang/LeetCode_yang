package 顺序刷;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author yangzhe14
 * @since 2024/8/23
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * 提示：
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 * Related Topics
 */
public class _76_最小覆盖子串 {

    public static void main(String[] args) {
        System.out.println(minWindow("a", "aa"));
    }

    public static String minWindow(String t, String s) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() < s.length()) {
            return "";
        }
        int resultLeft = 0;
        int resultRight = t.length() - 1;
        int left = 0;
        int right = 0;
        boolean found = false;

        // 统计所有的频率
        Map<Character, Integer> dictMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            dictMap.put(s.charAt(i), dictMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        Map<Character, Integer> temMap = new HashMap<>();
        int temCount = 0;
        while (right < t.length()) {
            // 右指针划了一下之后，把这一个数字记上去
            temMap.put(t.charAt(right), temMap.getOrDefault(t.charAt(right), 0) + 1);
            if (Objects.equals(temMap.get(t.charAt(right)), dictMap.get(t.charAt(right)))) {
                temCount++;
                // 已经找到了一个集合，这时候就要准备开始收缩了
                while (temCount == dictMap.keySet().size()) {
                    found = true;
                    if ((right - left) < (resultRight - resultLeft)) {
                        resultRight = right;
                        resultLeft = left;
                    }
                    // 左指针右移
                    if (Objects.equals(temMap.get(t.charAt(left)), dictMap.get(t.charAt(left)))) {
                        temCount--;
                    }
                    temMap.put(t.charAt(left), temMap.get(t.charAt(left)) - 1);
                    left++;
                }
            }
            right++;
        }
        return found ? t.substring(resultLeft, resultRight + 1) : "";
    }
}