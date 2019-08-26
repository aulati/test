package cn.aulati.test.leetcode.solution;

import cn.aulati.test.model.ListNode;
import cn.aulati.test.model.TreeNode;

import java.util.*;

public class Solution2 {
    /**
     * 21. 合并两个有序链表
     *
     * @param l1 有序链表1
     * @param l2 有序链表2
     * @return 合并后的有序链表首节点
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode root, cur;

        if (l1.val < l2.val) {
            cur = root = l1;
            l1 = l1.next;
        } else {
            cur = root = l2;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return root;
    }

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 只包括括号字符的字符串
     * @return 字符串是否有效
     */
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char pre;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    st.push(c);
                    break;
                case ')':
                    if (st.isEmpty() || '(' != st.pop()) {
                        return false;
                    }
                    break;
                case ']':
                    if (st.isEmpty() || '[' != st.pop()) {
                        return false;
                    }
                    break;
                case '}':
                    if (st.isEmpty() || '{' != st.pop()) {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }

    /**
     * 16. 最接近的三数之和
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     *
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     *
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        return 0;
    }

    /**
     * 15. 三数之和
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 给定整数数组
     * @return 和为0的三元组集合
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);

        List<List<Integer>> ret = new LinkedList<>();
        List<Integer> list;
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 如果某个数与前一个数相同，那么跳过这个数。这样可以避免找出一些重复的三元组
                continue;
            }

            // 另外两数之和
            int sum = - nums[i];
            int l = i + 1, r = len - 1;
            int curSum;

            while (l < r) {
                curSum = nums[l] + nums[r];
                if (curSum < sum) {
                    do {
                        l++;
                    } while (l < r && nums[l] == nums[l - 1]);
                } else if (curSum > sum) {
                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
                } else {
                    // 找到一个三数之和为 0 的组合 (i, l, r)
                    list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ret.add(list);

                    do {
                        l++;
                    } while (l < r && nums[l] == nums[l - 1]);

                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
                }
            }
        }

        return ret;
    }

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
