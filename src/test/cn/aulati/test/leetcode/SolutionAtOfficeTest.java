package cn.aulati.test.leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SolutionAtOfficeTest {

    /** An instance of tested class */
    private SolutionAtOffice _solution;

    /**
     * Initialize the instance of tested class
     */
    @BeforeAll
    void init() {
        _solution = new SolutionAtOffice();
    }

    @Test
    void testNextPermutation1() {
        int[] nums = {1, 2, 3};
        _solution.nextPermutation(nums);
        assertEquals("[1, 3, 2]", Arrays.toString(nums));
    }

    @Test
    void testNextPermutation2() {
        int[] nums = { 3, 2, 1 };
        _solution.nextPermutation(nums);
        assertEquals("[1, 2, 3]", Arrays.toString(nums));
    }

    @Test
    void testNextPermutation3() {
        int[] nums = {4,2,0,2,3,2,0};
        _solution.nextPermutation(nums);
        assertEquals("[4, 2, 0, 3, 0, 2, 2]", Arrays.toString(nums));
    }

    @Disabled
    @Test
    void testDivide1() {
        int ret = _solution.divide(10, 3);
        assertEquals(3, ret);
    }

    @Disabled
    @Test
    void testDivide2() {
        int ret = _solution.divide(7, -3);
        assertEquals(-2, ret);
    }

    @Disabled
    @Test
    void testDivide3() {
        int ret = _solution.divide(Integer.MAX_VALUE, 1);
        assertEquals(Integer.MAX_VALUE, ret);
    }

    @Disabled
    @Test
    void testDivide4() {
        int ret = _solution.divide(Integer.MIN_VALUE, 1);
        assertEquals(Integer.MIN_VALUE, ret);
    }

    /**
     * test findNumbers
     */
    @Disabled
    @Test
    void testFindNumbers1() {
        int[] nums = {12,345,2,6,7896};
        int ret = _solution.findNumbers(nums);

        assertEquals(2, ret);
    }

    @Disabled
    @Test
    void testFindNumbers2() {
        int[] nums = {555,901,482,1771};
        int ret = _solution.findNumbers(nums);

        assertEquals(1, ret);
    }

    @Disabled
    @Test
    void testFindNumbers3() {
        int[] nums = {1,23,456,777,6666,777777};
        int ret = _solution.findNumbers(nums);

        assertEquals(3, ret);
    }
}
