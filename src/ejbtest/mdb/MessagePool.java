package ejbtest.mdb;

import java.util.Hashtable;

public class MessagePool {
	private static MessagePool _instance;
	private Hashtable<String, MessageBean> _messagePool; 

	/**
	 * MessagePool 객채 전송 
	 * @return
	 */
	public static MessagePool getInstance() {
		if (_instance == null) {
			synchronized (MessagePool.class) {
				if (_instance == null) {
					_instance = new MessagePool();
				}
			}
		}
		return _instance;
	}

	private MessagePool(){
		_messagePool = new Hashtable<String, MessageBean>(4,2);
	}

	public void action(String key){
		MessageBean bean = (MessageBean)_messagePool.get(key);
		synchronized (_messagePool) {
			if ( bean == null){
				bean = new MessageBean(key);
				_messagePool.put(key, bean);
			}

			bean.setCount( 1 );
		}

		synchronized ( bean ) {
			bean.start();

			if ( bean.getCount() <= 1 ){
				_messagePool.remove(bean.getKey());
				System.out.println("삭제 " + key);
			}else {
				bean.setCount( -1 );
			}
		}
	}
}
