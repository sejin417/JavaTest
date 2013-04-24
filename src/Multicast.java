//���ϸ�: Multicast.java

//�� ��: IP ��Ƽĳ������ �̿��� ä�� 

//������: javac Multicast.java 

//����: java Multicast 239.3.3.3 4000 ö��

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Multicast{ 
    static InetAddress mAddr;
    static int port;
    static String name = "";
    
    public static void main(String[] args){ 
        
        if(args.length != 3) {
            
            System.out.println("����: java Multicast multiAddr port name");
            
            System.exit(0);
        }
        
        
        //��Ƽĳ��Ʈ �׷� �ּ�
        
        try{ 
            mAddr = InetAddress.getByName(args[0]);
        }catch(UnknownHostException e){}
        
        port = Integer.parseInt(args[1]);// ��Ʈ ��ȣ
        name = "[" + args[2] + "]  " ;// ������ �̸�
        
        //���� �� �۽� ó�� ������ ����
        Multicast mult = new Multicast();
        mult.new Receiver().start();
        mult.new Sender().start();
    }
    
    
    
    //�޽��� ������ ����ϴ� ������
    
    public class Receiver extends Thread {
        
        public void run() {
            
            byte[] buffer = new byte[512];
            
            try {
                MulticastSocket ms = new MulticastSocket(port);
                ms.joinGroup(mAddr);
                
                while(true) {
                    DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                    ms.receive(dp);
                    String s = new String(dp.getData(), 0, dp.getLength());
                    System.out.print("--> Received Message : ");
                    System.out.println(s);
                }
            }catch(IOException ie){
                System.err.println(ie);
            }
        }
    }
    
    
    //�޽��� ������ ����ϴ� ������
    public class Sender extends Thread{ 
        
        public void run() {
            byte[] buffer = new byte[512];
            
            try {
                BufferedReader br = new BufferedReader(new 
                        InputStreamReader(System.in));
                DatagramSocket ds = new DatagramSocket();
                System.out.print("Input Message : ");
                
                while (true) {
                    String data = name + br.readLine();
                    buffer = data.getBytes();// ��Ʈ���� ����Ʈ ��̷�
                    
                    //������ �۽�
                    DatagramPacket dp = new DatagramPacket(buffer, buffer.length, mAddr,port);
                    ds.send(dp);
                }                
            }catch(IOException ie){
                System.err.println(ie);
            }
        }
    }
}
