package cn.aulati.test.leetcode;

import cn.aulati.test.ITest;
import cn.aulati.test.leetcode.solution.Solution2;

import java.util.Arrays;

public class LeetCodeTest2 implements ITest {

    private Solution2 _solution;
    @Override
    public void runTest() {
        _solution = new Solution2();
        testFindTargetSumWays();
    }

    /**
     * 494.目标和
     */
    private void testFindTargetSumWays() {
        int[] nums = {1, 1, 1, 1, 1};
        int s = 3;
        System.out.println("Input: nums = " + Arrays.toString(nums) + ", s = " + s);

        int ret = _solution.findTargetSumWays(nums, s);

        System.out.println("Output: " + ret);
        System.out.println("-----------------------------");
    }

    /**
     * 1161. 最大层内元素和
     */
    private void testMaxLevelSum() {
        System.out.println("Input: ");
//        TreeNode root;
//
//        int ret = _solution.maxLevelSum(root);

//        System.out.println("Output: " + ret);
        System.out.println("-----------------------------");
    }
}
