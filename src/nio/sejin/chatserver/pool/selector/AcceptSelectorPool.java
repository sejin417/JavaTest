/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.pool.selector;

import java.nio.channels.Selector;
import java.util.Iterator;
import nio.sejin.chatserver.pool.selector.handler.AcceptHandler;
import nio.sejin.chatserver.queue.Queue;


public class AcceptSelectorPool extends SelectorPoolAdaptor {

    private int port = 9090;
    private Queue queue = null;

    public AcceptSelectorPool(Queue queue) {
        this(queue,1,9090);
    }

    public AcceptSelectorPool(Queue queue,int size, int port ){
        super.size = size;
        this.queue = queue;
        this.port = port;
        init();
    }

    private void init() {
        for(int i=0;i<size;i++) {
            pool.add(createHandler(i));
        }
    }

    @Override
    protected Thread createHandler(int index) {
        Selector selector = null;
        try {
            selector = Selector.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread handler = new AcceptHandler (queue,selector,port,index);

        return handler;
    }

    @Override
    public void startAll() {
        Iterator iter = pool.iterator();

        while (iter.hasNext() ){
            Thread handler = (Thread)iter.next();
            handler.start();
        }
    }

    @Override
    public void stopAll() {
        Iterator iter = pool.iterator();
        while(iter.hasNext()){
            Thread handler = (Thread)iter.next();
            handler.interrupt();
            handler = null;
        }
    }

}
