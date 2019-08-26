package cn.aulati.test.leetcode;

import cn.aulati.test.ITest;
import cn.aulati.test.leetcode.solution.Solution2;
import cn.aulati.test.model.ListNode;

import java.util.Arrays;
import java.util.List;

public class LeetCodeTest2 implements ITest {
    /** 第二个 leetcode 解题 Class */
    private Solution2 _solution;

    /**
     * 测试主方法
     */
    @Override
    public void runTest() {
        _solution = new Solution2();
        testMergeTwoLists();
    }

    /**
     * 21. 合并两个有序链表
     */
    private void testMergeTwoLists() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println("Input: " + ListNode.printString(l1) + ", " + ListNode.printString(l2));

        ListNode ret = _solution.mergeTwoLists(l1, l2);

        System.out.println("Output: " + ListNode.printString(ret));
        System.out.println("-----------------------------");
    }

    /**
     * 15.三数之和
     */
    private void testThreeSum() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: nums = " + Arrays.toString(nums));

        List<List<Integer>> ret = _solution.threeSum(nums);

        System.out.println("Output: ");
        for (int i = 0; i < ret.size(); i++) {
            List<Integer> list = ret.get(i);
            System.out.println("[" + list.get(0) + ", " + list.get(1) + ", " + list.get(2) + "]");
        }
        System.out.println("-----------------------------");
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
