package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/27
 * <p>
 * 将非负整数 num 转换为其对应的英文表示。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 * 示例 2：
 * <p>
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 * 示例 3：
 * <p>
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 提示：
 * <p>
 * 0 <= num <= 231 - 1
 * <p>
 * todo 也不多写，就写一下上面这几道例题吧
 * 还是野鸡了一下，基本上知道考察什么了，就随便写写吧
 */
public class _273_整数转换英文表示 {
    public static void main(String[] args) {
        System.out.println(numberToWords(12345));
    }

    public static String numberToWords(int num) {
        if (num < 1000) {
            return calculateHundredString(num);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int hundredNum = num % 1000;
            String thousandString = calculateHundredString((num / 1000) % 1000);
            stringBuilder.append(thousandString);
            stringBuilder.append(" thousand");
            if (hundredNum > 0) {
                String hundredString = calculateHundredString(hundredNum);
                stringBuilder.append(" ");
                stringBuilder.append(hundredString);
            }
            return stringBuilder.toString();
        }
    }

    public static String calculateHundredString(int hundredNum) {
        int hundred = hundredNum / 100;
        int ten = (hundredNum - hundred * 100) / 10;
        int num = hundredNum - hundred * 100 - ten * 10;

        StringBuilder stringBuilder = new StringBuilder();
        if (hundred > 0) {
            stringBuilder.append(hundred);
            stringBuilder.append("hundred");
        }
        if (ten > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(ten);
            stringBuilder.append("ty ");
        }
        if (num > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }
}