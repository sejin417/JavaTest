package ejb.topic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Vector;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestSubscriber {
//	private static final String SERVER_URL = "iiop://10.81.204.21:3800";
	private static final String SERVER_URL = "iiop://10.81.204.21:3800";
	
	String name;
	
	TopicConnection con;
	String connectionName = "TestTopicConnectionFactory";
	String topicName = "TopicTest";

	public TestSubscriber(){

		
		try {
			Context cntxt = getContext();
			TopicConnectionFactory factory = (TopicConnectionFactory)cntxt.lookup(connectionName);
			Topic topic = (Topic)cntxt.lookup(topicName);
			
			con = factory.createTopicConnection();
			
			TopicSession session = con.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			
			TopicSubscriber subScriber = session.createSubscriber(topic);
			TextListener listener = new TextListener();
			subScriber.setMessageListener(listener);
			con.start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public InitialContext getContext() throws NamingException{
		Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.appserv.naming.S1ASCtxFactory");
		prop.put(Context.PROVIDER_URL, SERVER_URL);
		
		return new InitialContext(prop);
	}
	
	public void close(){
		try {
			System.out.println( "Connection End");
			if ( con!= null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	public class TextListener implements MessageListener {

		public void onMessage(Message message) {
			try {
				if ( message  instanceof TextMessage ) {
					TextMessage m = (TextMessage) message;
					System.out.println( name + "="+m.getText() );
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}
	}
	
	public static void main(String args[]){
		try {
			Vector lists = new Vector();
			BufferedReader reader = new BufferedReader ( new InputStreamReader( System.in));
			String line = "";
			TestSubscriber temp;
			boolean isLoop = true;
			while( isLoop ) {
				System.out.println("Input message:");
				line = reader.readLine();

				System.out.println(line.substring(1, 1).trim());
				switch (  line.trim().charAt(0) ){
				case 'c':
					TestSubscriber pub = new TestSubscriber();
					pub.name = ( "Test " + (lists.size() + 1));
					lists.add( pub );
					
					break;
				case 'd':
					if ( lists.size() > 0)
						((TestPublisher)lists.get(0)).close();
					lists.remove(0);
					break;
				case 'q':
					isLoop = false;
					break;
				default:
//					for( int i=0; i<lists.size();i++){
//						temp = (TestSubscriber)lists.get(i);
//						temp.publish( line );
//					}
				break;
				}
			}

			//close

			for( int i=0; i<lists.size();i++){
				temp = (TestSubscriber)lists.get(i);
				System.out.println( temp.name + " Close");
				temp.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		System.exit(1);
	}
	
//	public static void main(String args[]){
//		TestSubscriber sub = new TestSubscriber();
//		
//		System.out.println("Exit q ) ");
//		
//		while ( true ) {
//			try {
//				char c = (char)System.in.read();
//				System.out.println("Message : " + c);
//				if ( c == 'q'){
//					System.out.println(" QUIT Program");
//					break;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		sub.close();
//		System.out.println("END PRogram");
//		System.exit(0);
//	}
}
