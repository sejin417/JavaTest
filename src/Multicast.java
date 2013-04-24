//파일명: Multicast.java

//기 능: IP 멀티캐스팅을 이용한 채팅 

//컴파일: javac Multicast.java 

//사용법: java Multicast 239.3.3.3 4000 철수

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
            
            System.out.println("사용법: java Multicast multiAddr port name");
            
            System.exit(0);
        }
        
        
        //멀티캐스트 그룹 주소
        
        try{ 
            mAddr = InetAddress.getByName(args[0]);
        }catch(UnknownHostException e){}
        
        port = Integer.parseInt(args[1]);// 포트 번호
        name = "[" + args[2] + "]  " ;// 참가자 이름
        
        //수신 및 송신 처리 스레드 생성
        Multicast mult = new Multicast();
        mult.new Receiver().start();
        mult.new Sender().start();
    }
    
    
    
    //메시지 수신을 담당하는 스레드
    
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
    
    
    //메시지 전송을 담당하는 스레드
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
                    buffer = data.getBytes();// 스트링을 바이트 어레이로
                    
                    //데이터 송신
                    DatagramPacket dp = new DatagramPacket(buffer, buffer.length, mAddr,port);
                    ds.send(dp);
                }                
            }catch(IOException ie){
                System.err.println(ie);
            }
        }
    }
}
