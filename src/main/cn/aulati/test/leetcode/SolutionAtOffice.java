package cn.aulati.test.leetcode;

import cn.aulati.test.util.Utils;

import java.util.*;

public class SolutionAtOffice {
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
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;

            int ret = guess(mid);
            if (ret < 0) {
                low = mid + 1;
            } else if (ret > 0) {
                high = mid - 1;
            } else {
                low = high = mid;
            }
        }

        return high;
    }

    static int guessTarget = 1702766719;
    private static int guess(int num) {
        return Integer.compare(num, guessTarget);
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
