package cn.aulati.test.leetcode.solution;

/**
 * 最长回文子字符串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    /**
     * 返回最长回文子字符串，动态规划
     *
     * @param s 输入字符串
     * @return 最长回文子字符串
     */
    public static String longestPalindromeDP(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }

        // m(i, j) 表示下标从 i 至 j 的子字符串是否是回文的
        boolean[][] m = new boolean[len][len];

        m[0][0] = true;
        for (int i = 1; i < len; i++) {
            m[i][i] = true;
            m[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }

        int left = 0, right = 0, maxLength = 1;
        boolean isOver = false;

        for (int l = 3; l <= len; l++) {
            isOver = true;
            for (int i = 0; i < len - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = m[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                if (m[i][j]) {
                    if (j - i + 1 > maxLength) {
                        isOver = false;
                        maxLength = j - i + 1;
                        left = i;
                        right = j;
                    }
                }
            }
            if (isOver) {
                break;
            }
        }

        return s.substring(left, right);
    }

    /**
     * 返回最长回文子字符串
     *
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

            if (ss[i] == ss[i - 2]) {
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
