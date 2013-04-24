import java.awt.*;	
import java.awt.event.*;	
	
import java.net.*;	
import java.io.*;	
public class MulticastChatClient extends Frame implements ActionListener{	
	private TextField idTF = null;
	private TextField input = null;
	private TextArea display = null;
	private CardLayout cardLayout = null;
	
	DatagramSocket socket = null; 
	DatagramPacket spacket = null;
	InetAddress schannel =null;
	int sport = 20005; 
	String saddress = "239.0.0.1";
	boolean onAir = true; 	
	String id = "";	
		
	public MulticastChatClient(){	
		super("ä�� Ŭ���̾�Ʈ");
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		Panel loginPanel = new Panel();
		loginPanel.setLayout(new BorderLayout());
		loginPanel.add("North", new Label("���̵� �Է��Ͽ� �ֽ��� ���͸� �Է��Ͽ� �ּ���."));
		idTF = new TextField(20);
		idTF.addActionListener(this);
		Panel c = new Panel();
		c.add(idTF);
		loginPanel.add("Center", c);
		add("login", loginPanel);
		Panel main = new Panel();			
		main.setLayout(new BorderLayout());			
		input = new TextField();			
		input.addActionListener(this);			
		display = new TextArea();			
		display.setEditable(false);			
		main.add("Center", display);			
		main.add("South", input);			
		add("main", main);			
		try{			
			socket = new DatagramSocket(sport); 		
		}catch(Exception ex){			
			System.out.println("������ ���ӽ� ������ �߻��Ͽ����ϴ�.");		
			System.out.println(ex);		
			System.exit(1);		
		}			
		setSize(500, 500);			
		cardLayout.show(this, "login");			
		addWindowListener(new WindowAdapter(){			
			public void windowClosing(WindowEvent e){		
				System.out.println("�����մϴ�.");	
				sendMsg(id + " ���� �����մϴ�.");	
				try{	
					socket.close();
				}catch(Exception ex){}	
				System.exit(0);	
			}		
		});			
		setVisible(true);			
	}				
					
					
	public static void main(String[] args) {		
		new MulticastChatClient();	
	}		
	public void sendMsg(String msg){		
		byte[] b = new byte[2000]; 	
	  	try { 	
			b = msg.getBytes(); // ����Ʈ �迭�� ����
			schannel = InetAddress.getByName(saddress); 
			spacket = new DatagramPacket(b, b.length, schannel, sport); 
			socket.send(spacket);
		} catch (IOException e) { 	
			e.printStackTrace(); 
		}  	
	}		
			
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource() == idTF){		
			id = idTF.getText();	
			if(id == null || id.trim().equals("")){	
				System.out.println("���̵� �ٽ� �Է��Ͽ� �ּ���.");
				return;
			}	
			sendMsg(id + " ���� �����Ͽ����ϴ�.\n");	
			WinInputMulticastThread wit = new WinInputMulticastThread();	
			wit.start();	
			cardLayout.show(this, "main");	
			input.requestFocus();	
		}else if(e.getSource() == input){		
			String msg = input.getText();	
			sendMsg(id + ":" + msg + "\n");	
			if(msg.equals("/quit")){	
				try{
					socket.close();
				}catch(Exception ex){}	
				sendMsg(id + " ���� �����մϴ�.");	
				System.out.println("�����մϴ�.");	
				System.exit(1);	
			}		
			input.setText("");		
			input.requestFocus();		
		}			
	} // actionPerformed				
					
					
	class WinInputMulticastThread extends Thread{				
		MulticastSocket receiver = null; 			
		DatagramPacket packet = null;			
		InetAddress channel =null;			
		int port = 20005; 			
		String address = "239.0.0.1";			
		public WinInputMulticastThread(){			
			try { 		
			   		
			   receiver = new MulticastSocket(port); 		
			   channel = InetAddress.getByName(address); 		
			   receiver.joinGroup(channel); 		
			} catch (IOException e) { 		
			   e.printStackTrace(); 		
			}  		
		}			
		public void run(){			
			try{		
				while(true){	
					byte[] b = new byte[2000]; 
					packet = new DatagramPacket(b, b.length); 
				   	receiver.receive(packet); 
				    String msg = new String(packet.getData());	
				    if(msg.equals("/quit"))	
				    	break;
				    display.append(msg);	
				} 	
				receiver.leaveGroup(channel); 	
				receiver.close(); 	
			}catch(Exception ex){		
				System.out.println(ex);	
			}		
		} // InputThread			
	} // WinInputMulticastThread end				
} // MulticastChat Client class					
