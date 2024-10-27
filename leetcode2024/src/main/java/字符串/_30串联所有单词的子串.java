package 字符串;

import java.util.*;

/**
 * @author yangzhe14
 * @since 2024/8/1
 */
public class _30串联所有单词的子串 {
    public static void main(String[] args) {
        System.out.println(findSubstring("aaaaaaaaaaaaaa", new String[]{
                "aa", "aa"
        }));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null ||
                words.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> dict = new HashMap<>();
        // 构建一个词典Map，这里就不能变了
        for (int i = 0; i <= words.length - 1; i++) {
            Integer cnt = dict.get(words[i]);
            dict.put(words[i], cnt == null ? 1 : cnt + 1);
        }
        int wordLength = words[0].length();
        int left = 0;
        HashMap<String, Integer> avg = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        // 这里的i取值从0--wordLength-1，实际上就是left指针的几种初始情况
        for (int i = 0; i < wordLength; i++) {
            // 左右指针赋初值
            left = i;
            int dictExistCnt = 0;
            avg.clear();
            // todo 开区间还是完犊子，闭区间的话逼着你去思考最后一次是多少，还是闭区间更好！还是没遵守自己的规则
            for (int right = left + wordLength; right <= s.length(); right = right + wordLength) {
                String substring = s.substring(right - wordLength, right);
                // 如果右指针挪动的这一块刚好在dict里面存在
                if (dict.containsKey(substring)) {
                    int cnt = avg.get(substring) == null ? 1 : avg.get(substring) + 1;
                    avg.put(substring, cnt);
                    dictExistCnt++;

                    // 如果右边挪动了一下数量超了，挪动左指针
                    if (dict.get(substring) < cnt) {
                        // 如果右指针多了这一个之后超了
                        while (left < right) {
                            String declineSubString = s.substring(left, left + wordLength);
                            left = left + wordLength;
                            dictExistCnt--;
                            avg.put(declineSubString, avg.get(declineSubString) - 1);
                            if (declineSubString.equals(substring)) {
                                break;
                            }
                        }
                    }
                    // 左指针也挪动完毕之后，如果数量对上了
                    if (Objects.equals(dict.get(substring), avg.get(substring)) && dictExistCnt == words.length) {
                        result.add(left);
                    }
                } else {
                    // 这个区间废了，右指针挪了一块，这一块不在dict里面，左指针收缩
                    left = right;
                    avg.clear();
                    dictExistCnt = 0;
                }
            }
        }
        return result;
    }
}