package cn.aulati.test.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Utils {
    /**
     * Convert matrix to string.
     * <p>
     * A matrix like this:
     * <blockquote><pre>
     *      int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
     * </pre></blockquote><p>
     * would be converted to a {@code String} as: {@code "[[1, 2, 3], [4, 5, 6], [7, 8, 9]]"}
     * 
     * @param matrix Input matrix.
     * @return String representation of the input matrix.
     */
    public static String matrixToString(int[][] matrix) {
        return matrixToString(matrix, false);
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
     * <p>Example:
     * <blockquote><pre>
     * list: [[1, 2, 3],
     *       [4, 5, 6]]
     * result:
     *       "[[1, 2, 3], [4, 5, 6]]"
     * </pre></blockquote>
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

    /**
     * Compare two given matrixes. The two matrixes are deemed equal if
     * they are comprised of the same rows, even if the rows are in different
     * order.
     * 
     * @param a One matrix.
     * @param b Another matrix.
     * @return True if the two matrixes have the same rows, even the rows'
     * order differs.
     */
    public static boolean compareMatrix(int[][] a, int[][] b) {
        if (a == b) return true;

        // a is null or b is null, but a != b
        if (a == null || b == null) return false;

        if (a.length == 0 && b.length == 0) return true;
        if (a.length != b.length) return false;

        if (a[0].length == 0 && b[0].length == 0) return true;
        if (a[0].length != b[0].length) return false;

        int n = a.length;
        boolean[] used = new boolean[n];

        // for each row in matrix a, we try to find a same row in matrix b
        for (int i = 0; i < n; i++) {
            int row = 0;

            // skim over the first element of matrix b, looking for the same element,
            // and then compare the two rows. If the two rows are the same, we mark
            // the row in matrix b as used, and go on with the next row of matrix a.
            while (row < n) {
                while (row < n && !used[row] && b[row][0] != a[i][0]) row++;
                
                boolean equal = Arrays.equals(b[row], a[i]);
                if (equal) {
                    used[row] = true;
                    break;
                } else {
                    row++;
                }
            }

            if (row == n) {
                // can't find the same row in b
                return false;
            }
        }
        
        return true;
    }

    /**
     * Compare two given lists of integer lists. The two lists are deemed equal if
     * they are comprised of the same integer lists, even if the lists are in different
     * order.
     * 
     * @param a One list of integer lists.
     * @param b Another list of integer lists.
     * @return True if the two lists of integer lists have the same lists, even the lists'
     * order differs.
     */
    public static boolean compareListOfList(List<List<Integer>> a, List<List<Integer>> b) {
        if (a == b) return true;

        // a is null or b is null, but a != b
        if (a == null || b == null) return false;

        if (a.isEmpty() && b.isEmpty()) return true;
        if (a.size() != b.size()) return false;

        // String[] as = a.stream().map(list -> Arrays.toString(list.stream().mapToInt(Integer::intValue).toArray())).toArray(String[]::new);
        String[] as = Utils.convertListToStringArray(a, Utils::integerListToString);
        Arrays.sort(as);
        String[] bs = Utils.convertListToStringArray(b, Utils::integerListToString);
        Arrays.sort(bs);

        return Arrays.compare(as, bs) == 0;
    }

    /**
     * Converts a list of {@code T} to an array. If no convert function is provided, the default {@link Object#toString() toString}
     * would be used.
     * 
     * @param <T> Type parameter.
     * @param list The list to be converted.
     * @param function Convert function, could be {@code null}
     * @return A String array.
     */
    public static <T> String[] convertListToStringArray(List<T> list, Function<T, String> function) {
        int n = list.size();
        String[] ret = new String[n];

        if (function == null) {
            // use the default toString() method
            for (int i = 0; i < n; i++) {
                ret[i] = Objects.toString(list.get(i));
            }
        } else {
            for (int i = 0; i < n; i++) {
                ret[i] = function.apply(list.get(i));
            }
        }

        return ret;
    }

    /**
     * Convert a list to a {@code String}. A blank String is returned
     * if {@code list} is null or is an empty list. In other cases,
     * The {@code Integer} list will be converted to an {@code int[]} array,
     * and {@link Arrays#toString(int[]) Arrays.toString} will be applied.
     * 
     * @param list A list of Integers.
     * @return String representation of these Integers.
     */
    public static String integerListToString(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }

        int[] tmp = list.stream().mapToInt(Integer::intValue).toArray();
        return Arrays.toString(tmp);
    }

    /**
     * Detect if a long number is a palindrome number.
     *
     * @param num A long number.
     * @return True if the given parameter is a palindrome number.
     */
    public static boolean isPalindrome(long num) {
        long ret = 0, i = num;

        while (i > 0) {
            ret = ret * 10 + i % 10;
            i /= 10;
        }

        return ret == num;
    }

    /**
     * Detect if a int number is a palindrome number.
     *
     * @param num A int number.
     * @return True if the given parameter is a palindrome number.
     */
    public static boolean isPalindrome(int num) {
        int ret = 0, i = num;

        while (i > 0) {
            ret = ret * 10 + i % 10;
            i /= 10;
        }

        return ret == num;
    }

    /**
     * Detect if a int number is a palindrome number.
     *
     * @param num A int number.
     * @return True if the given parameter is a palindrome number.
     */
    public static boolean isPalindrome(String num) {
        char[] c = num.toCharArray();

        int i = 0, j = c.length - 1;

        while (i < j) {
            if (c[i] == c[j]) {
                i++;
                j--;

            } else {
                return false;
            }
        }

        return true;
    }
}
