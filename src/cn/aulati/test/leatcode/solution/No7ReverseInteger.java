package cn.aulati.test.leatcode.solution;

/**
 * LeetCode Test No 7.
 * 
 * https://leetcode.com/problems/reverse-integer/
 * 
 * @author Aulati
 *
 */
public class No7ReverseInteger {
	/** a instance of this class. */
	private static No7ReverseInteger _instance = null;
	
	/**
	 * private constructor.
	 */
	private No7ReverseInteger() {
	}
	
	/**
	 * Get the instance of this solution class.
	 * @return
	 */
	synchronized public static No7ReverseInteger getInstance() {
		if (_instance == null) {
			_instance = new No7ReverseInteger();
		}
		return _instance;
	}
	
	/**
	 * Reverse digits of an integer.
	 * return 0 when the reversed integer overflows.
	 * 
	 * <p>
	 * <b>Example1</b>: x = 123, return 321
	 * <br/>
	 * <b>Example2</b>: x = -123, return -321
	 * </p>
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		return reverse1(x);
	}
	
	private int reverse1(int x) {

		boolean isNegative = x < 0;
		if (isNegative) {
			x = -x;
		}
		
		String xStr = Integer.toString(x);
		char[] xChars = xStr.toCharArray();
		char[] rstChars = new char[xChars.length];
		
		int newIdx = 0;
		for (int i = xChars.length - 1; i >= 0 ; i--) {
			rstChars[newIdx++] = xChars[i];
		}
		
		try {

			int rst = Integer.parseInt(new String(rstChars), 10);
			return rst;
			
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	private int reverse0(int x) {
		if (x == 0) {
			return 0;
		}
		
		boolean isNegative = x < 0;
		if (isNegative) {
			x = -x;
		}
		
		int rst = 0;
		
		try {
			
			while (x > 0) {
				if (Integer.MAX_VALUE / 10 < rst) {
					throw new ArithmeticException("the result overflows.");
				}
				rst = rst * 10 + x % 10;
				x /= 10;
			}
			
			if (isNegative) {
				rst = -rst;
			}
			
		} catch (ArithmeticException e) {
			// overflows
			return 0;
		}
		
		return rst;
	}
}
