package ejb.queue;

import java.util.Properties;

import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestReceiver {
	private static final String SERVER_URL = "iiop://10.240.0.125:3800";
	String name;
	QueueConnection con;
	QueueReceiver receiver;
	TextMessage message;

	String connectionName = "System/NOMS/ApplicationType/TcaMonitor/Application/1-0;2-0;KTFM/Comp/TopicConnectionFactory";
	String queueName = "System/NOMS/ApplicationType/TcaMonitor/Application/1-0;2-0;KTFM/Comp/JVTEventTopic";

	public TestReceiver(){
		try {
			Context cntxt =getContext();
			QueueConnectionFactory factory = (QueueConnectionFactory)cntxt.lookup(connectionName);
			Queue queue = (Queue)cntxt.lookup(queueName);

			con = factory.createQueueConnection();

			QueueSession session = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			receiver = session.createReceiver(queue);
			con.start();
		}catch ( Exception e ){
			e.printStackTrace();
		}
	}

	public InitialContext getContext() throws NamingException{
		Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.appserv.naming.S1ASCtxFactory");
		prop.put(Context.PROVIDER_URL, SERVER_URL);

		return new InitialContext(prop);
	}

	public void receiver(){
		try {
			while ( true ) {
				Message m = receiver.receive(1);
				
				if ( m != null ){
					if ( m instanceof TextMessage) {
						TextMessage message = (TextMessage)m;
						System.out.println("¸Þ½ÃÁö:"+message.getText());
					}else {
						break;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ( con != null) {
				try {
					con.close();
				}catch(Exception e){}
			}
		}
	}
}