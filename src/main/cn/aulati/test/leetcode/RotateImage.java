package cn.aulati.test.leetcode;

public class RotateImage {
    /**
     * 48. Rotate Image
     * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
     * DO NOT allocate another 2D matrix and do the rotation.
     * 
     * Example 1:
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [[7,4,1],[8,5,2],[9,6,3]]
     * 
     * @param a a n x n 2D matrix
     */
    public void rotate(int[][] a) {
        int m = a.length;
        for (int i = 0; i < m / 2; i++) {
            for (int j = i; j < m - 1 - i; j++) {
                int tmp = a[i][j];
                a[i][j] = a[m - 1 - j][i];
                a[m - 1 - j][i] = a[m - 1 - i][m - 1 - j];
                a[m - 1 - i][m - 1 - j] = a[j][m - 1 - i];
                a[j][m - 1 - i] = tmp;
            }
        }

    }
}
