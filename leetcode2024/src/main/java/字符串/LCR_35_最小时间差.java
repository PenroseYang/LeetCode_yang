package 字符串;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangzhe14
 * @since 2024/10/10
 */
public class LCR_35_最小时间差 {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("23:59");
        input.add("12:01");
        int minDifference = findMinDifference(input);
        System.out.println(minDifference);
    }

    public static int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() < 2) {
            return 0;
        }

        timePoints = timePoints.stream().sorted().collect(Collectors.toList());
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            result = Math.min(result, calculateDiff(timePoints.get(i - 1), timePoints.get(i)));
            if (result == 0) {
                return result;
            }
        }
        result = Math.min(result, calculateOverDay(timePoints.get(0), timePoints.get(timePoints.size() - 1)));
        return result;
    }

    // 非跨天场景
    public static int calculateDiff(String min, String max) {
        int result = 0;
        if (min.equals(max)) {
            return 0;
        }
        result += 60 * ((max.charAt(0) - min.charAt(0)) * 10 + (max.charAt(1) - min.charAt(1)));
        result += (max.charAt(3) - min.charAt(3)) * 10 + (max.charAt(4) - min.charAt(4));
        return result;
    }

    // 跨天场景   00:01   23:59
    public static int calculateOverDay(String min, String max) {
        int result = 0;
        if (min.equals(max)) {
            return 0;
        }
        result += 60 * ((min.charAt(0) - '0') * 10 + (min.charAt(1) - '0'));
        result += (min.charAt(3) - '0') * 10 + (min.charAt(4) - '0');

        result += 60 * (('2' - max.charAt(0)) * 10 + ('4' - max.charAt(1)));
        result += (-max.charAt(3) + '0') * 10 + (-max.charAt(4) + '0');
        return result;
    }
}