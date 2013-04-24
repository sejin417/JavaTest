/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.pool.thread.processor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import nio.sejin.chatserver.event.Job;
import nio.sejin.chatserver.event.NIOEvent;
import nio.sejin.chatserver.pool.PoolManager;
import nio.sejin.chatserver.pool.buffer.ByteBufferPoolIF;
import nio.sejin.chatserver.pool.thread.ThreadPoolIF;
import nio.sejin.chatserver.queue.Queue;

/**
 *
 * @author 세진
 */
public class ReadWriteProcessor extends Thread {
    private Queue queue = null;

    public ReadWriteProcessor(Queue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Job job = queue.pop(NIOEvent.READ_EVENT);

                SelectionKey key = (SelectionKey)job.getSession().get("SelectionKey");
                SocketChannel sc = (SocketChannel)key.channel();

                try {
                    broadcast(sc);
                } catch (Exception e) {
                    closeChannel(sc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void broadcast(SocketChannel sc ) throws IOException {
        ByteBufferPoolIF bufferPool = PoolManager.getByteBufferPool();
        ByteBuffer buffer = null;
        try {
            buffer = bufferPool.getMemoryBuffer();

            for(int i=0li<2;i++ ) {
                sc.read(buffer);
                buffer.flip();

                Iterator iter = ChattingRoom.getInstance().iterator();
                while(iter.hasNext()) {
                    SocketChannel member = (Socketchannel)iter.next();
                    if (member !=null && member.isConnected()) {
                        while(buffer.hasRemainging()) {
                            member.write(buffer);
                        }
                        buffer.rewind();
                    }
                }
            }
        } finally {
            bufferPool.putBuffer(buffer);
        }
    }

    private void closeChannel(SocketChannel sc ) {
        try {
            sc.close();
            ChattingRoom.getInstance().remove(sc);
        } catch (Exception e) {

        }
    }
}