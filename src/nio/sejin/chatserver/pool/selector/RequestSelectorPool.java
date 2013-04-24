/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.pool.selector;

import java.util.Queue;


public class RequestSelectorPool implements SelectorPoolIF{

    public RequestSelectorPool(Queue queue) {
    }

    public Thread get() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void put(Thread handler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void startAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void stopAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
