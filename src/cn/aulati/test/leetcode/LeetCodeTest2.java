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
        testReverseLists();
    }
    
    private void testReverseLists() {
        int[] a = {1, 2, 3, 4, 5};
        ListNode h = createListNode(a);
        System.out.println("Input: " + ListNode.printString(h));
        
        ListNode ret = _solution.reverseLists(h);

        System.out.println("Output: " + ListNode.printString(ret));
        System.out.println("-----------------------------");
    }
    
    private void testReverseAlphabets() {
        String s = "abcd-EF-ga";
        System.out.println("Input:" + s);

        String ret = _solution.reverseAlphabets(s);

        System.out.println("Output: " + ret);
        System.out.println("-----------------------------");
    }
    
    private void testCanJump() {
        int[] a = {3, 2, 1, 0, 4};
        System.out.println("Input:" + Arrays.toString(a));
        
        boolean ret = _solution.canJump(a);

        System.out.println("Output: " + ret);
        System.out.println("-----------------------------");
    }
    
    private void testNumSmallerByFrequency() {
        String[] s1 = {"baaaaa","abbaaaab","bbbaabaaba"};
        String[] s2 = {"bbbbaaa","bb","aaaab","abbabbbbab","bbb","a","aa","aabaaabab","aababab","baa","aaaba","aabaab"
                ,"aa","bbabba","baa","abaaaabbb","babaa","aababaabab","baaaa","baaabbb","aabaab","bbabbab","b","aab"};
        System.out.println("Input:");
        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));

        int[] ret = _solution.numSmallerByFrequency(s1, s2);

        System.out.println("Output: " + Arrays.toString(ret));
        System.out.println("-----------------------------");
    }
    
    private void testCountNumbersWithUniqueDigits() {
        int n = 10;
        System.out.println("Input: n = " + n);

        int ret = _solution.countNumbersWithUniqueDigits(n);

        System.out.println("Output: " + ret);
        System.out.println("-----------------------------");
    }

    /**
     * 264. 丑数 II
     */
    private void testNthUglyNumber() {
        int n = 7;
        System.out.println("Input: n = " + n);

        int ret = _solution.nthUglyNumber(n);

        System.out.println("Output: " + ret);
        System.out.println("-----------------------------");
    }

    /**
     * 23. 合并K个排序链表
     */
    private void testMergeKLists() {
        ListNode[] lists = new ListNode[3];
        
//        int[] a0 = {-8,-7,-6,-3,-2,-2,0,3};
//        lists[0] = createListNode(a0);
//        int[] a1 = {-10,-6,-4,-4,-4,-2,-1,4};
//        lists[1] = createListNode(a1);
//        int[] a2 = {-10,-9,-8,-8,-6};
//        lists[2] = createListNode(a2);
//        int[] a3 = {-10,0,4};
//        lists[3] = createListNode(a3);

        int[] a0 = {-1, 1};
        lists[0] = createListNode(a0);
        int[] a1 = {-3,1,4};
        lists[1] = createListNode(a1);
        int[] a2 = {-2,-1,0,2};
        lists[2] = createListNode(a2);

        System.out.println("Input: [" + Arrays.toString(a0)
                + ", " + Arrays.toString(a1)
                + ", " + Arrays.toString(a2) + "]");

        ListNode ret = _solution.mergeKLists(lists);

        System.out.println("Output: " + ListNode.printString(ret));
        System.out.println("-----------------------------");
    }
    
    private ListNode createListNode(int[] nums) {
        ListNode root, cur;
        root = cur = new ListNode(0);
        
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        
        return root.next;
    }

    /**
     * 541. 反转字符串 II
     */
    private void testReverseStr() {
        String s = "abcdefg";
        int k = 2;
        System.out.println("Input: s = " + s + ", k = " + k);

        String ret = _solution.reverseStr(s, k);

        System.out.println("Output: " + ret);
        System.out.println("-----------------------------");
    }

    /**
     * 32.最长有效括号
     */
    private void testLongestValidParentheses() {
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
//        String s = ")(((((()())()()))()(()))("; // 22
        System.out.println("Input: " + s);

        int ret = _solution.longestValidParenthesesII(s);

        System.out.println("Output: " + ret);
        System.out.println("-----------------------------");
    }

    /**
     * 21. 合并两个有序链表
     */
    private void testMergeTwoLists() {
        int[] a1 = {1, 2, 4};
        ListNode l1 = createListNode(a1);
        
        int[] a2 = {1, 3, 4};
        ListNode l2 = createListNode(a2);

        System.out.println("Input: " + Arrays.toString(a1) + ", " + Arrays.toString(a2));

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