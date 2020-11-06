package cn.aulati.test.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    void testCompareListOfList1() {
        Integer[] a = {0};
        Integer[] b = {0};

        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(Arrays.asList(a));

        List<List<Integer>> list2 = new ArrayList<>();
        list2.add(Arrays.asList(b));

        assertTrue(Utils.compareListOfList(list1, list2));
    }

    @Test
    void testCompareListOfList2() {
        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(null);

        List<List<Integer>> list2 = new ArrayList<>();
        list2.add(new ArrayList<>());

        assertTrue(Utils.compareListOfList(list1, list2));
        assertTrue(Utils.compareListOfList(list2, list1));
    }

    @Test
    void testCompareListOfList3() {
        List<List<Integer>> list1 = new ArrayList<>();
        assertFalse(Utils.compareListOfList(list1, null));
        assertFalse(Utils.compareListOfList(null, list1));
    }

    @Test
    void testCompareListOfList4() {
        assertTrue(Utils.compareListOfList(null, null));
    }

    @Test
    void testCompareListOfList5() {
        assertTrue(Utils.compareListOfList(null, null));
    }

    @Test
    void testCompareListOfList6() {
        Integer[] a1 = {0};
        Integer[] a2 = {0};
        Integer[] b1 = {0, 1};
        Integer[] b2 = {0, 1};
        Integer[] c1 = {0, 1};

        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(Arrays.asList(a1));
        list1.add(Arrays.asList(b1));
        list1.add(Arrays.asList(c1));

        List<List<Integer>> list2 = new ArrayList<>();
        list2.add(Arrays.asList(a2));
        list2.add(Arrays.asList(b2));

        assertFalse(Utils.compareListOfList(list1, list2));
        assertFalse(Utils.compareListOfList(list2, list1));
    }

    @Test
    void testCompareListOfList7() {
        Integer[] a1 = {0};
        Integer[] a2 = {0};
        Integer[] b1 = {0, 1};
        Integer[] b2 = {0, 1};

        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(Arrays.asList(a1));
        list1.add(Arrays.asList(b1));

        List<List<Integer>> list2 = new ArrayList<>();
        list2.add(Arrays.asList(b2));
        list2.add(Arrays.asList(a2));

        assertTrue(Utils.compareListOfList(list1, list2));
        assertTrue(Utils.compareListOfList(list2, list1));
    }
}
