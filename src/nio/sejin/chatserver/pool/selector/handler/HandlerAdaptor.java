/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.pool.selector.handler;

import java.nio.channels.SocketChannel;

public abstract class HandlerAdaptor {
    public abstract void run();
    public abstract void addClient(SocketChannel sc );
}
