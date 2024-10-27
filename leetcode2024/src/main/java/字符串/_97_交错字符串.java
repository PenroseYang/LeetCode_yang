package 字符串;

/**
 * @author yangzhe14
 * @since 2024/9/16
 * <p>
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * <p>
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 * 提示：
 * <p>
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 * 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?
 */
public class _97_交错字符串 {

    public static void main(String[] args) {
        System.out.println(isInterleave("aabccabc",
                "dbbabc",
                "aabdbbccababcc"));
    }

    // 判断是不是由S1和S2一起组成的S3
    public static boolean isInterleave(String s1, String s2, String target) {
        if (s1 == null || s2 == null || target == null || s1.length() + s2.length() != target.length()) {
            return false;
        }
        // boolean[s1的index+1][s2的index+1]，如果[0][0]就表示没使用到这里的
        boolean[][] tem = new boolean[target.length() + 1][target.length() + 1];
        tem[0][0] = true;

        // 要拼接的长度是多长
        for (int i = 0; i < target.length(); i++) {
            // s1的长度有多长，让s1做最后一位
            for (int j = 0; j <= i; j++) {
                // s1做最后一位
                // todo 一个是状态机关系，另一个是不能覆盖当前的值，需要由当前值和本次要更改的值一起做操作比较的
                if (j < s1.length() && target.charAt(i) == s1.charAt(j)) {
                    tem[j + 1][i - j] = tem[j + 1][i - j] || tem[j][i - j];
                }
                // s2做最后一位
                if (j < s2.length() && target.charAt(i) == s2.charAt(j)) {
                    tem[i - j][j + 1] = tem[i - j][j + 1] || tem[i - j][j];
                }
            }
        }

        for (int i = 0; i <= target.length(); i++) {
            if (tem[i][target.length() - i]) {
                return true;
            }
        }
        return false;
    }
}