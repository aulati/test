package cn.aulati.test.leetcode.solution;

import cn.aulati.test.model.ListNode;
import cn.aulati.test.util.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

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
    void testMaxFreq4() {
        String s = "bekdfggeafgajehfjkeaifchakbhfkgbegbghdfihkigdiiaichckkjfhcicejciegdbhejbfcjccaiehhdbaeaikjgjdfefiheegbh";
        int maxLetters = 7,
            minSize = 4,
            maxSize = 23;

        int ret = _solution.maxFreq(s, maxLetters, minSize, maxSize);

        assertEquals(1, ret);
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

    @Test
    void testIsPossibleDivide4() {
        int[] nums = { 3,2,1,2,3,1 };
        int k = 3;

        boolean ret = _solution.isPossibleDivide(nums, k);

        assertTrue(ret);
    }

    @Test
    void testShortestpath() {
        int[][] grid = {{0}};
        int k = 1;

        int ret = _solution.shortestPath(grid, k);

        assertEquals(0, ret);
    }

    @Test
    void testCanReach() {
        int[] arr = {0,3,0,6,3,3,4};
        int start = 6;

        boolean ret = _solution.canReach(arr, start);

        assertTrue(ret);
    }

    @Test
    void testMaxSideLength() {
        int[][] input = {{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2}};
        int threshold = 18000;

        int ret = _solution.maxSideLength(input, threshold);

        assertEquals(5, ret);
    }

    @Test
    void testSequentialDigits() {
        int low = 58, high = 155;

        List<Integer> ret = _solution.sequentialDigits(low, high);

        int[] retToInt = ret.stream().mapToInt(Integer::intValue).toArray();
        int[] ans = { 67, 78, 89, 123 };

        assertArrayEquals(ans, retToInt);
    }

    @Test
    void testNumWays() {
        int steps = 27, arrLen = 7;

        int ret = _solution.numWays(steps, arrLen);

        assertEquals(127784505, ret);
    }

    @Test
    void testMaxSumDivThree() {
        int[] nums = {1, 2, 3, 4, 4};

        int ret = _solution.maxSumDivThree(nums);

        assertEquals(12, ret);
    }

    @Test
    void testShiftGrid() {
        int[][] grid = {{1}};
        int k = 100;
        List<List<Integer>> ret = _solution.shiftGrid(grid, k);
        String retStr = Utils.listOfListToString(ret);
        assertEquals("[[1]]", retStr);
    }

    @ParameterizedTest(name = "testMyAtoi{index}")
    @CsvSource({
        "-91283472332,      -2147483648",
        "91283472332,       2147483647",
        "-2147483647,       -2147483647",
        "-2147483648,       -2147483648",
        "2147483647,        2147483647",
        "2147483648,        2147483647",
        "+000000123456,     123456",
        "   403 with word,  403",
        "word and 922,      0",
        "42,                42"
    })
    void testMyAtoi(String input, int expected) {
        int ret = _solution.myAtoi(input);
        assertEquals(expected, ret);
    }

    @Test
    void testLetterCombinations1() {
        String s = "23";
        List<String> ret = _solution.letterCombinations(s);
        String retStr = Arrays.toString(ret.toArray());
        assertEquals("[ad, ae, af, bd, be, bf, cd, ce, cf]", retStr);
    }

    @Test
    void testLetterCombinations2() {
        String s = "79";
        List<String> ret = _solution.letterCombinations(s);
        String retStr = Arrays.toString(ret.toArray());
        assertEquals("[pw, px, py, pz, qw, qx, qy, qz, rw, rx, ry, rz, sw, sx, sy, sz]", retStr);
    }

    @ParameterizedTest(name = "testNthUglyNumberContest{index}")
    @CsvSource({
        "1000000000, 2, 217983653, 336916467, 1999999984"
    })
    void testNthUglyNumberContest(int n, int a, int b, int c, int expected) {
        int ret = _solution.nthUglyNumber(n, a, b, c);
        assertEquals(expected, ret);
    }

    @Test
    void testMinimumAbsDifference() {
        int[] a = {1, 2, 3, 4};
        List<List<Integer>> ret = _solution.minimumAbsDifference(a);
        String retStr = Utils.listOfListToString(ret);
        assertEquals("[[1, 2], [2, 3], [3, 4]]", retStr);
    }

    @Test
    void testReverseLists1() {
        int[] a = {1};
        ListNode h = ListNode.fromArray(a);

        ListNode ret = _solution.reverseLists(h);
        
        assertEquals("1", ListNode.printString(ret));
    }

    @Test
    void testReverseLists2() {
        int[] a = {1, 3};
        ListNode h = ListNode.fromArray(a);

        ListNode ret = _solution.reverseLists(h);
        
        assertEquals("3->1", ListNode.printString(ret));
    }

    @Test
    void testReverseLists3() {
        int[] a = {1, 2, 3, 4, 5};
        ListNode h = ListNode.fromArray(a);

        ListNode ret = _solution.reverseLists(h);
        
        assertEquals("5->4->3->2->1", ListNode.printString(ret));
    }

    @ParameterizedTest(name = "testReverseAlphabets{index}")
    @CsvSource({
        "ab-cd-,dc-ba-",
        "abcd-EF-ga,agFE-dc-ba"
    })
    void testReverseAlphabets(String s, String expected) {
        String ret = _solution.reverseAlphabets(s);
        assertEquals(expected, ret);
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
    void testNumSmallerByFrequency() {
        String[] s1 = {"baaaaa","abbaaaab","bbbaabaaba"};
        String[] s2 = {"bbbbaaa","bb","aaaab","abbabbbbab","bbb","a","aa","aabaaabab","aababab","baa","aaaba","aabaab"
                ,"aa","bbabba","baa","abaaaabbb","babaa","aababaabab","baaaa","baaabbb","aabaab","bbabbab","b","aab"};

        int[] ret = _solution.numSmallerByFrequency(s1, s2);

        assertEquals("[2, 2, 2]", Arrays.toString(ret));
    }

    @ParameterizedTest(name = "testCountNumbersWithUniqueDigits{index}")
    @CsvSource({
        "2,     91",
        "10,    8877691"
    })
    void testCountNumbersWithUniqueDigits(int n, int expected) {
        int ret = _solution.countNumbersWithUniqueDigits(n);
        assertEquals(expected, ret);
    }

    @ParameterizedTest(name = "testNthUglyNumber{index}")
    @CsvSource({
        "1,  1",
        "7,  8",
        "10, 12"
    })
    void testNthUglyNumber(int n, int expected) {
        int ret = _solution.nthUglyNumber(n);
        assertEquals(expected, ret);
    }

    @Test
    void testMergeTwoLists1() {
        int[] a1 = {1, 2, 4};
        ListNode l1 = ListNode.fromArray(a1);

        int[] a2 = {1, 3, 4};
        ListNode l2 = ListNode.fromArray(a2);

        ListNode ret = _solution.mergeTwoLists(l1, l2);

        assertEquals("1->1->2->3->4->4", ListNode.printString(ret));
    }

    @Test
    void testMergeTwoLists2() {
        int[] a1 = {1, 2, 4};
        ListNode l1 = ListNode.fromArray(a1);

        ListNode ret = _solution.mergeTwoLists(l1, null);

        assertEquals("1->2->4", ListNode.printString(ret));
    }

    @Test
    void testMergeTwoLists3() {
        int[] a1 = {1, 2, 4};
        ListNode l1 = ListNode.fromArray(a1);

        ListNode ret = _solution.mergeTwoLists(null, l1);

        assertEquals("1->2->4", ListNode.printString(ret));
    }

    @Test
    void testMergeKLists1() {
        ListNode[] lists = new ListNode[4];

        int[] a0 = {-8,-7,-6,-3,-2,-2,0,3};
        lists[0] = ListNode.fromArray(a0);
        int[] a1 = {-10,-6,-4,-4,-4,-2,-1,4};
        lists[1] = ListNode.fromArray(a1);
        int[] a2 = {-10,-9,-8,-8,-6};
        lists[2] = ListNode.fromArray(a2);
        int[] a3 = {-10,0,4};
        lists[3] = ListNode.fromArray(a3);

        ListNode ret = _solution.mergeKLists(lists);

        assertEquals("-10->-10->-10->-9->-8->-8->-8->-7->-6->-6->-6->-4->-4->-4->-3->-2->-2->-2->-1->0->0->3->4->4"
            , ListNode.printString(ret));
    }

    @Test
    void testMergeKLists2() {
        ListNode[] lists = new ListNode[3];
        int[] a0 = {-1, 1};
        lists[0] = ListNode.fromArray(a0);
        int[] a1 = {-3,1,4};
        lists[1] = ListNode.fromArray(a1);
        int[] a2 = {-2,-1,0,2};
        lists[2] = ListNode.fromArray(a2);

        ListNode ret = _solution.mergeKLists(lists);

        assertEquals("-3->-2->-1->-1->0->1->1->2->4", ListNode.printString(ret));
    }

    @ParameterizedTest(name = "testReverseStr{index}")
    @CsvSource({
        "abc,1,abc",
        "abc,3,cba",
        "abcdefg,2,bacdfeg"
    })
    void testReverseStr(String s, int k, String expected) {
        String ret = _solution.reverseStr(s, k);
        assertEquals(expected, ret);
    }

    @Test
    void testLongestValidParentheses1() {
        String s = "(()";
        int ret = _solution.longestValidParenthesesII(s);
        assertEquals(2, ret);
    }

    @Test
    void testLongestValidParentheses2() {
        String s = ")()())";
        int ret = _solution.longestValidParenthesesII(s);
        assertEquals(4, ret);
    }

    @Test
    void testLongestValidParentheses3() {
        String s = ")(((((()())()()))()(()))(";
        int ret = _solution.longestValidParenthesesII(s);
        assertEquals(22, ret);
    }

    @Test
    void testLongestValidParentheses4() {
        String s = "())((()()(()(((()())))))))((((((())()(()()(())()))(()))(()()())((((((()())()()()(()))())(((()(()"
                + "(())(()((()())())))((()(((()(()((()())())))(())))()))))))))))())()))((())()()()()))((()))(((()))()(()))()((()"
                + "()()(()))(((()()()()((()()(()())))(())))))))()))))()))()((()())())(()))(((()()()((())())())(((())((()))(())"
                + "(())()))))(())))()())())()(()))))(())))(())))(()((())(())))((()(()))((((()))))()((()()()())()(())(()(()()())"
                + "()((())(()((()()()())()))((()))))()))())))))))()((()()))()()()()))(()()()()(())()(()))))()(((((()(((((((()((("
                + "())()))(()())()(()))(()(()((()((((()))))()(())(()))))()(()(((((((()))((()(()(()))(()())(()())()(())()(()(((("
                + "()))))()()()(((())()())()))())()(())))(()()))))(())))))((((()))))(((((()))((((()))((())))))((())))())(((((((("
                + "()(()((())))()))()()))))))))(((()(()())(()))((())((())(()))))))))((())()()())(()(())()))))((())())(()(())((()"
                + "())))))((())((())())()(()))(())()()()((((()(()()))()(()(((((()())())())))())()))()))(()())()((()()()()((())()"
                + "())(((())(((()(()()(((((((()(((()((((()(()((())))())())(())()(()())()((())()()()))()(()())()))()())))()()()))"
                + ")()(((((()()))(())(((()())))(())(())())(())(()()())))()())()))(()))))(()())()(()))((((())()())(())(((()())(()"
                + "((((((((()))((((())())()((()()())())()()()())()()((()())(()()))((()()))()))(((()((()()(()))()(())()())((())()"
                + ")()(((())))(())((()((())(()()()(()(()))((()((((()(()()(())(()()))))(())()(()()))))())()((())(()))()()(()()()"
                + "((()))(()))))())((()(()((";
                
        int ret = _solution.longestValidParenthesesII(s);
        assertEquals(430, ret);
    }

    @Test
    void testThreeSum1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ret = _solution.threeSum(nums);
        assertEquals("[[-1, -1, 2], [-1, 0, 1]]", Utils.listOfListToString(ret));
    }

    @Test
    void testThreeSum2() {
        int[] nums = {-1, 0, 2, -4};
        List<List<Integer>> ret = _solution.threeSum(nums);
        assertEquals(0, ret.size());
    }

    @Test
    void testFindTargetSumWays1() {
        int[] nums = {1, 1, 1, 1, 1};
        int s = 3;

        int ret = _solution.findTargetSumWays(nums, s);
        assertEquals(5, ret);
    }

    @Test
    void testFindTargetSumWays2() {
        int[] nums = {1, 2, 3, 4, 5};
        int s = 10;

        int ret = _solution.findTargetSumWays(nums, s);
        assertEquals(0, ret);
    }
}
