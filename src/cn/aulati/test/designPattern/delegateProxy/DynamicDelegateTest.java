package cn.aulati.test.designPattern.delegateProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.aulati.test.ITest;
import cn.aulati.test.designPattern.delegateProxy.model.GamePlayIH;
import cn.aulati.test.designPattern.delegateProxy.model.GamePlayer;
import cn.aulati.test.designPattern.delegateProxy.model.IGamePlayer;

/**
 * @author Aulati
 *
 */
public class DynamicDelegateTest implements ITest {

	/**
	 * main test method.
	 * @see cn.aulati.test.ITest#runTest()
	 */
	@Override
	public void runTest() {
		IGamePlayer player = new GamePlayer("Lya");
		
		InvocationHandler handler = new GamePlayIH(player);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		System.out.println("Begin:" + sdf.format(new Date()));
		
		ClassLoader cl = player.getClass().getClassLoader();
		
		IGamePlayer proxy = (IGamePlayer)Proxy.newProxyInstance(cl, new Class[] { IGamePlayer.class }, handler);
		
		proxy.login("Fuck", "");
		
		proxy.killBoss();
		
		proxy.upgrade();

		System.out.println("End:  " + sdf.format(new Date()));
	}

}
