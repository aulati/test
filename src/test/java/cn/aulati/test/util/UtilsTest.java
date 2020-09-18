package cn.aulati.test.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {
    @Test
    void testMatrixToString1() {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        String ret = Utils.matrixToString(mat);

        assertEquals("[[1, 2, 3], [4, 5, 6], [7, 8, 9]]", ret);
    }

    @Test
    void testMatrixToString1T() {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        String ret = Utils.matrixToString(mat, true);

        assertEquals("[[1, 2, 3]" + System.lineSeparator()
                + ", [4, 5, 6]" + System.lineSeparator()
                + ", [7, 8, 9]]", ret);
    }

    @Test
    void testMatrixToStringEmpty() {
        int[][] mat = new int[0][0];

        String ret = Utils.matrixToString(mat);

        assertEquals("[[]]", ret);
    }

    @Test
    void testMatrixToStringEmptyT() {
        int[][] mat = new int[0][0];

        String ret = Utils.matrixToString(mat, true);

        assertEquals("[[]]", ret);
    }

    @Test
    void testMatrixToStringNull() {
        String ret = Utils.matrixToString(null);

        assertEquals("", ret);
    }

    @Test
    void testMatrixToStringNullT() {
        String ret = Utils.matrixToString(null, true);

        assertEquals("", ret);
    }
}
