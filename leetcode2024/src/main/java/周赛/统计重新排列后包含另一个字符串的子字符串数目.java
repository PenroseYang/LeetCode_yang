package 周赛;

import java.util.HashMap;

/**
 * @author yangzhe14
 * @since 2024/9/22
 */
public class 统计重新排列后包含另一个字符串的子字符串数目 {

    public static void main(String[] args) {
        System.out.println(validSubstringCount("dddddededddeeeddd", "eee"));
    }

    public static long validSubstringCount(String word1, String word2) {
        if (word1 == null || word2 == null || word2.length() == 0 || word1.length() == 0 || word1.length() < word2.length()) {
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        // word2中的词频，这个不变
        for (int i = 0; i < word2.length(); i++) {
            hashMap.put(word2.charAt(i), hashMap.getOrDefault(word2.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> word1Map = new HashMap<>();
        int searchCharacterCnt = hashMap.size();
        int foundCharacterCnt = 0;
        int result = 0;
        int left = 0;
        int right = 0;
        while (right < word1.length()) {
            // 当前这个字母在词表里面
            if (hashMap.containsKey(word1.charAt(right))) {
                int rightCharacterValue = word1Map.getOrDefault(word1.charAt(right), 0) + 1;
                word1Map.put(word1.charAt(right), rightCharacterValue);
                // 当前这个字母找全了
                if (rightCharacterValue == hashMap.get(word1.charAt(right))) {
                    foundCharacterCnt++;
                }
                // 所有字母都全了
                if (foundCharacterCnt == searchCharacterCnt) {
                    result += word1.length() - right;
                    // 移动左边的指针
                    while (foundCharacterCnt >= searchCharacterCnt) {
                        if (hashMap.containsKey(word1.charAt(left))) {
                            int leftValue = word1Map.getOrDefault(word1.charAt(left), 0) - 1;
                            word1Map.put(word1.charAt(left), leftValue);
                            if (leftValue < hashMap.get(word1.charAt(left))) {
                                foundCharacterCnt--;
                            }
                        }
                        left++;
                    }
                    right++;
                } else {
                    right++;
                }
            } else {
                right++;
            }
        }
        return result;
    }
}