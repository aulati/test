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
        testRadixSort();
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
