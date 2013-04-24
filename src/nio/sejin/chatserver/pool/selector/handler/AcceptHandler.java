/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.pool.selector.handler;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import nio.sejin.chatserver.event.Job;
import nio.sejin.chatserver.event.NIOEvent;
import nio.sejin.chatserver.queue.Queue;

public class AcceptHandler extends Thread{
    private Queue queue = null;
    private Selector selector = null;
    private int port = 9090;
    private String name = "AcceptHandler-";

    public AcceptHandler(Queue queue, Selector selector, int port, int index ){
        this.queue = queue;
        this.selector = selector;
        this.port = port;
        setName(name+index);
        init();
    }

    private void acceptPandingConnections() throws Exception {
        Iterator iter = selector.selectedKeys().iterator();

        while ( iter.hasNext()){
            SelectionKey key = (SelectionKey)iter.next();
            iter.remove();

            ServerSocketChannel readyChannel = (ServerSocketChannel)key.channel();
            SocketChannel sc = readyChannel.accept();
            System.out.println("Accept Handler ("+getName() +") Connection accepted from "+sc.socket().getInetAddress());

            pushMyJob(sc);
        }
    }

    private void init() {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);

            InetSocketAddress address = new InetSocketAddress("localhost",port);
            ssc.socket().bind(address);

            System.out.println("AcceptHandler ("+getName() +") Bound to " + address);

            ssc.register(this.selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()) {
                int keysReady = selector.select();
                acceptPandingConnections();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pushMyJob(SocketChannel sc) {
        Map session = new HashMap();
        session.put("SocketChannel", sc );
        Job job = new Job(NIOEvent.ACCEPT_EVENT,session);
    }
}
