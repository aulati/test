package cn.aulati.test.leetcode;

import cn.aulati.test.util.ArrayFirstElementComparator;

import java.util.Arrays;
import java.util.Comparator;

public class NightWork {
    /**
     * 1283. 使结果不超过阈值的最小除数
     * 给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
     * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
     * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
     * 题目保证一定有解。
     *
     * 示例 1：
     * 输入：nums = [1,2,5,9], threshold = 6
     * 输出：5
     * 解释：如果除数为 1 ，我们可以得到和为 17 （1+2+5+9）。
     * 如果除数为 4 ，我们可以得到和为 7 (1+1+2+3) 。如果除数为 5 ，和为 5 (1+1+1+2)。
     *
     * 示例 2：
     * 输入：nums = [2,3,5,7,11], threshold = 11
     * 输出：3
     *
     * 示例 3：
     * 输入：nums = [19], threshold = 5
     * 输出：4
     *  
     * 提示：
     * 1 <= nums.length <= 5 * 10^4
     * 1 <= nums[i] <= 10^6
     * nums.length <= threshold <= 10^6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-smallest-divisor-given-a-threshold
     *
     * @param nums
     * @param threshold
     * @return
     */
    public int smallestDivisor(int[] nums, int threshold) {
        // 数组中的最大数，是满足条件的一个数
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                right = nums[i];
            }
        }

        // 1 一般是不满足条件的数
        int left = 1;
        while (left < right) {
            int mid = (left + right) >>> 1;

            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum = sum + (nums[i] - 1) / mid + 1;
            }

            if (sum <= threshold) {
                // 循环中保持 right 是满足的条件的数这个性质不变
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    /**
     * 1288. 删除被覆盖区间
     * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
     *
     * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
     *
     * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
     *
     *  
     * 示例：
     * 输入：intervals = [[1,4],[3,6],[2,8]]
     * 输出：2
     * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
     *  
     *
     * 提示：
     * 1 <= intervals.length <= 1000
     * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
     * 对于所有的 i != j：intervals[i] != intervals[j]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-covered-intervals
     *
     * @param intervals 区间列表
     * @return 精简后的区间数量
     */
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new ArrayFirstElementComparator());

//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });

        int n = intervals.length;

        int cnt = 0;
        int right = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > right || intervals[i][1] > right) {
                cnt++;
                right = intervals[i][1];
            }
        }

        return cnt;
    }
}
