package 周赛;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangzhe14
 * @since 2024/9/22
 * 给你一个字符串数组 message 和一个字符串数组 bannedWords。
 * <p>
 * 如果数组中 至少 存在两个单词与 bannedWords 中的任一单词 完全相同，则该数组被视为 垃圾信息。
 * <p>
 * 如果数组 message 是垃圾信息，则返回 true；否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： message = ["hello","world","leetcode"], bannedWords = ["world","hello"]
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 数组 message 中的 "hello" 和 "world" 都出现在数组 bannedWords 中。
 * <p>
 * 示例 2：
 * <p>
 * 输入： message = ["hello","programming","fun"], bannedWords = ["world","programming","leetcode"]
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 数组 message 中只有一个单词（"programming"）出现在数组 bannedWords 中。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= message.length, bannedWords.length <= 105
 * 1 <= message[i].length, bannedWords[i].length <= 15
 * message[i] 和 bannedWords[i] 都只由小写英文字母组成。
 */
public class 举报垃圾信息 {

    public boolean reportSpam(String[] message, String[] bannedWords) {
        if (bannedWords == null || message == null || bannedWords.length == 0 || message.length < 2) {
            return false;
        }
        Set<String> word = new HashSet<>();
        for (int i = 0; i < bannedWords.length; i++) {
            word.add(bannedWords[i]);
        }

        int count = 0;
        for (int i = 0; i < message.length; i++) {
            if (word.contains(message[i])) {
                count++;
            }
            if (count >= 2) {
                return true;
            }
        }
        return false;
    }
}