package 字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangzhe14
 * @since 2024/10/10
 */
public class LCR_16_无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }

        int left = 0;
        int right = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();

        // right 不停右移
        while (right <= s.length() - 1) {
            if (set.contains(s.charAt(right))) {
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                set.add(s.charAt(right));
            }
            result = Math.max(right - left + 1, result);
            right++;
        }
        return result;
    }
}