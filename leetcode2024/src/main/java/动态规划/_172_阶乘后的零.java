package 动态规划;

/**
 * @author yangzhe14
 * @since 2024/7/13
 */
public class _172_阶乘后的零 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(200));
    }
    public static int trailingZeroes(int n) {
        return n / 5 + n / 25 +  (n / 125) +  (n / 625) + (n / 3125);
    }
}