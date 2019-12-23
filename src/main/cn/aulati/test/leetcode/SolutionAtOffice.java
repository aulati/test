package cn.aulati.test.leetcode;

public class SolutionAtOffice {
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
