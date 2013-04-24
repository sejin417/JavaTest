/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.pool.selector;

import java.util.ArrayList;
import java.util.List;

public abstract class SelectorPoolAdaptor {
    protected int size = 2;
    private int roundRobinInex = 0;

    private final Object monitor = new Object();
    protected final List pool = new ArrayList();

    protected abstract Thread createHandler(int index);
    public abstract void startAll();
    public abstract void stopAll();

    public Thread get() {
        synchronized (monitor){
            return (Thread)pool.get(roundRobinInex++ % size) ;
        }
    }

    public void put( Thread handler) {
        synchronized (monitor ){
            if(handler != null) {
                pool.add(handler);
            }
            monitor.notify();
        }
    }

    public int size() {
        synchronized (monitor ){
            return pool.size();
        }
    }

    public boolean isEmpty(){
        synchronized (monitor){
            return pool.isEmpty();
        }
    }
}
