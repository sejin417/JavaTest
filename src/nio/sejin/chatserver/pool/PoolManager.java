/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.pool;

import java.util.HashMap;
import java.util.Map;
import nio.sejin.chatserver.pool.buffer.ByteBufferPoolIF;
import nio.sejin.chatserver.pool.selector.SelectorPoolIF;

public class PoolManager {
    private static Map map = new HashMap();

    private static PoolManager instance = new PoolManager();

    private PoolManager(){}

    public static void registAcceptSelectorPool(SelectorPoolIF selectorPool) {
        map.put("AcceptSelectorPool",selectorPool);
    }

    public static void registRquestSelectorPool(SelectorPoolIF selectorPool) {
        map.put("RequestSelectorPool",selectorPool);
    }

    public static SelectorPoolIF getAcceptSelectorPool() {
        return (SelectorPoolIF)map.get("AcceptSelectorPool");
    }

    public static SelectorPoolIF getRequestSelectorPool() {
        return (SelectorPoolIF)map.get("RequestSelectorPool");
    }

    public static void registByteBufferPool(ByteBufferPoolIF byteBufferPool) {
        map.put("ByteBufferPool", byteBufferPool);
    }
    
    public static ByteBufferPoolIF getByteBufferPool() {
        return (ByteBufferPoolIF) map.get("ByteBufferPool");
    }


}
