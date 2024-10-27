package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/8
 * <p>
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * <p>
 * 个人笔记：
 * （1）substring有问题，第二个参数是endIndex但是不包含这个endIndex，想要的话要+1
 * （2）子问题必须都先被计算出来，这才是斜向遍历的原因，因为子问题在这里摆着
 * 因为长度更大的串用到了长度更小串的状态，所以需要先算长度小的
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        String s = "aefa";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        // 异常处理
        if (s == null || s.length() <= 1) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return String.valueOf(s.charAt(0));
            }
        }

        int max = 0;
        String resultString = String.valueOf(s.charAt(0));
        // 如果数据量大于3，数据准备
        boolean[][] result = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i][i] = true;
        }

        // 开始遍历
        for (int length = 1; length < s.length(); length++) {
            for (int startIndex = 0; startIndex < s.length() - length; startIndex++) {
                if (length == 1) {
                    if (s.charAt(startIndex) == s.charAt(startIndex + 1)) {
                        result[startIndex][startIndex + length] = true;
                        if (max <= length + 1) {
                            max = length + 1;
                            resultString = s.substring(startIndex, startIndex + length + 1);
                        }
                    }
                } else {
                    if (s.charAt(startIndex) == s.charAt(startIndex + length)) {
                        result[startIndex][startIndex + length] = result[startIndex + 1][startIndex + length - 1];
                        if (result[startIndex][startIndex + length] && max <= length + 1) {
                            max = length + 1;
                            resultString = s.substring(startIndex, startIndex + length + 1);
                        }
                    }
                }
            }
        }


        return resultString;
    }
}