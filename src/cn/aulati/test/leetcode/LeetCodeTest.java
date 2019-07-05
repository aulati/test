package cn.aulati.test.leetcode;

import cn.aulati.test.ITest;
import cn.aulati.test.leetcode.solution.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		callMethod(new int[] {1,8,6,2,5,4,8,3,7});
	}
	
	private void callMethod(int[] h) {
		System.out.print("Input: " + Arrays.toString(h));
		System.out.print(System.lineSeparator());

        Solution solution = new Solution();
		int ret = solution.maxArea(h);
		
		System.out.print("Output: " + ret);
		System.out.print(System.lineSeparator());
		System.out.println("-----------------------------");
		System.out.print(System.lineSeparator());
	}
}
