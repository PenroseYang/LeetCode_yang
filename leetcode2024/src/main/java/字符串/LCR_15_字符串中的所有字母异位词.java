package 字符串;

import java.util.*;

/**
 * @author yangzhe14
 * @since 2024/10/9
 */
public class LCR_15_字符串中的所有字母异位词 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("aa", "bb"));
    }

    public static List<Integer> findAnagrams(String p, String s) {
        // 校验
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() < s.length()) {
            return new ArrayList<>();
        }
        // 词频
        Map<Character, Integer> sDict = new HashMap<>();
        Map<Character, Integer> pDict = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sDict.put(s.charAt(i), sDict.getOrDefault(s.charAt(i), 0) + 1);
            pDict.put(p.charAt(i), pDict.getOrDefault(p.charAt(i), 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        if (isSame(sDict, pDict)) {
            result.add(0);
        }

        int left = 0;
        int right = s.length() - 1;
        while (right <= p.length() - 2) {
            pDict.put(p.charAt(left), pDict.getOrDefault(p.charAt(left), 0) - 1);
            left++;
            right++;
            pDict.put(p.charAt(right), pDict.getOrDefault(p.charAt(right), 0) + 1);
            if (isSame(sDict, pDict)) {
                result.add(left);
            }
        }
        return result;
    }

    public static boolean isSame(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> characterIntegerEntry : map1.entrySet()) {
            Character key = characterIntegerEntry.getKey();
            Integer value = characterIntegerEntry.getValue();
            if (!Objects.equals(value, map2.getOrDefault(key, 0))) {
                return false;
            }
        }
        return true;
    }
}