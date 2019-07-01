package cn.aulati.test.leetcode.solution;

public class MaxSubArray {
    /**
     * 最大子序和
     * @param nums 输入数组
     * @return 子序列和的最大值
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = 0, curSum = 0;
        if (nums.length == 1) {
            return nums[0];
        }

        maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }

            if (curSum <= 0) {
                curSum = 0;
            }
        }

        return maxSum;
    }
}
