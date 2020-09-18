package cn.aulati.test.util;

import java.util.Arrays;
import java.util.List;

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

    /**
     * Convert a List of List to String.
     * example:
     *   list: [
     *          [1, 2, 3],
     *          [4, 5, 6]
     *         ]
 *       result:
     *       "[[1, 2, 3], [4, 5, 6]]"
     *
     * @param list List of List
     * @return String representation
     */
    public static String listOfListToString(List<List<Integer>> list) {
        return listOfListToString(list, false);
    }

    /**
     * Convert a List of List to String, with each inner list on one row.
     * example:
     *   list: [
     *          [1, 2, 3],
     *          [4, 5, 6]
     *         ]
     *   result:
     *       "[[1, 2, 3]\n, [4, 5, 6]]"
     *
     * @param list List of List
     * @return String representation
     */
    public static String listOfListToString(List<List<Integer>> list, boolean oneRowOneLine) {
        if (list == null) {
            return "";
        }

        int len = list.size();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (len > 0) {
            sb.append(Arrays.toString(list.get(0).toArray(new Integer[0])));
            for (int i = 1; i < len; i++) {
                if (oneRowOneLine) {
                    sb.append(System.lineSeparator());
                }
                sb.append(", ");
                sb.append(Arrays.toString(list.get(i).toArray(new Integer[0])));
            }
        } else {
            sb.append("[]");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Swap the elements under specified indexes.
     * @param nums Array
     * @param i element index
     * @param j another element index
     */
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
