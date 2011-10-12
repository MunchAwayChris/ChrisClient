/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ChrisCleint;

/**
 *
 * @author christophermeyer
 */
public interface IServiceAnnouncer {
	public void registerService();
	public void unregisterService();
	public boolean isRegistered();
}