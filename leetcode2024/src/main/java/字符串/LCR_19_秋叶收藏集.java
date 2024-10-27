package 字符串;

/**
 * @author yangzhe14
 * @since 2024/10/9
 */
public class LCR_19_秋叶收藏集 {
    public static void main(String[] args) {
        int rrryyyrryyyrr = minimumOperations("rrryyyrryyyrr");
        System.out.println(rrryyyrryyyrr);
    }

    public static int minimumOperations(String leaves) {
        int redNum = 0, yellowNum = 0;
        for (int i = 0; i < leaves.length(); i++) {
            if (leaves.charAt(i) == 'r') {
                redNum++;
            } else {
                yellowNum++;
            }
        }
        int[] redNumArr = new int[leaves.length()];
        redNumArr[0] = leaves.charAt(0) == 'r' ? 1 : 0;
        for (int i = 1; i < leaves.length(); i++) {
            redNumArr[i] = redNumArr[i - 1] + (leaves.charAt(i) == 'r' ? 1 : 0);
        }

        int result = Integer.MAX_VALUE;
        // i是最终可能的，yellow的开始位置，yellow必定连续
        for (int i = 1; i <= leaves.length() - 1 - yellowNum; i++) {
            int cur = redNumArr[i - 1] + redNumArr[leaves.length() - 1] - redNumArr[i + yellowNum - 1];
            result = Math.min(result, redNum - cur);
        }
        return result;
    }
}