package cn.aulati.test.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionAtOfficeTest {
    /**
     * test findNumbers
     */
    @Test
    void testFindNumbers1() {
        SolutionAtOffice solutionAtOffice = new SolutionAtOffice();

        int[] nums = {12,345,2,6,7896};
        int ret = solutionAtOffice.findNumbers(nums);

        assertEquals(2, ret);
    }

    @Test
    void testFindNumbers2() {
        SolutionAtOffice solutionAtOffice = new SolutionAtOffice();

        int[] nums = {555,901,482,1771};
        int ret = solutionAtOffice.findNumbers(nums);

        assertEquals(1, ret);
    }

    @Test
    void testFindNumbers3() {
        SolutionAtOffice solutionAtOffice = new SolutionAtOffice();

        int[] nums = {1,23,456,777,6666,777777};
        int ret = solutionAtOffice.findNumbers(nums);

        assertEquals(3, ret);
    }
}
