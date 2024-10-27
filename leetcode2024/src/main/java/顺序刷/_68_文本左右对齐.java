package 顺序刷;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/8/27
 * <p>
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 注意:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例 1:
 * <p>
 * 输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * 输出:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * 输出:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * <p>
 * 输入:words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 20
 * 输出:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 * 提示:
 * <p>
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] 由小写英文字母和符号组成
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 */
public class _68_文本左右对齐 {
    public static void main(String[] args) {
        String[] words = {
                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to",
                "a", "computer.", "Art", "is", "everything", "else", "we", "do"
        };
        System.out.println(fullJustify(words, 20));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        int nowCount = 0;
        int lastEnd = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            // 结算从lastEnd到i-1之间的元素
            if ((nowCount + words[i].length()) >= maxWidth) {
                result.add(calculateString(words, lastEnd, i - 1, maxWidth));
                lastEnd = i;
                nowCount = 0;
            }
            // 首个元素不加额外的空格
            nowCount += words[i].length() + ((i == lastEnd) ? 0 : 1);
        }
        // 最后一次的结算一般是结算不上了，需要重新写一个
        result.add(calculateLastString(words, lastEnd, maxWidth));
        return result;
    }

    // 计算中间的那些string
    private static String calculateString(String[] words, int start, int end, int maxWidth) {
        int wordLength = 0;
        StringBuilder sb = new StringBuilder();
        // 就1个的情况
        if (start == end) {
            sb.append(words[start]);
            for (int i = 0; i < maxWidth - words[start].length(); i++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        // 2个以上的情况
        for (int i = start; i <= end; i++) {
            wordLength += words[i].length();
        }
        int avgDistance = (maxWidth - wordLength) / (end - start);

        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i == start) {
                for (int j = 0; j < maxWidth - wordLength - (end - start - 1) * avgDistance; j++) {
                    sb.append(" ");
                }
            } else if (i != end) {
                for (int j = 0; j < avgDistance; j++) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    // 计算最后一个string，规则不一样
    private static String calculateLastString(String[] words, int lastEnd, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int i = lastEnd; i < words.length; i++) {
            sb.append(words[i]);
            if (i != words.length - 1) {
                sb.append(" ");
            } else {
                int lastSpaceCount = maxWidth - sb.length();
                for (int j = 0; j < lastSpaceCount; j++) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}