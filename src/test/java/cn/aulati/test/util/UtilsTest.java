package cn.aulati.test.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testCompareMatrix1() {
        assertTrue(Utils.compareMatrix(null, null));
    }

    @Test
    void testCompareMatrix2() {
        int[][] a = {};
        assertFalse(Utils.compareMatrix(a, null));
    }

    @Test
    void testCompareMatrix3() {
        int[][] a = {};
        assertFalse(Utils.compareMatrix(null, a));
    }

    @Test
    void testCompareMatrix4() {
        int[][] a = {};
        int[][] b = {};
        assertTrue(Utils.compareMatrix(a, b));
    }
    
    @Test
    void testCompareMatrix5() {
        int[][] a = {{}};
        int[][] b = {{}};
        assertTrue(Utils.compareMatrix(a, b));
    }
    
    @Test
    void testCompareMatrix6() {
        int[][] a = {{0}};
        int[][] b = {{0}};
        assertTrue(Utils.compareMatrix(a, b));
    }
    
    @Test
    void testCompareMatrix7() {
        int[][] a = {{0, 1, 2}, {3, 4, 5}};
        int[][] b = {{3, 4, 5}, {0, 1, 2}};
        assertTrue(Utils.compareMatrix(a, b));
    }
    
    @Test
    void testCompareMatrix8() {
        int[][] a = {{0, 1, 2}, {3, 4, 5}, {3, 4, 4}, {3, 4, 6}};
        int[][] b = {{3, 4, 5}, {0, 1, 2}, {3, 4, 6}, {3, 4, 4}};
        assertTrue(Utils.compareMatrix(a, b));
    }
    
    @Test
    void testCompareMatrix9() {
        int[][] a = {{0, 1, 2}, {3, 4, 5}};
        int[][] b = {{3, 4, 4}, {0, 1, 2}};
        assertFalse(Utils.compareMatrix(a, b));
    }
}
