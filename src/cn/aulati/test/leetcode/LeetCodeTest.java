package cn.aulati.test.leetcode;

import cn.aulati.test.ITest;
import cn.aulati.test.leetcode.solution.Solution;

import java.util.ArrayList;
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
		callMethod();
	}
	
	private void callMethod() {
//        System.out.print("Input String: " + s);
//		System.out.print(System.lineSeparator());

		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			list.add(new ArrayList<>());
		}
		list.get(0).add(2);
		list.get(1).add(3);
		list.get(1).add(4);
		list.get(2).add(6);
		list.get(2).add(5);
		list.get(2).add(7);
		list.get(3).add(4);
		list.get(3).add(1);
		list.get(3).add(8);
		list.get(3).add(3);

        Solution solution = new Solution();
		int ret = solution.minimumTotalSpaceTuning(list);
		
		System.out.print("Output: " + ret);
		System.out.print(System.lineSeparator());
		System.out.println("-----------------------------");
		System.out.print(System.lineSeparator());
	}
}
