package cn.aulati.test.leetcode;

import cn.aulati.test.util.Utils;
import jdk.jshell.execution.Util;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NightWorkTest {

    private NightWork nightWork;

    @BeforeAll
    void init() {
        nightWork = new NightWork();
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
