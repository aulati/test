package cn.aulati.test.designPattern.delegateProxy.model;

/**
 * @author Aulati
 *
 */
public class GamePlayer implements IGamePlayer {
	
	private String name;
	
	public GamePlayer(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see cn.aulati.test.designPattern.delegateProxy.model.IGamePlayer#login(java.lang.String, java.lang.String)
	 */
	@Override
	public void login(String user, String pwd) {
		System.out.println(name + " has logged in with name [" + user + "]");
	}

	/* (non-Javadoc)
	 * @see cn.aulati.test.designPattern.delegateProxy.model.IGamePlayer#killBoss()
	 */
	@Override
	public void killBoss() {
		System.out.println(name + " is killing enemies.");

	}

	/* (non-Javadoc)
	 * @see cn.aulati.test.designPattern.delegateProxy.model.IGamePlayer#upgrade()
	 */
	@Override
	public void upgrade() {
		System.out.println(name + " is upgraded!");
	}

}
