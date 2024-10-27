package 字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/10/10
 *
 * 这个题正解应该是，把strs变成a12b12这种格式，然后再去判断，这种格式能节约空间复杂度
 */
public class LCR_33_字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        // 特殊处理
        if (strs == null || strs.length == 0) {
            return result;
        }
        if (strs.length == 1) {
            List<String> tem = new ArrayList<>();
            tem.add(strs[0]);
            result.add(tem);
            return result;
        }
        boolean used[] = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            ArrayList<String> tem = new ArrayList<>();
            tem.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (!used[j] && isSame(strs[i], strs[j])) {
                    tem.add(strs[j]);
                    used[j] = true;
                }
            }
            result.add(tem);
        }
        return result;
    }

    // todo 是否是异位词分组的判断方法！！！这个还是得学习一下的！
    public static boolean isSame(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        if (first.length() == 0) {
            return true;
        }
        int[] dict = new int[26];
        for (int i = 0; i < first.length(); i++) {
            dict[first.charAt(i) - 'a']++;
        }
        for (int i = 0; i < second.length(); i++) {
            dict[second.charAt(i) - 'a']--;
            if (dict[second.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        for (int i = 0; i < dict.length; i++) {
            if (dict[i] != 0) {
                return false;
            }
        }
        return true;
    }
}