package 字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/10/10
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 */
public class LCR_78_复原IP地址 {

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() <= 4 || s.charAt(0) == '0') {
            return new ArrayList<>();
        }

        return null;
    }


}