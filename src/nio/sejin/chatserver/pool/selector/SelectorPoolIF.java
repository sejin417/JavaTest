/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.pool.selector;

public interface SelectorPoolIF {
    public Thread get();
    public void put(Thread handler);
    public int size();
    public boolean isEmpty();
    public void startAll();
    public void stopAll();
}
