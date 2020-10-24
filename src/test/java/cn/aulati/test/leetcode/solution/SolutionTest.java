package cn.aulati.test.leetcode.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import cn.aulati.test.model.TreeNode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SolutionTest {
    
    /** a leetcode solution class */
    private Solution _solution;

    /**
     * Initialize.
     */
    @BeforeAll
    private void init() {
        _solution = new Solution();
    }

    @Test
    void testNumRollsToTarget1() {
        int dices = 1, faces = 6, target = 3;
        int ret = _solution.numRollsToTarget(dices, faces, target);
        assertEquals(1, ret);
    }
    
    @Test
    void testNumRollsToTarget2() {
        int dices = 2, faces = 6, target = 7;
        int ret = _solution.numRollsToTarget(dices, faces, target);
        assertEquals(6, ret);
    }
    
    @Test
    void testNumRollsToTarget3() {
        int dices = 2, faces = 5, target = 10;
        int ret = _solution.numRollsToTarget(dices, faces, target);
        assertEquals(1, ret);
    }
    
    @Test
    void testNumRollsToTarget4() {
        int dices = 1, faces = 2, target = 3;
        int ret = _solution.numRollsToTarget(dices, faces, target);
        assertEquals(0, ret);
    }
    
    @Test
    void testNumRollsToTarget5() {
        int dices = 20, faces = 30, target = 500;
        int ret = _solution.numRollsToTarget(dices, faces, target);
        assertEquals(357173588, ret);
    }

    @ParameterizedTest(name = "testMaxRepOpt{index}")
    @CsvSource({
        "ababa,     3",
        "aaabbaaa,  4",
        "aaaaaa,    6",
        "abcde,     1"
    })
    void testMaxRepOpt(String input, int expect) {
        // String input = "aaabbaaa";
        int ret = _solution.maxRepOpt1(input);
        assertEquals(expect, ret);
    }

    @Test
    void testLargest1BorderedSquare1() {
        int[][] x = {{1, 1, 0, 0}};
        int ret = _solution.largest1BorderedSquare(x);
        assertEquals(1, ret);
    }

    @Test
    void testLargest1BorderedSquare2() {
        int[][] x = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int ret = _solution.largest1BorderedSquare(x);
        assertEquals(9, ret);
    }

    @ParameterizedTest(name = "testAlphabetBoardPath{index}")
    @CsvSource({
        "leet,DDR!UURRR!!DDD!",
        "code,RR!DDRR!UUL!R!",
    })
    void testAlphabetBoardPath(String target, String expected) {
        String ret = _solution.alphabetBoardPath(target);
        assertEquals(expected, ret);
    }

    @Test
    void testLongestSubstring1() {
        String x = "I believe that something is wrong!";
        String y = "Everything OK?";
        String ret = _solution.longestSubstring(x, y);
        assertEquals("thing ", ret);
    }

    @Test
    void testLongestSubstring2() {
        String x = "this and that";
        String y = "this And that";
        String ret = _solution.longestSubstring(x, y);
        assertEquals("nd that", ret);
    }

    @Test
    void testRadixSort1() {
        String[] s = {"abcd", "accd", "acad", "adad"};
        _solution.radixSort(s, 4);
        assertEquals("[abcd, acad, accd, adad]", Arrays.toString(s));
    }
    
    @Test
    void testBuildTreeII() {
        int[] inorder = new int[]{ 9, 3, 15, 20, 7 };
        int[] postorder = new int[]{ 9, 15, 7, 20, 3 };

        TreeNode ret = _solution.buildTreeII(inorder, postorder);
        List<Integer> list = _solution.inorderTraversal(ret);

        assertEquals("[9, 3, 15, 20, 7]", Arrays.toString(list.toArray(new Integer[0])));
    }
    
    @Test
    void testBuildTree() {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};

        TreeNode ret = _solution.buildTree(preOrder, inOrder);
        List<Integer> list = _solution.inorderTraversal(ret);

        assertEquals("[9, 3, 15, 20, 7]", Arrays.toString(list.toArray(new Integer[0])));
    }
}
