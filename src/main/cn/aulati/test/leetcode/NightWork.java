package cn.aulati.test.leetcode;

import cn.aulati.test.util.ArrayFirstElementComparator;

import java.util.*;

public class NightWork {
    /**
     * 1310. 子数组异或查询
     * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
     * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
     * 并返回一个包含给定查询 queries 所有结果的数组。
     * <p>
     * 示例 1：
     * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
     * 输出：[2,7,14,8]
     * 解释：
     * 数组中元素的二进制表示形式是：
     * 1 = 0001
     * 3 = 0011
     * 4 = 0100
     * 8 = 1000
     * 查询的 XOR 值为：
     * [0,1] = 1 xor 3 = 2
     * [1,2] = 3 xor 4 = 7
     * [0,3] = 1 xor 3 xor 4 xor 8 = 14
     * [3,3] = 8
     * <p>
     * 示例 2：
     * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
     * 输出：[8,0,4,4]
     *  
     * <p>
     * 提示：
     * 1 <= arr.length <= 3 * 10^4
     * 1 <= arr[i] <= 10^9
     * 1 <= queries.length <= 3 * 10^4
     * queries[i].length == 2
     * 0 <= queries[i][0] <= queries[i][1] < arr.length
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr     元素数组
     * @param queries 异或查询的范围
     * @return 异或查询的结果
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prexor = new int[n + 1];
        prexor[0] = arr[0];
        for (int i = 1; i <= n; i++) {
            prexor[i] = prexor[i - 1] ^ arr[i - 1];
        }

        n = queries.length;
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = prexor[queries[i][0]] ^ prexor[queries[i][1] + 1];
        }

        return ret;
    }

    /**
     * 1309. 解码字母到整数映射
     * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
     * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
     * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
     * 返回映射之后形成的新字符串。
     * <p>
     * 题目数据保证映射始终唯一。
     * <p>
     *  
     * 示例 1：
     * 输入：s = "10#11#12"
     * 输出："jkab"
     * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
     * <p>
     * 示例 2：
     * 输入：s = "1326#"
     * 输出："acz"
     * <p>
     * 示例 3：
     * 输入：s = "25#"
     * 输出："y"
     * <p>
     * 示例 4：
     * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
     * 输出："abcdefghijklmnopqrstuvwxyz"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
     *
     * @param s 编码字符串
     * @return 映射之后的字符串
     */
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();

        int len = s.length();
        char[] c = s.toCharArray();
        for (int i = 0; i < len; ) {
            if (i + 2 < len && s.charAt(i + 2) == '#') {
                sb.append((char) ((c[i] - '0') * 10 + (c[i + 1] - '1') + 'a'));
                i += 3;
            } else {
                sb.append((char) (c[i] - '1' + 'a'));
                i++;
            }
        }

        return sb.toString();
    }

    /**
     * 1282. 用户分组
     * 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
     * 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
     * <p>
     * 示例 1：
     * <p>
     * 输入：groupSizes = [3,3,3,3,3,1,3]
     * 输出：[[5],[0,1,2],[3,4,6]]
     * 解释：
     * 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
     * <p>
     * 示例 2：
     * 输入：groupSizes = [2,1,3,3,3,2]
     * 输出：[[1],[0,5],[2,3,4]]
     *  
     * 提示：
     * groupSizes.length == n
     * 1 <= n <= 500
     * 1 <= groupSizes[i] <= n
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-the-people-given-the-group-size-they-belong-to
     *
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> ret = new LinkedList<List<Integer>>();

        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        int[] size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new LinkedList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            list.get(groupSizes[i]).add(i);
            size[groupSizes[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < size[i]; j += i) {
                ret.add(list.get(i).subList(j, j + i));
            }
        }

        return ret;
    }

    /**
     * 1283. 使结果不超过阈值的最小除数
     * 给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
     * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
     * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
     * 题目保证一定有解。
     * <p>
     * 示例 1：
     * 输入：nums = [1,2,5,9], threshold = 6
     * 输出：5
     * 解释：如果除数为 1 ，我们可以得到和为 17 （1+2+5+9）。
     * 如果除数为 4 ，我们可以得到和为 7 (1+1+2+3) 。如果除数为 5 ，和为 5 (1+1+1+2)。
     * <p>
     * 示例 2：
     * 输入：nums = [2,3,5,7,11], threshold = 11
     * 输出：3
     * <p>
     * 示例 3：
     * 输入：nums = [19], threshold = 5
     * 输出：4
     *  
     * 提示：
     * 1 <= nums.length <= 5 * 10^4
     * 1 <= nums[i] <= 10^6
     * nums.length <= threshold <= 10^6
     * <p>
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
     * <p>
     * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
     * <p>
     * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
     * <p>
     *  
     * 示例：
     * 输入：intervals = [[1,4],[3,6],[2,8]]
     * 输出：2
     * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
     *  
     * <p>
     * 提示：
     * 1 <= intervals.length <= 1000
     * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
     * 对于所有的 i != j：intervals[i] != intervals[j]
     * <p>
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
