package cn.aulati.test.leatcode;

import cn.aulati.test.ITest;
import cn.aulati.test.leatcode.solution.ZigzagConversion;

/**
 * @author Aulati
 *
 */
public class LeatCodeTest implements ITest {

	/**
	 * Run a leetCode solution.
	 * @see cn.aulati.test.ITest#runTest()
	 */
	@Override
	public void runTest() {
		callMethod("LEETCODEISHIRING", 2);
		callMethod("LEETCODEISHIRING", 3);
		callMethod("LEETCODEISHIRING", 4);
		callMethod("PAYPALISHIRING", 2);
	}
	
	private void callMethod(String s, int numRows) {
		System.out.print("Input String: " + s);
		System.out.print(System.lineSeparator());
		System.out.print("Input numRows: " + numRows);
		System.out.print(System.lineSeparator());

		String ret = ZigzagConversion.convert2(s, numRows);
		
		System.out.print("Output: " + ret);
		System.out.print(System.lineSeparator());
		System.out.println("-----------------------------");
		System.out.print(System.lineSeparator());
	}
}
