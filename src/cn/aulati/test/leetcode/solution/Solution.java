package cn.aulati.test.leetcode.solution;

public class Solution {
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
