package cn.aulati.test.T001;

import cn.aulati.test.ITest;
import cn.aulati.test.model.Employee;

/**
 * 
 * What does <code>final</code> do?
 * @author Aulati
 *
 */
public class FunctionOfFinal implements ITest {

	/**
	 * start method of the FunctionOfFinal class.
	 */
	public void runTest() {
		int i = 0;

		// before method1()
		System.out.println(String.valueOf(i));
		
		method1(i);
		
		// after method1(), before method2()
		System.out.println(String.valueOf(i));
		method2(i);
		
		// after method2()
		System.out.println(String.valueOf(i));
		
		Employee emp = new Employee();
		emp.setFirstName("John");
		emp.setLastName("Smith");
		
		// before method3()
		System.out.println(emp.toString());

		method3(emp);
		
		// after method3(), and before method4()
		System.out.println(emp.toString());
		
		method4(emp);
		
		// after method4()
		System.out.println(emp.toString());
	}

	/**
	 * method1, parameter is not a <code>final</code> parameter.
	 * @param i
	 */
	private static void method1(int i) {
		i = 2;
	}

	/**
	 * method1, parameter is not a <code>final</code> parameter.
	 * @param i
	 */
	private static void method2(final int i) {
		// un-comment the next line, and you get an compile error!
//		i = 2;
	}
	
	private static void method3(Employee emp) {
		emp.setFirstName("Tom");
		emp.setLastName("Hankson");
	}
	
	private static void method4(final Employee emp) {
		emp.setFirstName("Bob");
		emp.setLastName("Delon");
		System.out.print("Inside method4, emp: ");
		System.out.println(emp.toString());
	}
}
