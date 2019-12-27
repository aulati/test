package cn.aulati.test.leetcode.solution;

import org.junit.jupiter.api.BeforeAll;
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
