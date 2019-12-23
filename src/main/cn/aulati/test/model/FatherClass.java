package cn.aulati.test.model;

/**
 * @author Aulati
 *
 */
public class FatherClass {
	
	public FatherClass() {
		System.out.println("This is father class.");
	}
	
	{
		System.out.println("father class's statement.");
	}
	
	static {
		System.out.println("father class's static statement.");
	}
}
