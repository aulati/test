package cn.aulati.test.leetcode.solution;

import cn.aulati.test.model.TreeNode;

import java.util.Stack;

public class Solution2 {
    /**
     * 494.目标和
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     *
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     *
     * 示例 1:
     * 输入: nums: [1, 1, 1, 1, 1], S: 3
     * 输出: 5
     * 解释:
     *
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     *
     * 一共有5种方法让最终目标和为3。
     * 注意:
     *
     * 数组的长度不会超过20，并且数组中的值全为正数。
     * 初始的数组的和不会超过1000。
     * 保证返回的最终结果为32位整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/target-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 非负整数组
     * @param S 目标和
     * @return 可计算出目标和的组合数量
     */
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWaysHelper(nums, nums.length, 0, S);
    }

    private int findTargetSumWaysHelper(int[] nums, int len, int i, int s) {
        // 这里用 “==” 会比 “>=” 有提升，leetcode 上用时分别是670ms, 905ms
        if (i == len) {
            return s == 0 ? 1 : 0;
        }

        int ways = findTargetSumWaysHelper(nums, len, i + 1, s - nums[i])
                + findTargetSumWaysHelper(nums, len, i + 1, s + nums[i]);

        return ways;
    }

    /**
     * 494.目标和
     * 动态规划解法。
     *
     * @param nums 非负整数组
     * @param S 目标和
     * @return 可计算出目标和的组合数量
     */
    public int findTargetSumWaysII(int[] nums, int S) {

        return 0;
    }

    /**
     * 1161. 最大层内元素和
     * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
     *
     * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root 树根
     * @return 和最大那几层的最小层号
     */
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE, maxLvl = -1, curLvl = 0;
        TreeNode curNode;

        // 两个栈，一个存储当前层的节点，一个存储当前层的子节点
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        Stack<TreeNode> tmp;

        st.push(root);
        int curSum;

        while (!st.isEmpty()) {
            curSum = 0;
            curLvl++;

            // st 为存储当前层的所有节点的栈，依次将当前层节点出栈，求和，并将子节点添加到 st2
            while (!st.isEmpty()) {
                curNode = st.pop();
                curSum += curNode.val;

                if (curNode.left != null) {
                    st2.push(curNode.left);
                }
                if (curNode.right != null) {
                    st2.push(curNode.right);
                }
            }

            // 若当前层之和更大，则更新最大层和，和层数
            if (curSum > maxSum) {
                maxSum = curSum;
                maxLvl = curLvl;
            }

            // 交换 st 和 st2
            tmp = st;
            st = st2;
            st2 = tmp;
        }

        return maxLvl;
    }
}
