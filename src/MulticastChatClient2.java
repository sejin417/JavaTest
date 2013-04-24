import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/*
 * (@)# MulticastChatClient.java
 * 
 * 2006. 5. 3
 *
 * ====================================================================
 *
 * WarePlus., Software License, Version 1.0
 *
 * Copyright (c) 2002-2004 Ware Plus.,
 * WarePlus  * All rights reserved.
 *
 * DON'T COPY OR REDISTRIBUTE THIS SOURCE CODE WITHOUT PERMISSION.
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL WarePlus OR ITS
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * For more information on this product, please see 
 * WarePlus
 *
 */

/**
 * @author Sejin
 * 
 */
public class MulticastChatClient2 extends Frame implements ActionListener{
    private TextField idTF = null;
    private TextField input = null;
    private TextArea display = null;
    private CardLayout cardLayout = null;
    
    DatagramSocket socket = null;
    DatagramPacket spacket = null;
    InetAddress schannel = null;
    int sport = 20005;

    String saddress = "239.0.0.1";
    
    boolean onAir = true;
    String id = "";
    
    public MulticastChatClient2(){
        super("채팅 클라이언트");
        cardLayout = new CardLayout();
        
        setLayout(cardLayout);

        Panel loginPanel = new Panel();
        loginPanel.setLayout(new BorderLayout());
        loginPanel.add("North", new Label("아이디를 입력해 주신후 엔터 키를 입력해 주세요"));
        idTF = new TextField(20);
        idTF.addActionListener( this );
        
        Panel c = new Panel();
        c.add(idTF);
        loginPanel.add("Center",c);
        add("login",loginPanel);
        
        Panel main = new Panel();
        main.setLayout(new BorderLayout());
        input = new TextField();
        input.addActionListener(this);
        display = new TextArea();
        display.setEditable(false);
        main.add("Center",display);
        main.add("South", input);
        add("main",main);
        
        try{
            socket = new DatagramSocket(sport++);
        }catch(Exception ex){
            System.out.println("서버와 접속 시 오류가 발생했습니다.");
            System.out.println(ex);
            System.exit(1);
        }
        
        setSize(500,500);
        cardLayout.show(this,"login");
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.out.println("종료합니다");
                sendMsg(id+" 님이 종료합니다.");
                try{
                    socket.close();
                }catch(Exception ex){}
                System.exit(0);
            }
        });
        
        setVisible( true );
    }
    
    public static void main(String[] args) {
        new MulticastChatClient2();
    }
    
    /**
     * @param string
     */
    protected void sendMsg(String msg) {
        //Abstract Method
        byte[] b = new byte[200];
        try{
            b = msg.getBytes();
            schannel =InetAddress.getByName(saddress);
            spacket = new DatagramPacket( b, b.length, schannel, sport );
            socket.send(spacket);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {
        //Abstract Method
        if(e.getSource() == idTF ){
            id = idTF.getText();
            if( id == null || id.trim().equals("")){
                System.out.println("아이디를 다시 입력해서 주세요");
                return;
            }
            sendMsg(id + " 님이 입장했습니다./n");

            WinInputMulticastThread wit = new WinInputMulticastThread();
            wit.start();
            cardLayout.show(this, "main");
            input.requestFocus();
        }else if (e.getSource() == input ){
            String msg = input.getText();
            sendMsg(id + ":" + msg + "\n");
            if(msg.equals("/quit")){
                try{
                    socket.close();
                }catch(Exception ex){}
                sendMsg(id+" 님이 종료합니다");
                System.out.println("종료합니다");
                System.exit(1);
            }
            input.setText("");
            input.requestFocus();
        }
    }

    class WinInputMulticastThread extends Thread {
        MulticastSocket receiver = null;
        DatagramPacket packet = null;
        InetAddress channel = null;
        int port = 20005;
        String address = "239.0.0.1";
        
        public WinInputMulticastThread(){
            try{
                receiver = new MulticastSocket(port);
                channel = InetAddress.getByName(address);
                receiver.joinGroup(channel);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        public void run(){
            try{
                while(true){
                    byte[] b = new byte[2000];
                    packet= new DatagramPacket(b,b.length);
                    receiver.receive(packet);
                    String msg = new String(packet.getData());
                    if ( msg.equals( "/quit"))
                        break;
                    display.append(msg);
                }
                
                receiver.leaveGroup(channel);
                receiver.close();
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
}
