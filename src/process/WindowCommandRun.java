package process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WindowCommandRun {
	private String command = null;
	private String processName = null;
	
	public WindowCommandRun(String processName, String command) {
		this.command = command;
		this.processName = processName;
	}

    public String actionProcess() {
	    Process process = null;
	    StringBuffer processMsg = new StringBuffer();
	    try {
	    	processMsg.append(  "[" + processName + "] Process �� �����մϴ�.  (��ɾ�:"+command+")\n" );
	        process = Runtime.getRuntime().exec( "cmd /c"+ command );
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
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String command = "dir";
		WindowCommandRun cmd = new WindowCommandRun("TEST",command);
    	System.out.println ( cmd.actionProcess());
	}

}
