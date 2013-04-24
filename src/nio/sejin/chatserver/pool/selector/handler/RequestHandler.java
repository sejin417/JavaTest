/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.pool.selector.handler;

import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import nio.sejin.chatserver.event.Job;
import nio.sejin.chatserver.event.NIOEvent;
import nio.sejin.chatserver.queue.ChattingRoom;
import nio.sejin.chatserver.queue.Queue;

/**
 *
 * @author ¼¼Áø
 */
public class RequestHandler {
    private Queue queue = null;
    private Selector selector = null;
    private String name = "RequestHandler-";

    private Vector newClients = new Vector();

    public RequestHandler(Queue queue, Selector selector, int index) {
        this.queue = queue;
        this.selector = selector;
        setName(name + index);
    }

    public void run(){
        try {
            while(!Thread.currentThread().isInterrupted()) {
                processNewConnection();
                int keysReady = selector.select(1000);
                System.out.println("RequestHandler ("+getName() +")selected :"+keysReady);
                if (keysReady >0) {
                    processRequest();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }


    private synchronized void processNewConnection() throws ClosedChannelException {
        Iterator iter = newClients.iterator();
        while(iter.hasNext()) {
            SocketChannel sc = (SocketChannel) iter.next();
            sc.register(selector,SelectionKey.OP_READ);
            ChattingRoom.getInstance().add(sc);
            System.out.println("RequestHandler (" +getName() +") success regist : " +sc.toString());
        }
        newClients.clear();
    }

    private void processRequest() {
        Iterator iter = selector.selectedKeys().iterator();
        while(iter.hasNext()) {
            SelectionKey key = (SelectionKey)iter.next();
            iter.remove();
            pushMyJob(key);
        }
    }

    private void pushMyJob(SelectionKey key) {
        Map session = new HashMap();
        session.put("SelectionKey",key);
        Job job = new Job(NIOEvent.ACCEPT_EVENT, session);
    }

    public void addClient(SocketChannel sc ) {
        newClients.add(sc);
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }
}
