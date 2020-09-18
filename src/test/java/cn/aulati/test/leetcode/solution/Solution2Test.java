package cn.aulati.test.leetcode.solution;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Solution2Test {

    private static Solution2 _solution;

    @BeforeAll
    static void init() {
        if (_solution == null) {
            _solution = new Solution2();
        }
    }

    @Test
    void testCanJumpII1() {
        int[] a = { 0, 1, 2, 3, 4 };
        boolean ret = _solution.canJumpII(a);
        assertFalse(ret);
    }

    @Test
    void testCanJumpII2() {
        int[] a = { 2, 3, 1, 1, 4 };
        boolean ret = _solution.canJumpII(a);
        assertTrue(ret);
    }

    @Test
    void testCanJumpII3() {
        int[] a = { 3, 2, 1, 0, 4 };
        boolean ret = _solution.canJumpII(a);
        assertFalse(ret);
    }

    @Test
    void testFindBestValue1() {
        int[] a = {4, 9, 3};
        int target = 10;

        int ret = _solution.findBestValue(a, target);

        assertEquals(3, ret);
    }

    @Test
    void testFindBestValue2() {
        int[] a = {2, 3, 5};
        int target = 10;

        int ret = _solution.findBestValue(a, target);

        assertEquals(5, ret);
    }

    @Test
    void testFindBestValue3() {
        int[] a = {60864,25176,27249,21296,20204};
        int target = 56803;

        int ret = _solution.findBestValue(a, target);

        assertEquals(11361, ret);
    }

    @Test
    void testMaxFreq1() {
        String s = "aaaa";

        int ret = _solution.maxFreq(s, 1, 3, 3);

        assertEquals(2, ret);
    }

    @Test
    void testMaxFreq2() {
        String s = "aabcabcab";

        int ret = _solution.maxFreq(s, 2, 2, 3);

        assertEquals(3, ret);
    }

    @Test
    void testMaxFreq3() {
        String s = "abcde";

        int ret = _solution.maxFreq(s, 2, 3, 3);

        assertEquals(0, ret);
    }

    @Test
    void testIsPossibleDivide1() {
        int[] nums = { 1,2,3,3,4,4,5,6 };
        int k = 4;

        boolean ret = _solution.isPossibleDivide(nums, k);

        assertTrue(ret);
    }

    @Test
    void testIsPossibleDivide2() {
        int[] nums = { 3,2,1,2,3,4,3,4,5,9,10,11 };
        int k = 3;

        boolean ret = _solution.isPossibleDivide(nums, k);

        assertTrue(ret);
    }

    @Test
    void testIsPossibleDivide3() {
        int[] nums = { 1,2,3,4 };
        int k = 3;

        boolean ret = _solution.isPossibleDivide(nums, k);

        assertFalse(ret);
    }
}
