package cn.aulati.test.leetcode;

import cn.aulati.test.ITest;
import cn.aulati.test.leetcode.solution.MaxSubArray;
import cn.aulati.test.leetcode.solution.Solution;

import java.util.Arrays;

/**
 * @author Aulati
 *
 */
public class LeetCodeTest implements ITest {

	/**
	 * Run a leetCode solution.
	 * @see cn.aulati.test.ITest#runTest()
	 */
	@Override
	public void runTest() {
		callMethod();
	}
	
	private void callMethod() {
//        System.out.print("Input String: " + m + ", " + n);
		System.out.print(System.lineSeparator());

		int[][] na = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Solution solution = new Solution();
		int ret = solution.minPathSum(na);
		
		System.out.print("Output: " + ret);
		System.out.print(System.lineSeparator());
		System.out.println("-----------------------------");
		System.out.print(System.lineSeparator());
	}
}
