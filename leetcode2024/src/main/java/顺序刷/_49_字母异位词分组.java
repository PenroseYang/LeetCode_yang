package 顺序刷;

import java.util.*;

/**
 * @author yangzhe14
 * @since 2024/8/23
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class _49_字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        // key是字符串，value是index位置
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            dict.put(strs[i], i);
        }

        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        // 每一个短语去找strs里面所有的异构
        for (int i = 0; i < strs.length; i++) {
            if (used[i]) {
                continue;
            }
            List<String> resTem = new ArrayList<>();
            resTem.add(strs[i]);
            used[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if (checkIsSearch(strs[i], strs[j])) {
                    resTem.add(strs[j]);
                    used[j] = true;
                }
            }
            result.add(new ArrayList<>(resTem));
        }
        return result;
    }

    private boolean checkIsSearch(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] charArray1 = str1.toCharArray();
        Arrays.sort(charArray1);
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray2);
        for (int i = 0; i < charArray1.length; i++) {
            if (charArray1[i] != charArray2[i]) {
                return false;
            }
        }
        return true;
    }
}