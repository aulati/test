package cn.aulati.test.leetcode;

import cn.aulati.test.ITest;
import cn.aulati.test.leetcode.solution.Solution;
import cn.aulati.test.model.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * @author Aulati
 */
public class LeetCodeTest implements ITest {

    private Solution _solution;

    /**
     * Run a leetCode solution.
     *
     * @see cn.aulati.test.ITest#runTest()
     */
    @Override
    public void runTest() {
        _solution = new Solution();
        testNumRollsToTarget();
    }

    private void testNumRollsToTarget() {
        int d = 30;
        int f = 30;
        int t = 500;
        System.out.println("Input: (d, f, t) = (" + d + ", " + f + ", " + t + ")");

        int ret = _solution.numRollsToTarget(d, f, t);

        System.out.println("Output: " + ret);
        System.out.println("-----------------------------");
    }

    private void testMaxRepOpt1() {
        String s = "ababa";
        System.out.println("Input: " + s);

        int ret = _solution.maxRepOpt1(s);

        System.out.println("Output: " + ret);
        System.out.println("-----------------------------");
    }

    private void testLargest1BorderedSquare() {
//        int[][] x = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] x = {{1, 1, 0, 0}};
        for (int i = 0; i < x.length; i++) {
            System.out.println("Input: " + Arrays.toString(x[i]));
        }

        int ret = _solution.largest1BorderedSquare(x);

        System.out.println("Output: " + ret);
        System.out.println("-----------------------------");
    }

    /**
     * 字母石板
     */
    private void testAlphabetBoardPath() {
        String x = "leet";
        System.out.println("Input: " + x);

        String ret = _solution.alphabetBoardPath(x);

        System.out.println("Output: " + ret);
        System.out.println("-----------------------------");
    }

    /**
     * 寻找最长公共子字符串
     */
    private void testLongestSubstring() {
        String x = "I believe that something is wrong!";
        String y = "Everything OK?";
        System.out.println("Input: " + x + ", " + y);

        long t1 = System.nanoTime();
        String ret = _solution.longestSubstring(x, y);
        long t2 = System.nanoTime();

        System.out.println("Output: " + ret);
        System.out.println("Time cost: " + (t2 - t1));
        System.out.println("-----------------------------");
    }

    /**
     * 测试基数排序：给定长字符串排序
     */
    private void testRadixSort() {
        String[] s = {"abcd", "accd", "acad", "adad"};

        System.out.println("Input: " + Arrays.toString(s));

        _solution.radixSort(s, 4);

        System.out.println("Output: " + Arrays.toString(s));
        System.out.println("-----------------------------");
    }

    /**
     * 测试构造二叉树
     */
    private void testBuildTreeII() {
        int[] inorder = new int[]{ 9, 3, 15, 20, 7 };
        int[] postorder = new int[]{ 9, 15, 7, 20, 3 };
        System.out.println("Input(inorder, postorder): " + Arrays.toString(inorder) + ", " + Arrays.toString(postorder));

        TreeNode ret = _solution.buildTreeII(inorder, postorder);
        List<Integer> list = _solution.inorderTraversal(ret);

        System.out.println("Output: " + Arrays.toString(list.toArray(new Integer[0])));
        System.out.println("-----------------------------");
    }

    /**
     * 测试构造二叉树
     */
    private void testBuildTree() {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        System.out.println("Input: " + Arrays.toString(preOrder) + ", " + Arrays.toString(inOrder));

        TreeNode ret = _solution.buildTree(preOrder, inOrder);
        List<Integer> list = _solution.inorderTraversal(ret);

        System.out.println("Output: " + Arrays.toString(list.toArray(new Integer[0])));
        System.out.println("-----------------------------");
    }
}
