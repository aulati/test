package cn.aulati.test.leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NightWorkTest {

    private NightWork nightWork;

    @BeforeAll
    void init() {
        nightWork = new NightWork();
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

    @Disabled
    @Test
    void testRemoveCoveredIntervals1() {
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};

        int ret = nightWork.removeCoveredIntervals(intervals);

        assertEquals(2, ret);
    }

    @Disabled
    @Test
    void testRemoveCoveredIntervals2() {
        int[][] intervals = {{3,10},{4,10},{5,11}};

        int ret = nightWork.removeCoveredIntervals(intervals);

        assertEquals(2, ret);
    }

    @Disabled
    @Test
    void testRemoveCoveredIntervals3() {
        int[][] intervals = {{3,10}};

        int ret = nightWork.removeCoveredIntervals(intervals);

        assertEquals(1, ret);
    }
}
