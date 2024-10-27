package 字符串;

/**
 * @author yangzhe14
 * @since 2024/10/10
 */
public class LCR_20_回文子串 {
    public int countSubstrings(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }

        int result = 0;
        // 奇数长度的回文数量
        for (int mid = 0; mid < s.length(); mid++) {
            int left = mid, right = mid;
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }
        }

        // 偶数长度的回文数量
        for (int mid = 0; mid < s.length(); mid++) {
            int left = mid, right = mid + 1;
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }
        }

        return result;
    }
}