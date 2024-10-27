package 顺序刷;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangzhe14
 * @since 2024/8/19
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 */
public class _22_括号生成 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<TemStringBuilder> tem = new ArrayList<>();
        // n次循环
        for (int i = 0; i < n * 2; i++) {
            int size = tem.size();
            if (size == 0) {
                tem.add(new TemStringBuilder("(", 1));
                continue;
            }
            for (int j = 0; j < size; j++) {
                TemStringBuilder remove = tem.remove(0);
                if (remove.leftRemain > 0) {
                    tem.add(new TemStringBuilder(remove.value + ")", remove.leftRemain - 1));
                }
                if (remove.leftRemain < n) {
                    tem.add(new TemStringBuilder(remove.value + "(", remove.leftRemain + 1));
                }
            }
        }
        return tem.stream()
                .filter(temStringBuilder -> temStringBuilder.leftRemain == 0)
                .map(temStringBuilder -> temStringBuilder.value)
                .collect(Collectors.toList());
    }

    public static class TemStringBuilder {
        public String value;
        public int leftRemain;

        public TemStringBuilder(String value, int leftRemain) {
            this.value = value;
            this.leftRemain = leftRemain;
        }
    }
}