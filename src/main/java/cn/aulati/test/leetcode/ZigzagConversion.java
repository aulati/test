package cn.aulati.test.leetcode;

public class ZigzagConversion {
    /**
     * 逐字符确定其所应在的行，并添加到该行的分类中
     * @param s 输入字符串
     * @param numRows Z字的行数
     * @return Z字排列后的字符串
     */
    public static String convert2(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        StringBuffer[] list = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            list[i] = new StringBuffer();
        }

        int curPos = 0, curRow = 0, len = s.length();
        boolean goingDown = false;

        while (curPos < len) {
            list[curRow].append(s.charAt(curPos++));
            if (curRow == 0 || curRow == numRows -1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            ret.append(list[i]);
        }

        return ret.toString();
    }

    /**
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }

        if (numRows <= 1) {
            return s;
        }

        char[][] ss = new char[numRows][len];

        int i = 0, j = 0, curPos = 0;

        while (true) {
            // 竖行
            while (i < numRows && curPos < len) {
                ss[i++][j] = s.charAt(curPos++);
            }

            // 若因字符串已数完，则跳出循环
            if(curPos == len) {
                break;
            }

            i -= 2;
            j++;

            // Z字形上升至第0行
            while (i > 0 && curPos < len) {
                ss[i--][j++] = s.charAt(curPos++);
            }

            // 若因字符串已数完，则跳出循环
            if(curPos == len) {
                break;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (i = 0; i < numRows; i++) {
            for (int k = 0; k <= j; k++) {
                if (ss[i][k] != 0) {
                    sb.append(ss[i][k]);
                }
            }
        }

        return sb.toString();
    }
}
