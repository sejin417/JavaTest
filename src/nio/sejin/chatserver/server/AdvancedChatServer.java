/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.server;

import java.io.File;
import java.io.IOException;
import nio.sejin.chatserver.pool.PoolManager;
import nio.sejin.chatserver.pool.buffer.ByteBufferPool;
import nio.sejin.chatserver.pool.buffer.ByteBufferPoolIF;
import nio.sejin.chatserver.pool.selector.AcceptSelectorPool;
import nio.sejin.chatserver.pool.selector.RequestSelectorPool;
import nio.sejin.chatserver.pool.selector.SelectorPoolIF;
import nio.sejin.chatserver.pool.thread.ThreadPool;
import nio.sejin.chatserver.pool.thread.ThreadPoolIF;
import nio.sejin.chatserver.queue.BlockingEventQueue;
import nio.sejin.chatserver.queue.Queue;

/**
 *
 * @author 세진
 */
public class AdvancedChatServer {
    private Queue queue = null;
    private SelectorPoolIF acceptSelectorPool = null;
    private SelectorPoolIF requestSelectorPool = null;

    private ByteBufferPoolIF byteBufferPool = null;

    ThreadPoolIF acceptThreaadPool = null;
    ThreadPoolIF readWriteThreadPool = null;
    private ThreadPool acceptThreadPool;

    public AdvancedChatServer() {
        try {
            initResource();
            startServer();
        } catch ( IOException e) {
            e.printStackTrace();;
        }
    }

    private void initResource() throws IOException {
        File bufferFile = new File("c:/buffer.tmp");
        if (!bufferFile.exists()) {
            bufferFile.createNewFile();
        }

        bufferFile.deleteOnExit();
        byteBufferPool = new ByteBufferPool(20*1024, 40*2048, bufferFile);

        //Queue 생성
        queue = BlockingEventQueue.getInstance();

        //PoolManager에 ByteBufferPool 등록
        PoolManager.registByteBufferPool(byteBufferPool);

        //ThreadPool 생성
        acceptThreadPool = new ThreadPool ( queue, "nio.sejin.chatserver.pool.thread.pocessor.AcceptProcessor");
        readWriteThreadPool = new ThreadPool( queue, "nio.sejin.chatserver.pool.thread.pocessor.ReadWriteProcessor");

        //SelectorPool을 생성
        acceptSelectorPool = new AcceptSelectorPool(queue);
        requestSelectorPool = new RequestSelectorPool(queue);

        //PoolManager에 SelectorPool 등록
        PoolManager.requestAcceptSelectorPool(acceptSelectorPool);
        PoolManager.requestRequestSelectorPool(requestSelectorPool);
    }

    private void startServer() {
        acceptThreadPool.startAll();
        readWriteThreadPool.startAll();

        acceptSelectorPool.startAll();
        requestSelectorPool.startAll();
    }

    public static void main(String[] args) {
        AdvancedChatServer server = new AdvancedChatServer();
    }
}
