package cn.aulati.test.leetcode;

import cn.aulati.test.util.Utils;

public class SolutionAtOffice {
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
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     *
     * 示例 1:
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     *
     * 示例 2:
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     *
     * 说明:
     * ·被除数和除数均为 32 位有符号整数。
     * ·除数不为 0。
     * ·假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
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
