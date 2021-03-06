package cn.aulati.test.leetcode;

import cn.aulati.test.util.Utils;
import cn.aulati.test.model.ListNode;

import java.util.*;

public class SolutionAtOffice {
    /**
     * 82. Remove Duplicates from Sorted List II
     * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
     * Return the linked list sorted as well.
     * 
     * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
     * 
     * @param head A ListNode head.
     * @return Head of the List after removing duplicates.
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        int curVal = head.val + 1;
        head = new ListNode(curVal, head);
        ListNode cur = head, nex = head.next, forerunner = null;
        
        while (nex != null && nex.next != null) {
            if (nex.val != nex.next.val) {
                cur = nex;
                nex = nex.next;
                continue;
            }
            
            // cur.val == cur.next.val
            curVal = nex.val;
            forerunner = nex.next;
            while (forerunner != null && forerunner.val == curVal) forerunner = forerunner.next;
            
            cur.next = forerunner;
            nex = forerunner;
        }
        
        return head.next;
    }

    /**
     * 906. Super Palindromes
     * Let's say a positive integer is a superpalindrome if it is a palindrome,
     * and it is also the square of a palindrome.
     * <p>
     * Now, given two positive integers L and R (represented as strings),
     * return the number of superpalindromes in the inclusive range [L, R].
     *
     * @param L Left of the range.
     * @param R Right of the Range.
     * @return numbers of superpalindromes inside the given range.
     */
    public int superpalindromesInRange(String L, String R) {
        long l = Long.parseLong(L);
        long r = Long.parseLong(R);

        long ll = Double.valueOf(Math.sqrt(l)).longValue();
        long rl = Double.valueOf(Math.sqrt(r)).longValue();
        if (ll * ll < l) {
            ll++;
        }
        if (rl * rl <= r) {
            rl++;
        }

        int cnt = 0;

        for (long i = ll; i < rl; i++) {
            if (Utils.isPalindrome(String.valueOf(i)) && Utils.isPalindrome(String.valueOf(i * i))) {
                cnt++;
            }
        }

        return cnt;
    }

    /**
     * 22. Generate Parentheses
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * For example, given n = 3, a solution set is:
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     * 
     * @param n Using n pairs of parentheses
     * @return All combinations of well-formed parentheses.
     */
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        
        generateParenthesisHelper(n, 0, 0, ret, new StringBuilder());
        
        return ret;
    }
    
    /**
     * Backtracking helper method to generate parentheses.
     * @param n Using n pairs of parentheses
     * @param left Count of left parentheses that have been used.
     * @param right Count of right parentheses that have been used.
     * @param list Result list of all combinations.
     * @param sb A StringBuilder to hold the char sequences.
     */
    private void generateParenthesisHelper(int n, int left, int right, List<String> list, StringBuilder sb) {
        if (left == n && right == n) {
            list.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append('(');
            generateParenthesisHelper(n, left + 1, right, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (right < left) {
            sb.append(')');
            generateParenthesisHelper(n, left, right + 1, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    List<List<Integer>> combinationSum2Ret = new ArrayList<>();

    /**
     * 40. Combination Sum II
     * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
     * in candidates where the candidate numbers sums to target.
     *
     * Each number in candidates may only be used once in the combination.
     *
     * Note:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     *
     * @param candidates candidate numbers
     * @param target target sum
     * @return all unique combinations that sums to target
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        combinationSum2Helper(candidates, -1, target, new LinkedList<Integer>());

        return combinationSum2Ret;
    }

    private void combinationSum2Helper(int[] candidates, int k, int target, LinkedList<Integer> list) {
        // we are starting at the (k + 1)th elements, as each number may only be used once
        for (int i = k + 1; i < candidates.length;) {
            if (candidates[i] == target) {
                addToResult(list, target);
                break;
            } else if (candidates[i] > target) {
                // end the loop as target - candidates[i] < 0
                // this requires pre-sorting of candidates
                break;
            }

            list.add(candidates[i]);
            combinationSum2Helper(candidates, i, target - candidates[i], list);
            list.removeLast();

            // jump the same numbers
            while (++i < candidates.length && candidates[i] == candidates[i - 1]);
        }
    }

    private void addToResult(List<Integer> list, int target) {
        List<Integer> newList = new ArrayList(list);
        newList.add(target);
        combinationSum2Ret.add(newList);
    }


    // move step toward 4 directions
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    char[][] board;
    char[] wc;
    int len;
    int n, m;

    public boolean exist(char[][] board, String word) {
        wc = word.toCharArray();
        this.board = board;
        len = wc.length;
        n = board.length;
        m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] steps = new boolean[n][m];

                boolean ret = existInternal(0, i, j, steps);

                if (ret) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean existInternal(int i, int x, int y, boolean[][] steps) {
        // this path is not a match
        if (board[x][y] != wc[i]) {
            return false;
        }

        // A match path is found!
        if (i == len - 1) {
            return true;
        }

        // test 4 directions with recursive calls
        steps[x][y] = true;
        for (int j = 0; j < 4; j++) {
            int xx = x + move[j][0];
            int yy = y + move[j][1];

            // bound test
            if (0 <= xx && xx < n && 0 <= yy && yy < m) {

                if (steps[xx][yy]) {
                    continue;
                }

                boolean ret = existInternal(i + 1, xx, yy, steps);
                if (ret) {
                    return true;
                }
            }
        }

        steps[x][y] = false;
        return false;
    }

    /**
     * 374. Guess Number Higher or Lower
     * We are playing the Guess Game. The game is as follows:
     *
     * I pick a number from 1 to n. You have to guess which number I picked.
     *
     * Every time you guess wrong, I'll tell you whether the number is higher or lower.
     *
     * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
     *
     * -1 : My number is lower
     *  1 : My number is higher
     *  0 : Congrats! You got it!
     * Example :
     *
     * Input: n = 10, pick = 6
     * Output: 6
     *
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;

            int ret = guess(mid);
            if (ret < 0) {
                high = mid - 1;
            } else if (ret > 0) {
                low = mid + 1;
            } else {
                low = high = mid;
            }
        }

        return high;
    }

    static int guessTarget = 1702766719;
    private static int guess(int num) {
        return Integer.compare(guessTarget, num);
    }

    /**
     * 16. 3Sum Closest
     * Given an array nums of n integers and an integer target, find three integers in nums
     * such that the sum is closest to target. Return the sum of the three integers.
     * You may assume that each input would have exactly one solution.
     *
     * https://leetcode.com/problems/3sum-closest/
     *
     * @param nums array of integers
     * @param target target sum
     * @return closest sum
     */
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int sum, curSum, diff, curDiff;
        sum = nums[0] + nums[1] + nums[2];
        diff = Math.abs(sum - target);

        for (int i = 0; i < n - 2; i++) {

            int l = i + 1, r = n - 1;

            while (l < r) {
                curSum = nums[i] + nums[l] + nums[r];

                if (curSum > target) {
                    r--;
                    curDiff = curSum - target;
                    if (curDiff < diff) {
                        sum = curSum;
                        diff = curDiff;
                    }

                } else if (curSum < target) {
                    l++;
                    curDiff = target - curSum;
                    if (curDiff < diff) {
                        sum = curSum;
                        diff = curDiff;
                    }

                } else {
                    return target;
                }
            }
        }

        return sum;
    }

    /**
     * 15. 3Sum
     * Given an array nums of n integers, are there elements a, b, c
     * in nums such that a + b + c = 0? Find all unique triplets
     * in the array which gives the sum of zero.
     *
     * Note:
     * The solution set must not contain duplicate triplets.
     *
     * https://leetcode.com/problems/3sum/
     *
     * @param nums array of integers
     * @return triplets that sums to 0
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = null;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) {
                // the target of sum is 0, either three 0, or at least one negative int
                break;
            }

            // jump the same int, avoiding duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = - nums[i];
            int l = i + 1, r = n - 1;
            while (l < r) {
                int cur = nums[l] + nums[r];
                if (cur > target) {
                    r--;

                } else if (cur < target) {
                    l++;

                } else {
                    // find one triplet
                    list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ret.add(list);

                    l++;
                    while (l < r && nums[l] == nums[l - 1]) l++; // jump the same int, avoiding duplicate triplets

                    r--;
                    while (l < r && nums[r] == nums[r + 1]) r--; // jump the same int, avoiding duplicate triplets
                }
            }
        }

        return ret;
    }

    private void addToResult(int[] g, List<List<Integer>> ret, HashSet<String> set) {
        Arrays.sort(g);
        String key = Arrays.toString(g);
        if (!set.contains(key)) {
            set.add(key);

            List<Integer> list = new ArrayList<>(3);
            list.add(g[0]);
            list.add(g[1]);
            list.add(g[2]);
            ret.add(list);
        }
    }

    /**
     * 31. 下一个排列
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * 必须原地修改，只允许使用额外常数空间。
     *
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 数组
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        if (i >= 0) {
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[i]) {
                j++;
            }

            Utils.swap(nums, i, j - 1);
        }

        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            Utils.swap(nums, start, end);

            start++;
            end--;
        }
    }

    /**
     * 29. 两数相除
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     *
     * 示例 1:
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     *
     * 示例 2:
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     *
     * 说明:
     * ·被除数和除数均为 32 位有符号整数。
     * ·除数不为 0。
     * ·假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/divide-two-integers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param dividend 被除数
     * @param divisor 除数
     * @return 结果
     */
    public int divide(int dividend, int divisor) {
        boolean isNeg = false;
        long de = dividend, ds = divisor;

        if (de < 0) {
            isNeg = !isNeg;
            de = -de;
        }
        if (ds < 0) {
            isNeg = !isNeg;
            ds = -ds;
        }

        int cnt = 0;
        long tmp = ds;
        while (tmp <= de) {
            tmp <<= 1;
            cnt++;
        }

        long ret = 0;

        while (cnt >= 0) {
            if (tmp <= de) {
                ret += Math.pow(2, cnt);
                de -= tmp;
            }

            cnt--;
            tmp >>>= 1;
        }

        if (isNeg) {
            return -(int)ret;
        } else {
            return ret > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)ret;
        }
    }

    /**
     * 1295. Find Numbers with Even Number of Digits
     *
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
        int ret = 0;

        for (int i : nums) {
            boolean isEven = true;
            while (i > 0) {
                isEven = !isEven;
                i /= 10;
            }

            if (isEven) {
                ret++;
            }
        }

        return ret;
    }
}
