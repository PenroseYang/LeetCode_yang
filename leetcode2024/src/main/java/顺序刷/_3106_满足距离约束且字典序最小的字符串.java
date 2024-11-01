package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/9/1
 * <p>
 * <p>
 * 给你一个字符串 s 和一个整数 k 。
 * <p>
 * 定义函数 distance(s1, s2) ，用于衡量两个长度为 n 的字符串 s1 和 s2 之间的距离，即：
 * <p>
 * 字符 'a' 到 'z' 按 循环 顺序排列，对于区间 [0, n - 1] 中的 i ，计算所有「 s1[i] 和 s2[i] 之间 最小距离」的 和 。
 * 例如，distance("ab", "cd") == 4 ，且 distance("a", "z") == 1 。
 * <p>
 * 你可以对字符串 s 执行 任意次 操作。在每次操作中，可以将 s 中的一个字母 改变 为 任意 其他小写英文字母。
 * <p>
 * 返回一个字符串，表示在执行一些操作后你可以得到的 字典序最小 的字符串 t ，且满足 distance(s, t) <= k 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "zbbz", k = 3
 * 输出："aaaz"
 * 解释：在这个例子中，可以执行以下操作：
 * 将 s[0] 改为 'a' ，s 变为 "abbz" 。
 * 将 s[1] 改为 'a' ，s 变为 "aabz" 。
 * 将 s[2] 改为 'a' ，s 变为 "aaaz" 。
 * "zbbz" 和 "aaaz" 之间的距离等于 k = 3 。
 * 可以证明 "aaaz" 是在任意次操作后能够得到的字典序最小的字符串。
 * 因此，答案是 "aaaz" 。
 * 示例 2：
 * <p>
 * 输入：s = "xaxcd", k = 4
 * 输出："aawcd"
 * 解释：在这个例子中，可以执行以下操作：
 * 将 s[0] 改为 'a' ，s 变为 "aaxcd" 。
 * 将 s[2] 改为 'w' ，s 变为 "aawcd" 。
 * "xaxcd" 和 "aawcd" 之间的距离等于 k = 4 。
 * 可以证明 "aawcd" 是在任意次操作后能够得到的字典序最小的字符串。
 * 因此，答案是 "aawcd" 。
 * 示例 3：
 * <p>
 * 输入：s = "lol", k = 0
 * 输出："lol"
 * 解释：在这个例子中，k = 0，更改任何字符都会使得距离大于 0 。
 * 因此，答案是 "lol" 。
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * 0 <= k <= 2000
 * s 只包含小写英文字母。
 * Related Topics
 * 贪心
 * 字符串
 */
public class _3106_满足距离约束且字典序最小的字符串 {

    public String getSmallestString(String s, int k) {
        if (k == 0 || s == null || s.length() == 0) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int kLeft = k;
        for (int i = 0; i < s.length(); i++) {
            // 如果是a就不处理
            if (s.charAt(i) == 'a') {
                result.append('a');
                continue;
            }
            // 不是a就往a上面靠拢
            int distanceToA = calculateDistance(s.charAt(i), 'a');
            if (kLeft >= distanceToA) {
                kLeft -= distanceToA;
                result.append('a');
            } else {
                // 这个数字减不到a了，那这个循环基本就到头了
                result.append((char) (s.charAt(i) - kLeft));
                for (int j = i + 1; j < s.length(); j++) {
                    result.append(s.charAt(j));
                }
                return result.toString();
            }
        }

        return result.toString();
    }

    public int calculateDistance(Character from, Character to) {
        int result1 = Math.abs(to - from);
        int result2 = Math.min('z' - from, 'z' - to) + 1 + Math.min(from - 'a', to - 'a');
        return Math.min(result2, result1);
    }
}