package 字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangzhe14
 * @since 2024/10/9
 */
public class LCR_字符串的排列 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab",
                "eidboaoo"));
    }

    // s2是否包含s1的变词
    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return true;
        }
        if (s2 == null || s2.length() < s1.length()) {
            return false;
        }

        HashMap<Character, Integer> dict = new HashMap<>();
        // 统计s1的词频
        for (int i = 0; i < s1.length(); i++) {
            dict.put(s1.charAt(i), dict.getOrDefault(s1.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> s2Dict = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s2Dict.put(s2.charAt(i), s2Dict.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (isSame(dict, s2Dict)) {
            return true;
        }

        // s1  0     s2   0 1 2
        int right = s1.length() - 1;
        int left = 0;

        // todo  fori 的这个条件很不好写，如果是自己写while循环，得比fori多考虑一层，很麻烦的！
        while (right < s2.length() - 1) {
            s2Dict.put(s2.charAt(left), s2Dict.getOrDefault(s2.charAt(left), 0) - 1);
            left++;
            right++;
            s2Dict.put(s2.charAt(right), s2Dict.getOrDefault(s2.charAt(right), 0) + 1);
            if (isSame(dict, s2Dict)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isSame(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1 == null || map2 == null) {
            return false;
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map1.entrySet()) {
            Character key = characterIntegerEntry.getKey();
            int map2Value = map2.getOrDefault(key, 0);
            if (map2Value != characterIntegerEntry.getValue()) {
                return false;
            }
        }
        return true;
    }
}