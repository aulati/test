package cn.aulati.test.leetcode;

import cn.aulati.test.ITest;
import cn.aulati.test.leetcode.solution.LongestPalindrome;

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
		callMethod("a");
		callMethod("aa");
		callMethod("ac");
		callMethod("abcdedcbbbedcba");
	}
	
	private void callMethod(String s) {
		System.out.print("Input String: " + s);
		System.out.print(System.lineSeparator());

		String ret = LongestPalindrome.longestPalindrome(s);
		
		System.out.print("Output: " + ret);
		System.out.print(System.lineSeparator());
		System.out.println("-----------------------------");
		System.out.print(System.lineSeparator());
	}
}
