package cn.aulati.test.designPattern.delegateProxy.model;

/**
 * @author Aulati
 *
 */
public interface IGamePlayer {

	/**
	 * Login to play game.
	 * 
	 * @param user
	 * @param pwd
	 */
	public void login(String user, String pwd);
	
	/**
	 * kill enemies to gain experiences.
	 */
	public void killBoss();
	
	/**
	 * level up.
	 */
	public void upgrade();
}
