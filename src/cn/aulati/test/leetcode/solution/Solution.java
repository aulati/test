package cn.aulati.test.leetcode.solution;

import cn.aulati.test.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums   有序数组
     * @param target 目标值
     * @return 开始位置和结束位置
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums.length == 0) {
            return ans;
        }

        int i = 0, j = nums.length - 1;
        int m, pos = -1;

        if (nums[i] > target || nums[j] < target) {
            return ans;
        }

        if (nums[i] != target && nums[j] != target) {
            // 二分查找出现的位置 pos
            while (i < j) {
                m = (i + j) / 2;
                if (nums[m] > target) {
                    j = m - 1;
                } else if (nums[m] < target) {
                    i = m + 1;
                } else {
                    pos = m;
                    break;
                }
            }
        } else {
            if (nums[i] == target) {
                ans[0] = 0;
                j = 0;
                while (j < nums.length && nums[j] == target) {
                    j++;
                }
                ans[1] = j - 1;
            } else {
                ans[1] = j;
                i = j;
                while (i >= 0 && nums[i] == target) {
                    i--;
                }
                ans[0] = i + 1;
            }
            return ans;
        }

        // 中心扩展查找端点
        if (pos >= 0) {
            i = pos;
            while (i >= 0 && nums[i] == target) {
                i--;
            }
            ans[0] = i + 1;

            j = pos;
            while (j < nums.length && nums[j] == target) {
                j++;
            }
            ans[1] = j - 1;
        }

        return ans;
    }

    /**
     * 11. 盛最多水的容器
     * @param height 容器高度数组
     * @return 最多的盛水量
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, s = -1;
        while (i < j) {
            if (height[i] < height[j]) {
                s = Math.max(s, (j - i) * height[i]);
                i++;
            } else {
                s = Math.max(s, (j - i) * height[j]);
                j--;
            }
        }
        return s;
    }

    /**
     * 56.合并区间
     *
     * @param intervals 区间的集合
     * @return 合并所有重叠区间后的数组
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        List<int[]> sorted = new LinkedList<>();

        // 1 用插入排序，将区间数组按 区间开始数字 进行排序
        int pos;
        for (int i = 0; i < intervals.length; i++) {
            pos = 0;
            for (; pos < sorted.size(); pos++) {
                if (sorted.get(pos)[0] >= intervals[i][0]) {
                    break;
                }
            }
            sorted.add(pos, intervals[i]);
        }

        // 2 按顺序合并区间
        List<int[]> ans = new ArrayList<>();
        ans.add(sorted.get(0));
        int[] pre = ans.get(0);
        int[] cur;
        for (int i = 1; i < sorted.size(); i++) {
            cur = sorted.get(i);
            if (cur[0] <= pre[1]) {
                // 当前区间与前一个区间有重叠
                pre[1] = Math.max(cur[1], pre[1]);
            } else {
                ans.add(cur);
                pre = cur;
            }
        }

        return ans.toArray(new int[0][0]);
    }

    /**
     * 120. 三角形最小路径和
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     *
     * @param triangle 给定一个三角形
     * @return 自顶向下最小路径和
     */
    public int minimumTotalSpaceTuning(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) {
            return 0;
        }

        int[] sum = new int[n];
        sum[0] = triangle.get(0).get(0);

        List<Integer> r;
        for (int i = 1; i < n; i++) {
            r = triangle.get(i);

            // 从后往前数，该行最右边一个位置的路径和最小值 = 三角形节点值 + 前一位置的值（最小路径和只用个一维数组保存）
            sum[i] = r.get(i) + sum[i - 1];

            for (int j = i - 1; j > 0; j--) {
                // 中间位置的最小路径和 = 三角形节点值 + 上一行相邻节点的最小路径和中的较小值
                sum[j] = r.get(j) + Math.min(sum[j], sum[j - 1]);
            }

            // 第一个位置的最小路径和 = 三角形该节点的值 +
            sum[0] = r.get(0) + sum[0];
        }

        int ans = sum[0];
        for (int k = 1; k < n; k++) {
            if (sum[k] < ans) {
                ans = sum[k];
            }
        }
        return ans;
    }

    /**
     * 120. 三角形最小路径和
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     *
     * @param triangle 给定一个三角形
     * @return 自顶向下最小路径和
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) {
            return 0;
        }

        int[][] sum = new int[n][n];
        sum[0][0] = triangle.get(0).get(0);

        List<Integer> r;
        int i, j;
        for (i = 1; i < n; i++) {
            r = triangle.get(i);
            sum[i][0] = r.get(0) + sum[i - 1][0];
            int m = r.size();
            for (j = 1; j < m - 1; j++) {
                sum[i][j] = r.get(j) + Math.min(sum[i - 1][j - 1], sum[i - 1][j]);
            }
            sum[i][j] = r.get(j) + sum[i - 1][j - 1];
        }

        int ans = sum[n - 1][0];
        for (int k = 1; k < n; k++) {
            if (sum[n - 1][k] < ans) {
                ans = sum[n - 1][k];
            }
        }
        return ans;
    }

    public List<TreeNode> generateTrees(int n) {
        return null;
    }

    /**
     * 71.简化路径
     * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
     *
     * @param path 绝对路径
     * @return 简化后的规范路径
     */
    public String simplifyPath(String path) {
        String[] pathElements = path.split("/");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pathElements.length; i++) {
            switch (pathElements[i]) {
                case "":
                case ".":
                    break;
                case "..":
                    if (sb.length() != 0) {
                        int left = sb.lastIndexOf("/");
                        sb.delete(left, sb.length());
                    }
                    break;
                default:
                    sb.append('/');
                    sb.append(pathElements[i]);
            }
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }


    /**
     * 1106. 解析布尔表达式 (143期周赛)
     *
     * @param expression 是以上述形式给出的有效表达式，表示一个布尔值。
     * @return 布尔表达式的运算结果
     */
    public boolean parseBoolExpr(String expression) {
        boolean ans = false;


        return ans;
    }

    private boolean parseBoolExprInner(String expression, int i) {
        char c = expression.charAt(i);
        if (c == '!') {

        }
        return false;
    }


    /**
     * 1105. 填充书架(143期周赛)
     *
     * @param books       每本书的宽度和高度
     * @param shelf_width 书架的宽度
     * @return 书架的最小高度
     */
    public int minHeightShelves(int[][] books, int shelf_width) {
        int h = 0, rowW, rowH, len = books.length;
        for (int i = 0; i < len; i++) {

        }

        return h;
    }

    /**
     * 1103. 二叉树寻路(143期周赛)
     *
     * @param label 节点的标号
     * @return 返回从根节点的路径
     */
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new LinkedList<>();
        return ans;
    }

    /**
     * 143期周赛 分糖果
     *
     * @param candies
     * @param num_people
     * @return
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];

        int i = 0, curcnt = 0, cntall = candies;

        end:
        while (cntall > 0) {
            for (i = 0; i < num_people; i++) {
                curcnt++;
                if (cntall > curcnt) {
                    ans[i] += curcnt;
                    cntall -= curcnt;
                } else {
                    ans[i] += cntall;
                    break end;
                }
            }
        }


        return ans;
    }

    /**
     * 64.最小路径和 动态规划
     *
     * @param grid 参数
     * @return 路径和最小值
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];

        ans[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            ans[i][0] = ans[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            ans[0][j] = ans[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = grid[i][j] + (ans[i - 1][j] < ans[i][j - 1] ? ans[i - 1][j] : ans[i][j - 1]);
            }
        }

        return ans[m - 1][n - 1];
    }

    /**
     * 63.有障碍物情况下的不同路径 动态规划
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] ans = new int[m][n];

        ans[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] != 0) {
                ans[i][0] = 0;
            } else {
                ans[i][0] = ans[i - 1][0];
            }
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] != 0) {
                ans[0][j] = 0;
            } else {
                ans[0][j] = ans[0][j - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 0) {
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
                }
            }
        }

        return ans[m - 1][n - 1];
    }

    /**
     * 62.不同路径
     *
     * @param m 路径图宽度
     * @param n 路径图高度
     * @return 总的路径数量
     */
    public int uniquePaths(int m, int n) {
        // ans 为到达路径表格上(i, j)位置处的总路径数
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            ans[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            ans[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
            }
        }

        return ans[m - 1][n - 1];
    }
}
