package ejb.topic;

import java.util.Properties;
import java.util.Vector;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestPublisher {
//	private static final String SERVER_URL = "iiop://10.240.0.125:3800";
	private static final String SERVER_URL = "iiop://10.81.204.21:3800";

	String name;
	TopicConnection con;
	TopicPublisher publisher;
	TextMessage message;
	Context cntxt;

	String connectionName = "System/NOMS/ApplicationType/TcaMonitor/Application/1-0;2-0;KTFM/Comp/TopicConnectionFactory";
	String topicName = "System/NOMS/ApplicationType/TcaMonitor/Application/1-0;2-0;KTFM/Comp/JVTEventTopic";

	public TestPublisher() {
		try {
			cntxt =getContext();
			TopicConnectionFactory factory = (TopicConnectionFactory)cntxt.lookup(connectionName);
			Topic topic = (Topic)cntxt.lookup(topicName);

			con = factory.createTopicConnection();

			TopicSession session = con.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			publisher = session.createPublisher(topic);
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

	public void publish(String msg){
		try {
			message.setText( name+":"+msg);
			publisher.publish(message);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void close(){
		try {
			if ( con!= null ) con.close();
			if ( cntxt!= null ) cntxt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	public static void main(String args[] ){
		int maxCount = 50000;
		Vector vec = new Vector();

		for ( int i=0;i<maxCount;i++) { 
			
			try {
				TestPublisher temp = new TestPublisher();
				Thread.sleep(1000);
				temp.close();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 

		TestPublisher temp;
		for ( int i=0;i<maxCount;i++) { 
			temp = (TestPublisher)vec.get(i);
			
			temp.close();
		}
	}

//	public static void main(String args[]){
//		try {
//			Vector lists = new Vector();
//			BufferedReader reader = new BufferedReader ( new InputStreamReader( System.in));
//			String line = "";
//			TestPublisher temp;
//			boolean isLoop = true;
//			while( isLoop ) {
//				System.out.println("Input message:");
//				line = reader.readLine();
//
//				System.out.println(line.substring(1, 1).trim());
//				switch (  line.trim().charAt(0) ){
//				case 'c':
//					TestPublisher pub = new TestPublisher();
//					pub.name = ( "Test " + (lists.size() + 1));
//					lists.add( pub );
//					
//					break;
//				case 'd':
//					if ( lists.size() > 0)
//						((TestPublisher)lists.get(0)).close();
//					lists.remove(0);
//					break;
//				case 'q':
//					isLoop = false;
//					break;
//				default:
//					for( int i=0; i<lists.size();i++){
//						temp = (TestPublisher)lists.get(i);
//						temp.publish( line );
//					}
//				break;
//				}
//			}
//
//			//close
//
//			for( int i=0; i<lists.size();i++){
//				temp = (TestPublisher)lists.get(i);
//				System.out.println( temp.name + " Close");
//				temp.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//		}
//
//		System.exit(1);
//	}

//	public static void main(String args[]){
//	try {
//	BufferedReader reader = new BufferedReader ( new InputStreamReader( System.in));

//	TestPublisher pub = new TestPublisher();
//	System.out.println("Input message:");
//	String line="";

//	while(line != null && !line.trim().equals("q")) {
//	System.out.println("Input message:");
//	line = reader.readLine();

//	pub.publish( line );
//	}
//	pub.close();
//	} catch (Exception e) {
//	// TODO: handle exception
//	} finally {

//	}

//	System.exit(1);
//	}
}
