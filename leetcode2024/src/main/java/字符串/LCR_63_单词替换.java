package 字符串;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yangzhe14
 * @since 2024/10/10
 */
public class LCR_63_单词替换 {
    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dict, sentence));
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        if (dictionary == null || dictionary.size() == 0 || sentence == null || sentence.length() == 0) {
            return sentence;
        }
        Set<String> dict = new HashSet<>();
        for (int i = 0; i < dictionary.size(); i++) {
            dict.add(dictionary.get(i));
        }

        StringBuilder result = new StringBuilder();
        int right = -1;
        StringBuilder tem = new StringBuilder();
        while (right <= sentence.length() - 2) {
            right++;
            // 当前词未找到匹配项
            if (sentence.charAt(right) == ' ') {
                if (result.length() == 0) {
                    result.append(tem);
                } else {
                    result.append(" ");
                    result.append(tem);
                }
                tem = new StringBuilder();
            } else {
                tem.append(sentence.charAt(right));
                if (dict.contains(tem.toString())) {
                    if (result.length() == 0) {
                        result.append(tem);
                    } else {
                        result.append(" ");
                        result.append(tem);
                    }

                    // right 一直右移
                    while (right <= sentence.length() - 1 && sentence.charAt(right) != ' ') {
                        right++;
                    }
                    tem = new StringBuilder();
                }
            }
        }

        /**
         * todo 这个题，还是代码能力不行啊
         * 每次tem合并进去的时候tem得更新，还得考虑result的现状，要不要加这个空格
         */
        if(tem.length() > 0){
            if (result.length() == 0) {
                result.append(tem);
            } else {
                result.append(" ");
                result.append(tem);
            }
        }
        return result.toString();
    }
}