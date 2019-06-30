package cn.aulati.test.leatcode.solution;

/**
 * 最长回文子字符串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 */
public class LongestPalindrome {

    /**
     * 返回最长回文子字符串，动态规划
     * @param s 输入字符串
     * @return 最长回文子字符串
     */
    public static String longestPalindromeDynamicPlan(String s) {
        return "";
    }

    /**
     * 返回最长回文子字符串
     * @param s 输入字符串
     * @return 最长回文子字符串
     */
    public static String longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        if (s == null || "".equals(s) || s.length() == 1) {
            return s;
        }

        int idxLeft = 0, idxRight = 1, curLen = 1, len = s.length();
        if (ss[0] == ss[1]) {
            idxRight = 2;
            curLen = 2;
        }

        int posL, posR;
        for (int i = 2; i < len; i++) {
            if (ss[i] == ss[i - 1]) {
                // 回文字符串中心是 aa 形式
                posL = i - 2;
                posR = i + 1;
                while (posL >= 0 && posR < len && ss[posL] == ss[posR]) {
                    posL--;
                    posR++;
                }

                if (posR - posL - 1 > curLen) {
                    idxLeft = posL + 1;
                    idxRight = posR;
                    curLen = posR - posL - 1;
                }
            }

            if (ss[i] == ss[i-2]) {
                // 回文字符串中心是 aba 形式
                posL = i - 3;
                posR = i + 1;
                while (posL >= 0 && posR < len && ss[posL] == ss[posR]) {
                    posL--;
                    posR++;
                }

                if (posR - posL - 1 > curLen) {
                    idxLeft = posL + 1;
                    idxRight = posR;
                    curLen = posR - posL - 1;
                }
            }
        }

        return s.substring(idxLeft, idxRight);
    }
}
