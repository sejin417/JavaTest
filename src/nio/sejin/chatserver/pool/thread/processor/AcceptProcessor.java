/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.pool.thread.processor;

import java.nio.channels.SocketChannel;
import nio.sejin.chatserver.event.Job;
import nio.sejin.chatserver.event.NIOEvent;
import nio.sejin.chatserver.pool.PoolManager;
import nio.sejin.chatserver.pool.selector.handler.HandlerAdaptor;
import nio.sejin.chatserver.queue.Queue;

/**
 *
 * @author 세진
 */
public class AcceptProcessor extends Thread{
    private Queue queue = null;

    public AcceptProcessor(Queue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()) {
                Job job = queue.pop(NIOEvent.ACCEPT_EVENT);
                SocketChannel sc = (SocketChannel)job.getSession().get("SocketChannel");
                sc.configureBlocking(false);

                HandlerAdaptor handler = (HandlerAdaptor)PoolManager.getRequestSelectorPool().get();

                handler.addClient(sc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
