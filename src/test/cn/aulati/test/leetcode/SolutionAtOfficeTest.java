package cn.aulati.test.leetcode;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Disabled
    @Test
    void testExist1() {
        char[][] board = {{'A','B','C','E'}
                        , {'S','F','C','S'}
                        , {'A','D','E','E'}};
        String word = "ABCCED";

        boolean ret = _solution.exist(board, word);

        assertTrue(ret);
    }

    @Disabled
    @Test
    void testExist2() {
        char[][] board = {{'A','B','C','E'}
                        , {'S','F','E','S'}
                        , {'A','D','E','E'}};
        String word = "ABCESEEEFS";

        boolean ret = _solution.exist(board, word);

        assertTrue(ret);
    }

    @Test
    void testGuessNumber1() {
        int n = 2126753390;
        int target = 1702766719;

        SolutionAtOffice.guessTarget = target;
        int ret = _solution.guessNumber(n);
        assertEquals(target, ret);
    }

    @Test
    void testGuessNumber4() {
        int n = 10;
        int target = 6;

        SolutionAtOffice.guessTarget = target;
        int ret = _solution.guessNumber(n);
        assertEquals(target, ret);
    }

    @Disabled
    @Test
    void testGuessNumber2() {
        int n = 3;
        int target = 1;

        SolutionAtOffice.guessTarget = target;
        int ret = _solution.guessNumber(n);
        assertEquals(target, ret);
    }

    @Disabled
    @Test
    void testGuessNumber3() {
        int n = 3;
        int target = 3;

        SolutionAtOffice.guessTarget = target;
        int ret = _solution.guessNumber(n);
        assertEquals(target, ret);
    }

    @Disabled
    @Test
    void testThreeSum1() {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> ret = _solution.threeSum(nums);

        StringBuilder sb = new StringBuilder("[-1, -1, 2][-1, 0, 1]");
        for (List<Integer> list : ret) {
            String val = Arrays.toString(list.toArray());
            int start = sb.indexOf(val);
            if (start < 0) {
                Assertions.fail("Result contains incorrect list: " + val);
            }

            sb.replace(start, val.length() + start, "");
        }

        assertEquals("", sb.toString(), "Result does not contains list(s): " + sb.toString());
    }

    @Disabled
    @Test
    void testNextPermutation1() {
        int[] nums = {1, 2, 3};
        _solution.nextPermutation(nums);
        assertEquals("[1, 3, 2]", Arrays.toString(nums));
    }

    @Disabled
    @Test
    void testNextPermutation2() {
        int[] nums = { 3, 2, 1 };
        _solution.nextPermutation(nums);
        assertEquals("[1, 2, 3]", Arrays.toString(nums));
    }

    @Disabled
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
