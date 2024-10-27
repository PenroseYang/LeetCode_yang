package 顺序刷;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/8/27
 * <p>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * 提示：
 * <p>
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅由小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 */
public class _139_单词拆分 {
    public static void main(String[] args) {
        ArrayList wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("abc");
        wordDict.add("b");
        wordDict.add("cd");

        System.out.println(wordBreak("abcd", wordDict));
    }

    public static boolean wordBreak(String search, List<String> wordDict) {
        if (search == null || wordDict == null || search.length() == 0 || wordDict.size() == 0) {
            return false;
        }
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] result = new boolean[search.length()];
        for (int i = 0; i < search.length(); i++) {
            for (String word : wordDict) {
                // 超限了
                if (i + word.length() > search.length()) {
                    continue;
                    // 以当前下标结尾已经成功了
                } else if (result[i + word.length() - 1]) {
                    continue;
                } else {
                    // 如果前一个不满足，当前这个也不用看了
                    if (i > 0 && !result[i - 1]) {
                        break;
                    }
                    if (dict.contains(search.substring(i, i + word.length()))) {
                        result[i + word.length() - 1] = true;
                        if (i + word.length() == search.length()) {
                            return true;
                        }
                    }
                }
            }
        }
        return result[search.length() - 1];
    }
}