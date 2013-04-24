/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.pool.thread;

/**
 *
 * @author 세진
 */
public interface ThreadPoolIF {
    public void addThread();
    public void removeThread();
    public void startAll();
    public void stopAll();
}
