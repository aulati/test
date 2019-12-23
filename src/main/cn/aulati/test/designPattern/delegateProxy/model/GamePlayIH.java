package cn.aulati.test.designPattern.delegateProxy.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Aulati
 *
 */
public class GamePlayIH implements InvocationHandler {
	
	Object obj = null;
	
	/**
	 * 
	 */
	public GamePlayIH(Object o) {
		obj = o;
	}

	/**
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		Object rst = arg1.invoke(obj, arg2);
		return rst;
	}

}
