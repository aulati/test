package cn.aulati.test.util;

import java.util.Arrays;

public class Utils {
    public static String matrixToString(int[][] mat) {
        return matrixToString(mat, false);
    }

    public static String matrixToString(int[][] mat, boolean oneRowOneLine) {
        if (mat == null) {
            return "";
        }

        int len = mat.length;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (mat.length > 0) {
            sb.append(Arrays.toString(mat[0]));
            for (int i = 1; i < len; i++) {
                if (oneRowOneLine) {
                    sb.append(System.lineSeparator());
                }
                sb.append(", ");
                sb.append(Arrays.toString(mat[i]));
            }
        } else {
            sb.append("[]");
        }
        sb.append("]");
        return sb.toString();
    }
}
