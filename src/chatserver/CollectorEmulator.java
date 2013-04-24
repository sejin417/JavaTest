/*
 * (@)# CollectorEmulator.java
 * 
 * 2006. 7. 13
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
package chatserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Sejin
 * 
 */
public class CollectorEmulator extends Thread {
	private String analyzerIp = "61.74.75.51 ";
//    private String analyzerIp = "localhost";
    private int analyzerPort = 5700;
    private int packetBufferSize = 5700;
    public boolean check = true;

    //IOStream
    private Socket theSocket;
    private DataInputStream reader;
    private DataOutputStream writer;

    public CollectorEmulator(){
        try {
            initilazeSocket();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void initilazeSocket() throws UnknownHostException, IOException{
        theSocket = new Socket(analyzerIp, analyzerPort);
        
        //declare InputStream 
        reader = new DataInputStream( theSocket.getInputStream() );
        
        //declare OutputStream
        writer = new DataOutputStream(theSocket.getOutputStream());
    }
    
    public void connectAnalyzer(){
        String connectProtocol = "DA000000";
        send( connectProtocol );
    }
    
    public synchronized void send( String message ) {
        System.out.println( "Send Msg:" + message);
        
        try {
            //Send Message
            writer.write( message.getBytes() );
            
            writer.flush();
        } catch (IOException e) {
        }
    }
    
    public void requestMsg( String msg ){
        String headMsg = msg.substring(0,4);
        String sizeMsg = msg.substring(4,8);
        String dataMsg = msg.substring(8, msg.indexOf('\0'));
        
        System.out.println( " head msg : " + headMsg);
        System.out.println( " size msg : " + sizeMsg);
        System.out.println( " data msg : " + dataMsg);
        
        System.out.print("\n전송할 문장을 입력하십시오 : ");
    }
    
    public void run(){
        String buffer = "false"; 
        
        byte[] _tmp = new byte[packetBufferSize];
        
        int length;
        while( check ){
            try {
                length = reader.read( _tmp );
                
                if( length >= 3 ){
                    buffer = new String(_tmp);
                    requestMsg(buffer);
                } 
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public void startPackage(String projectId){
    	send("GA000016"+projectId+"1       ");

//    	send("GA0000160609072G1       ");

    }

    public void finallySocket() throws IOException{
        theSocket.close();
    }
    
    public void gargageData(){
    	send("BI0001379999999925135408222.114.215.2260000000731552016000000000049969400000000000000000000000000000000000000000000000000000000.000000000000000.0");

    	send("BI0001379999999925135359000210.97.151.20000000012986040000000000000917100000000000000000000000000000000000000000000000000000000.000000000000000.0BI000137999999992513540800220.67.247.330000000398830200000000000027242500000000000000000000000000000000000000000000000000000000.000000000000000.0BI00013799999999251354080203.252.23.2510000000096805104000000000006648600000000000000000000000000000000000000000000000000000000.000000000000000.0BI000137999999992513540800172.26.20.1780000000092854200000000000006342500000000000000000000000000000000000000000000000000000000.000000000000000.0BI0001379999999925135408220.123.180.2500000000681546168000000000046553700000000000000000000000000000000000000000000000000000000.000000000000000.0BI000137999999992513540700221.163.95.580000000048473040000000000003311000000000000000000000000000000000000000000000000000000000.000000000000000.0BI0001379999999925135408192.168.250.2530000000693123480000000000047344500000000000000000000000000000000000000000000000000000000.000000000000000.0BI00013799999999251354080210.183.28.1050000002251417272000000000159044700000000000000000000000000000000000000000000000000000000.000000000000000.0BI000137999999992513540800211.38.88.1820000000445732368000000000030446200000000000000000000000000000000000000000000000000000000.000000000000000.0BI00013799999999251354080210.101.224.660000000325868832000000000022258800000000000000000000000000000000000000000000000000000000.000000000000000.0BI00013799");
    	send("BI000137999999992513540800210.110.70.210000001405554192000000000096007800000000000000000000000000000000000000000000000000000000.000000000000000.0BI00013799999999251353570221.152.156.580000000002534544000000000000475400000000000000000000000000000000000000000000000000000000.000000000000000.0BI000137999999992513540700210.100.193.10000000022031544000000000001507900000000000000000000000000000000000000000000000000000000.000000000000000.0BI00013799999999251354070218.159.29.2540000000021924864000000000001497600000000000000000000000000000000000000000000000000000000.000000000000000.0BI00013799999999251354080211.55.253.1620000000024217488000000000001654200000000000000000000000000000000000000000000000000000000.000000000000000.0BI00013799999999251354070210.183.28.1400000001873874088000000000132379500000000000000000000000000000000000000000000000000000000.000000000000000.0BI00013799999999251354080210.183.28.1390000000150400704000000000010664400000000000000000000000000000000000000000000000000000000.000000000000000.0BI00013799999999251354080203.228.25.2060000000003734976000000000000496200000000000000000000000000000000000000000000000000000000.000000000000000.0BI00013706112501251354050210.183.28.1320000000337051105000000000023816500000000650000001817010721000000000261708300000486361922.000000001155026.0BI00013799999999251354050210.183.28.1320000000165035592000000000011659100000000000000000000000000000000000000000000000000000000.000000000000000.0BI000137061125012513");

    	send("BI00013706112501251354050210.183.28.1320000000337051105000000000023816500000000690000000565020000000000000076747000000143176163.000000000241610.0BI00013706112501251354050210.183.28.1320000000336957649000000000023809900000000680000000568001498000000000091783200000276159114.000000000536721.0BI00013706112501251354060210.183.28.1310000000336392665000000000023770000000000620000001859226821000000000278302900000524817789.000000001256671.0BI00013799999999251354060210.183.28.1310000000156604944000000000011063800000000000000000000000000000000000000000000000000000000.000000000000000.0BI00013706112501251354060210.183.28.1310000000336392665000000000023770000000000650000000609949078000000000100823600000293376520.000000000599003.0BI00013706112501251354060210.183.28.1310000000336387001000000000023769600000000660000000596394317000000000089367100000159717531.000000000330435.0BI0001379999999925135408000202.31.145.90000000037935384000000000002591500000000000000000000000000000000000000000000000000000000.000000000000000.0");
    }
    
    public void stopPackage1(){
    	String data = "GA000009060911016";
    	send(data);
    	
//    	data = "GA000009060827086";
//    	send(data);
    }
    
    public void stopPackage(String projectId){
    	String data = "GA000009"+projectId+"6";
    	send(data);
    }
    
    public void test(){
    	String data = "AF000000123456789";
    	send(data);
    }
    
    public static void main(String[] args) {
        String theLine;
        
        CollectorEmulator ce = new CollectorEmulator();
        
        ce.start();
        
        ce.connectAnalyzer();
        
        while ( true ){
        	try {
        		ce.gargageData();
				Thread.sleep( 5 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
    public String sendPackageTraffic(String packageId){
    	StringBuffer sendData;
    	StringBuffer routerIp = new StringBuffer("210.222.241.117");
    	
    	for(int i=0;i<15-routerIp.length() ;i++){
    		routerIp.append(' ');
    	}

    	sendData = new StringBuffer(150);
    	    	
    	sendData.append("BI000137061020022013203300210.183.28.130000000000068797000000009732388900000001110000000001284076000000098281402700000301326824.000000000471251.0");

    	send( sendData.toString() );
//
//    	sendData = new StringBuffer(150);
//    	sendData.append("BI000105");
//    	sendData.append(packageId);
//    	sendData.append("03170801");
//    	sendData.append(routerIp);
//    	sendData.append("0000000000222222");
//    	sendData.append("0000000000333333");
//    	sendData.append("0000000105");
//    	sendData.append("0000000000444444");
//    	sendData.append("0000000000555555");
//
//    	send( sendData.toString() );
//
//    	sendData.append("BI000105");
//    	sendData.append(packageId);
//    	sendData.append("03170801");
//    	sendData.append(routerIp);
//    	sendData.append("0000000000123456");
//    	sendData.append("0000000000123456");
//    	sendData.append("0000000109");
//    	sendData.append("0000000000123456");
//    	sendData.append("0000000000123456");
//    	
//    	send( sendData.toString() );
//
//    	sendData = new StringBuffer(150);
//    	sendData.append("BI000105");
//    	sendData.append(packageId);
//    	sendData.append("03170801");
//    	sendData.append(routerIp);
//    	sendData.append("0000000000222222");
//    	sendData.append("0000000000333333");
//    	sendData.append("0000000110");
//    	sendData.append("0000000000444444");
//    	sendData.append("0000000000555555");
//    	
//    	send( sendData.toString() );

        return analyzerIp;
    }
}
