package cn.aulati.test;

import cn.aulati.test.leatcode.LeatCodeTest;

/**
 * The start class of this test project.
 * @author Aulati
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		// declares the variable.
		ITest tc = null;
		
//		tc = new FunctionOfFinal();
//		tc = new ExtendsAndImplements();

		// 3. Dynamic delegate test
//		tc = new DynamicDelegateTest();

		// 
		tc = new LeatCodeTest();
		
//		tc = new SortTestMain();
		
		tc.runTest();
	}
}
