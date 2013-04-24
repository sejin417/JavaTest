package ejb.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestSender {
	private static final String SERVER_URL = "iiop://10.81.204.21:3800";
//	private static final String SERVER_URL = "iiop://10.240.0.111:3800";
	String name;
	QueueConnection con;
	QueueSender sender = null;
	TextMessage message;
	QueueSession session = null;
	String connectionName = "System/NOMS/ApplicationType/ConfigMonitor/Application/1-0;2-0;KTCM/Comp/QueueConnectionFactory";
	String queueName = "System/NOMS/ApplicationType/ConfigMonitor/Application/1-0;2-0;KTCM/Comp/JVTEventQueue";

	public TestSender(){
		try {
			Context cntxt =getContext();
			QueueConnectionFactory factory = (QueueConnectionFactory)cntxt.lookup(connectionName);
			Queue queue = (Queue)cntxt.lookup(queueName);

			con = factory.createQueueConnection();

			session = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			sender = session.createSender(queue);
			message = session.createTextMessage();
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

	public void send(String msg){
		try {
			message.setText( name+":"+msg);
			sender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void close(){
		try {
			sender.send(session.createMessage());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ( con!= null )
				try {
					con.close();
				} catch (JMSException e) {
				}

		}
	}

	public static void main(String args[]){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			TestSender sender = new TestSender();

			String line = "";
			while(line != null && !line.trim().equals("q")) {
				System.out.println("Input message:");
				line = reader.readLine();

				sender.send( line );
			}
			sender.close();
		} catch (Exception e) {
		} finally {

		}
		System.exit(1);
	}
}
