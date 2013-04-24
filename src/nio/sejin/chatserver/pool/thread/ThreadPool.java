/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.pool.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nio.sejin.chatserver.queue.Queue;
import nio.sejin.chatserver.util.DynamicClassLoader;

/**
 *
 * @author 세진
 */
public class ThreadPool implements ThreadPoolIF{
    private int max = 10;
    private int min = 2;
    private int current =0;

    private final Object monitor = new Object();
    private final List pool = new ArrayList();

    private Queue queue = null;
    private String type = null;
    public ThreadPool(Queue queue, String type) {
        this(queue,type,2,10);
    }

    public ThreadPool(Queue queue, String type, int min, int max ) {
        this.queue = queue;
        this.type = type;
        this.min = min;
        this.max = max;
        init();
    }

    private void init() {
        for(int i=0;i<min;i++){
            pool.add(createThread());
        }
    }

    private synchronized Thread createThread() {
        Thread thread = null;
        try {
            thread = (Thread)DynamicClassLoader.createInstance(type, queue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        current++;
        return thread;
    }

    public void startAll() {
        synchronized ( monitor){
            Iterator iter=pool.iterator();
            while(iter.hasNext()){
                Thread thread = (Thread)iter.next();
                thread.start();
            }
        }
    }

    public void stopAll() {
        synchronized (monitor ){
            Iterator iter = pool.iterator();
            while(iter.hasNext()) {
                Thread thread = (Thread)iter.next();
                thread.interrupt();
                thread = null;
            }
            pool.clear();
        }
    }

    public void addThread() {
        synchronized (monitor) {
            if(current <max){
                Thread t= createThread();
                t.start();
                pool.add(t);
            }
        }
    }

    public void removeThread() {
        synchronized(monitor) {
            if (current > min ) {
                Thread t=(Thread)pool.remove(0);
                t.interrupt();
                t= null;
            }
        }
    }
}
