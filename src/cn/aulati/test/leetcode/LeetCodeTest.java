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
		int[] preOrder = new int[] {3,9,20,15,7};
		int[] inOrder  = new int[] {9,3,15,20,7};
		callMethod(preOrder, inOrder);
	}
	
	private void callMethod(int[] preOrder, int[] inorder) {
		System.out.print("Input: " + Arrays.toString(preOrder) + ", " + Arrays.toString(inorder));

        Solution solution = new Solution();
		TreeNode ret = solution.buildTree(preOrder, inorder);
		
		System.out.println("Output: " + ret);
		System.out.println("-----------------------------");
	}
}
