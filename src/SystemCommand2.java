/*
 * Created on 2005. 6. 23.
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import java.io.*;
/**
 * @author merkebi
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SystemCommand2{
	public void runCommand(String command) {
		Process cmdProcess = null;
		InputStream inStream = null;
		byte[] buffer = null;

		try {
			System.out.println("Start Process : " + command);
			cmdProcess = Runtime.getRuntime().exec(command);
			inStream = cmdProcess.getInputStream();
			inStream.read( buffer );
			System.out.println( buffer.toString() );
		} catch (Exception e) {
			System.out.println("Can not create process...");
			e.printStackTrace();
			return;
		}

		System.out.println("End Process : " + command);
	}
	
	public static void main(String[] args) {
        SystemCommand cmd = new SystemCommand();
        cmd.runCommand("dir");
    }
}