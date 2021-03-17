package cn.aulati.test.leetcode;

import cn.aulati.test.model.ListNode;
import cn.aulati.test.util.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NightWorkTest {

    /** Solution class instance. */
    private NightWork nightWork;

    @BeforeAll
    void init() {
        nightWork = new NightWork();
    }

    @ParameterizedTest(name = "testRemoveKdigits{index} {argumentsWithNames}")
    @CsvSource({
        "1432219,3,1219",
        "10200,1,200",
        "10,2,0",
        "10,1,0"
    })
    void testRemoveKdigits(String num, int k, String expected) {
        String result = nightWork.removeKdigits(num, k);
        assertEquals(expected, result);
    }

    @Test
    void testRestoreIpAddresses1() {
        String s = "0000";
        List<String> result = nightWork.restoreIpAddresses(s);
        assertEquals(1, result.size());
        assertEquals("0.0.0.0", result.get(0));
    }

    @Test
    void testRestoreIpAddresses2() {
        String s = "255255111350";
        List<String> result = nightWork.restoreIpAddresses(s);
        assertEquals(0, result.size());
    }

    @Test
    void testRestoreIpAddresses3() {
        String s = "25525511135";
        List<String> result = nightWork.restoreIpAddresses(s);

        assertEquals("[255.255.11.135, 255.255.111.35]", result.toString());
    }

    @Test
    void testRestoreIpAddresses4() {
        String s = "101023";
        List<String> result = nightWork.restoreIpAddresses(s);

        assertEquals("[1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]", result.toString());
    }

    @DisplayName("testSubsets: Single element array")
    @Test
    void testSubsets1() {
        int[] nums = {5};
        String expected = "[[], [5]]";
        List<List<Integer>> result = nightWork.subsets(nums);
        String resultString = Utils.listOfListToString(result);
        assertEquals(expected, resultString);

        result = nightWork.subsetsRecursive(nums);
        resultString = Utils.listOfListToString(result);
        assertEquals(expected, resultString);
    }

    @Test
    void testSubsets2() {
        int[] nums = {1, 2, 3};
        String expected = "[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]";
        List<List<Integer>> result = nightWork.subsets(nums);
        String resultString = Utils.listOfListToString(result);
        assertEquals(expected, resultString);

        result = nightWork.subsetsRecursive(nums);
        resultString = Utils.listOfListToString(result);
        assertEquals(expected, resultString);
    }

    @Test
    void testLongestWPI0() {
        int[] a = { 6, 6, 9 };
        int ret = nightWork.longestWPI(a);
        assertEquals(1, ret);
    }

    @Test
    void testLongestWPI1() {
        int[] a = { 6, 9, 9 };
        int ret = nightWork.longestWPI(a);
        assertEquals(3, ret);
    }

    @Test
    void testLongestWPI2() {
        int[] a = { 9, 9, 6 };
        int ret = nightWork.longestWPI(a);
        assertEquals(3, ret);
    }

    @Test
    void testLongestWPI3() {
        int[] a = { 9, 9, 6, 0, 6, 6, 9 };
        int ret = nightWork.longestWPI(a);
        assertEquals(3, ret);
    }

    @Test
    void testLongestWPI4() {
        int[] a = { 6 };
        int ret = nightWork.longestWPI(a);
        assertEquals(0, ret);
    }

    @Test
    void testLongestWPI5() {
        int[] a = { 6, 6 };
        int ret = nightWork.longestWPI(a);
        assertEquals(0, ret);
    }

    @Test
    void testLongestWPI6() {
        int[] a = { 9 };
        int ret = nightWork.longestWPI(a);
        assertEquals(1, ret);
    }

    @Test
    void testLongestWPI7() {
        int[] a = { 9, 9 };
        int ret = nightWork.longestWPI(a);
        assertEquals(2, ret);
    }

    @Test
    void testRotateRight1() {
        int[] a = { 1, 2, 3, 4, 5};
        ListNode list = ListNode.fromArray(a);

        ListNode ret = nightWork.rotateRight(list, 2);

        assertEquals("4->5->1->2->3", ret.toString());
    }
    
    @Test
    void testRotateRight2() {
        int[] a = { 1, 2, 3};
        int k = 4;
        ListNode list = ListNode.fromArray(a);

        ListNode ret = nightWork.rotateRight(list, k);

        assertEquals("3->1->2", ret.toString());
    }
    
    @Test
    void testRotateRight3() {
        int[] a = { 1 };
        int k = 1;
        ListNode list = ListNode.fromArray(a);

        ListNode ret = nightWork.rotateRight(list, k);

        assertEquals("1", ret.toString());
    }
    
    @Test
    void testRotateRight4() {
        int[] a = { 1 };
        int k = 3;
        ListNode list = ListNode.fromArray(a);

        ListNode ret = nightWork.rotateRight(list, k);

        assertEquals("1", ret.toString());
    }
    
    @Test
    void testRotateRight5() {
        int[] a = { 1, 2, 3, 4};
        int k = 4;
        ListNode list = ListNode.fromArray(a);

        ListNode ret = nightWork.rotateRight(list, k);

        assertEquals("1->2->3->4", ret.toString());
    }

    @Test
    void testGenerateMatrix1() {
        int n = 1;
        int[][] matrix = nightWork.generateMatrix(n);

        int[][] expected = {{1}};

        assertTrue(Utils.compareMatrix(expected, matrix));
    }

    @Test
    void testGenerateMatrix2() {
        int n = 2;
        int[][] matrix = nightWork.generateMatrix(n);

        int[][] expected = {{1, 2}, {4, 3}};

        assertTrue(Utils.compareMatrix(expected, matrix));
    }

    @Test
    void testGenerateMatrix3() {
        int n = 3;
        int[][] matrix = nightWork.generateMatrix(n);

        int[][] expected = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};

        assertTrue(Utils.compareMatrix(expected, matrix));
    }

    @Test
    void testDistinctEchoSubstrings1() {
        String text = "abcabcabc";

        int ret = nightWork.distinctEchoSubstrings(text);

        assertEquals(3, ret);
    }

    @Test
    void testDistinctEchoSubstrings2() {
        String text = "leetcodeleetcode";

        int ret = nightWork.distinctEchoSubstrings(text);

        assertEquals(2, ret);
    }

    @Test
    void testDistinctEchoSubstrings3() {
        String text = "tiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtidux";

        int ret = nightWork.distinctEchoSubstrings(text);

        assertEquals(316, ret);
    }

    @Test
    void testXorQueries1() {
        int[] arr = {1,3,4,8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};

        int[] ret = nightWork.xorQueries(arr, queries);

        assertEquals("[2, 7, 14, 8]", Arrays.toString(ret));
    }

    @Test
    void testXorQueries2() {
        int[] arr = {4,8,2,10};
        int[][] queries = {{2, 3}, {1, 3}, {0, 0}, {0, 3}};

        int[] ret = nightWork.xorQueries(arr, queries);

        assertEquals("[8, 0, 4, 4]", Arrays.toString(ret));
    }

    @Test
    void testFreqAlphabets1() {
        String s = "10#11#12";

        String ret = nightWork.freqAlphabets(s);

        assertEquals("jkab", ret);
    }

    @Test
    void testFreqAlphabets2() {
        String s = "1326#";

        String ret = nightWork.freqAlphabets(s);

        assertEquals("acz", ret);
    }

    @Test
    void testFreqAlphabets3() {
        String s = "25#";

        String ret = nightWork.freqAlphabets(s);

        assertEquals("y", ret);
    }

    @Test
    void testFreqAlphabets4() {
        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";

        String ret = nightWork.freqAlphabets(s);

        assertEquals("abcdefghijklmnopqrstuvwxyz", ret);
    }

    @Test
    void testGroupThePeople1() {
        int[] groupSizes = { 3,3,3,3,3,1,3 };

        List<List<Integer>> ret = nightWork.groupThePeople(groupSizes);

        String s = Utils.listOfListToString(ret);
        assertEquals("[[5], [0, 1, 2], [3, 4, 6]]", s);
    }

    @Test
    void testGroupThePeople2() {
        int[] groupSizes = { 2,1,3,3,3,2 };

        List<List<Integer>> ret = nightWork.groupThePeople(groupSizes);

        String s = Utils.listOfListToString(ret);
        assertEquals("[[1], [0, 5], [2, 3, 4]]", s);
    }

    @Test
    void testSmallestDivisor1() {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        int ret = nightWork.smallestDivisor(nums, threshold);

        assertEquals(5, ret);
    }

    @Test
    void testSmallestDivisor2() {
        int[] nums = { 2,3,5,7,11 };
        int threshold = 11;

        int ret = nightWork.smallestDivisor(nums, threshold);

        assertEquals(3, ret);
    }

    @Test
    void testSmallestDivisor3() {
        int[] nums = {19};
        int threshold = 5;

        int ret = nightWork.smallestDivisor(nums, threshold);

        assertEquals(4, ret);
    }

    @Test
    void testRemoveCoveredIntervals1() {
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};

        int ret = nightWork.removeCoveredIntervals(intervals);

        assertEquals(2, ret);
    }

    @Test
    void testRemoveCoveredIntervals2() {
        int[][] intervals = {{3,10},{4,10},{5,11}};

        int ret = nightWork.removeCoveredIntervals(intervals);

        assertEquals(2, ret);
    }

    @Test
    void testRemoveCoveredIntervals3() {
        int[][] intervals = {{3,10}};

        int ret = nightWork.removeCoveredIntervals(intervals);

        assertEquals(1, ret);
    }
}
