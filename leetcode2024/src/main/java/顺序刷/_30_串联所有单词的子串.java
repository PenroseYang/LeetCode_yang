package 顺序刷;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangzhe14
 * @since 2024/8/20
 * <p>
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * <p>
 * s 中的 串联子串 是指一个包含 words 中所有字符串以任意顺序排列连接起来的子串。
 * <p>
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。
 * "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 * 输出顺序无关紧要。返回 [9,0] 也是可以的。
 * 示例 2：
 * <p>
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
 * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
 * 所以我们返回一个空数组。
 * 示例 3：
 * <p>
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
 * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
 * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
 * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
 * <p>
 * todo 这个题就是滑动窗口的精髓了，必须做出来！
 */
public class _30_串联所有单词的子串 {

    public static void main(String[] args) {
        System.out.println(findSubstring("aaaaaaaaaaaaaa", new String[]{"aa", "aa"}));
    }

    // words 中所有字符串 长度相同。
    public static List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0 || words[0].length() == 0) {
            return new ArrayList<>();
        }
        int wordLength = words[0].length();
        if (s.length() < wordLength) {
            return new ArrayList<>();
        }

        // 假设foo foo foo
        Map<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> search = new HashMap<>();

        List<Integer> result = new ArrayList<>();
        int left, end = 0;
        for (int i = 0; i < wordLength; i++) {
            left = i;
            end = i;
            search = new HashMap<>();

            while (end + wordLength <= s.length()) {
                String subString = s.substring(end, end + wordLength);
                end += wordLength;
                if (dict.containsKey(subString)) {
                    search.put(subString, search.getOrDefault(subString, 0) + 1);
                    // 如果最后一段刚好有效，并且到长度了，左边指针要开始移动了
                    if (end - left == wordLength * words.length) {
                        if (dict.equals(search)) {
                            result.add(left);
                        }
                        String leftRemove = s.substring(left, left + wordLength);
                        search.put(leftRemove, search.get(leftRemove) - 1);
                        left += wordLength;
                    }
                } else {
                    // 如果不含这一部分，这个区间就废了
                    // todo 这里是不是得记一个笔记，各种量总是可能漏掉，每一个分支，都得看看所有的变量有哪些变化
                    // todo 想到办法了，在这里区分常量和变量，比如这里的变量是左右指针以及一个tem的哈希Map，这三个变量理论上都应该同时被变更掉
                    // todo 如果少了一个的话，就肯定有问题
                    left = end;
                    search = new HashMap<>();
                }
            }
        }
        return result;
    }
}