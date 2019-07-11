package cn.aulati.test.leetcode;

import cn.aulati.test.ITest;
import cn.aulati.test.leetcode.solution.Solution;
import cn.aulati.test.model.TreeNode;

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
		testBuildTree();
	}

	/**
	 * 测试构造二叉树
	 * @param preOrder 前序遍历序列
	 * @param inorder 中序遍历序列
	 */
	private void testBuildTree() {
		int[] preOrder = new int[] {3,9,20,15,7};
		int[] inOrder  = new int[] {9,3,15,20,7};
		System.out.println("Input: " + Arrays.toString(preOrder) + ", " + Arrays.toString(inOrder));

        Solution solution = new Solution();
		TreeNode ret = solution.buildTree(preOrder, inOrder);
		List<Integer> list = solution.inorderTraversal(ret);
		
		System.out.println("Output: " + Arrays.toString(list.toArray(new Integer[0])));
		System.out.println("-----------------------------");
	}
}
