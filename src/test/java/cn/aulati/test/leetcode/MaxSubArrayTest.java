package cn.aulati.test.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaxSubArrayTest {
    @Test
    void testMaxSubArray1() {
        int[] nums = { 1, 0, 5, -6, 3, 7, -1, 2, 5, 0, -6, 9 };
        int ret = MaxSubArray.maxSubArray(nums);
        assertEquals(19, ret);
    }

    @Test
    void testMaxSubArray2() {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int ret = MaxSubArray.maxSubArray(nums);
        assertEquals(6, ret);
    }

    @Test
    void testMaxSubArray3() {
        int[] nums = { 0 };
        int ret = MaxSubArray.maxSubArray(nums);
        assertEquals(0, ret);
    }

    @Test
    void testMaxSubArray4() {
        int[] nums = { -2147483647 };
        int ret = MaxSubArray.maxSubArray(nums);
        assertEquals(-2147483647, ret);
    }
}
