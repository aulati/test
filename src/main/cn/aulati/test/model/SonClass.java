package cn.aulati.test.model;

/**
 * @author Aulati
 *
 */
public class SonClass extends FatherClass {

	public SonClass() {
		System.out.println("This is son class.");
	}
	
	{
		System.out.println("son class's statement.");
	}
	
	static {
		System.out.println("son class's static statement.");
	}
}
