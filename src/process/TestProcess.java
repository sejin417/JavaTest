package process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ������ command ����� ���� ���μ���
 * @author Sejin
 *
 */
public class TestProcess {
	private String command = null;
	private String processName = null;
	
	public TestProcess(String processName, String command){
		this.command = command;
		this.processName = processName;
	}
	
    public String actionProcess(){
	    Process process = null;
	    StringBuffer processMsg = new StringBuffer();
	    try {
	    	processMsg.append(  "[" + processName + "] Process �� �����մϴ�.  (��ɾ�:"+command+")\n" );
	        process = Runtime.getRuntime().exec( command );
	        BufferedReader b = new BufferedReader(new InputStreamReader(process.getInputStream()));

	        String temp;
	        while ( ( temp =  b.readLine()) != null ){
	            processMsg.append( temp );
	            processMsg.append( '\n' );
	        }
	        process.waitFor();

	        processMsg.append( "[" + processName + "] Process ���� ������ ���� �Ͽ����ϴ�.\n" );
	    } catch (IOException e) {
	    	processMsg.append( "\nProcess ���� ����:" + e.getMessage() );
	    } catch (InterruptedException e) {
	    	processMsg.append( "\nProcess ���� ����:" + e.getMessage() );
	    }finally{
	        process.destroy();
	    }

	    return processMsg.toString();
    }
    
    public String getCommand(){
    	return command;
    }
    
    public static void main(String[] args){
    	String command = "find /home/wareflow/data/agent/log -ctime +150 -exec rm {} \\";
    	TestProcess cmd = new TestProcess("TEST",command);
    	cmd.actionProcess();
    }
}
