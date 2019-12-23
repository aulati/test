package cn.aulati.test.algorithm;

import java.util.Arrays;

public class Factorial {
    public static String factorial(int n) {
        String ret = "0";
        
        if (n < 100000) {
            ret = factorial100000(n);
        }
        
        return ret;
    }
    
    /**
     * 计算阶乘 n! = 1 * 2 * 3 * ...... * n
     * @param n 阶乘数
     * @return 结果数字字符串
     */
    public static String factorial100000(int n) {
        // 用一个 int 数组来保存结果，结果的低位在数组前面，高位依次添加至数组后面。
        // 每个 ret 数组的元素保存结果的 4 位数字，这样的话，相乘的时候不会超过 Integer.MAX_VALUE，
        // 也可以显著减少所需的元素个数（相对于每个int数组保存 1 位数字来说。）
        int[] ret = new int[100];
        int len = 1;
        ret[0] = 1;

        for (int i = 2; i <= n; i++) {
            // 进位
            int carry = 0;

            for (int j = 0; j < len; j++) {
                ret[j] = ret[j] * i + carry;
                
                carry = ret[j] / 10000;
                ret[j] = ret[j] % 10000;
            }

            if (carry > 0) {
                ret[len] = carry;
                len++;

                if (len == ret.length) {
                    ret = Arrays.copyOf(ret, ret.length << 1);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder(len << 2);
        sb.append(ret[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            if (ret[i] >= 1000) {
                sb.append(ret[i]);
            } else if (ret[i] >= 100) {
                sb.append("0");
                sb.append(ret[i]);
            } else if (ret[i] >= 10) {
                sb.append("00");
                sb.append(ret[i]);
            } else {
                sb.append("000");
                sb.append(ret[i]);
            }
        }
        
        return sb.toString();
    }

    /**
     * 计算阶乘 n! = 1 * 2 * 3 * ...... * n
     * @param n 阶乘数
     * @return 结果数字字符串
     */
    public static String factorialAll(int n) {
        // 用一个 int 数组来保存结果，结果的低位在数组前面，高位依次添加至数组后面。
        int[] ret = new int[100];
        int len = 1;
        ret[0] = 1;

        for (int i = 2; i <= n; i++) {
            // 进位
            int carry = 0;

            for (int j = 0; j < len; j++) {
                ret[j] = ret[j] * i + carry;

                carry = ret[j] / 10;
                ret[j] = ret[j] % 10;
            }

            if (carry > 0) {
                if (len >= ret.length - 10) {
                    ret = Arrays.copyOf(ret, ret.length << 1);
                }

                while (carry > 0) {
                    ret[len++] = carry % 10;
                    carry = carry / 10;
                }
            }
        }

        StringBuilder sb = new StringBuilder(len << 1);
        sb.append(ret[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            sb.append(ret[i]);
        }

        return sb.toString();
    }
}
