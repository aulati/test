package cn.aulati.test.leetcode;

import cn.aulati.test.ITest;
import cn.aulati.test.leetcode.solution.Solution;
import cn.aulati.test.model.TreeNode;

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
		String[] s = {"abcd", "accd", "acad", "adad"};
		callMethod(s, 4);
	}
	
	private void callMethod(String[] s, int strLen) {
		System.out.println("Input: " + Arrays.toString(s));

        Solution solution = new Solution();
		String[] ret = solution.radixSort(s, strLen);
		
		System.out.println("Output(s)  : " + Arrays.toString(s));
		System.out.println("Output(ret): " + Arrays.toString(ret));
		System.out.println("-----------------------------");
	}
}
