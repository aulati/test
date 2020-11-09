package cn.aulati.test.leetcode;

public class MaxSubArray {
    /**
     * 53. Maximum Subarray
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     * 
     * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     * 
     * https://leetcode.com/problems/maximum-subarray/
     * 
     * @param nums An given array.
     * @return Largest sum of contiguous subarray.
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
