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
public class SystemCommand{
	public void runCommand(String command) {
		Process cmdProcess = null;
		InputStream inStream = null;

		try {
			System.out.println("Start Process : " + command);
			cmdProcess = Runtime.getRuntime().exec(command);
			inStream = cmdProcess.getInputStream();
		} catch (Exception e) {
			System.out.println("Can not create process...");
			e.printStackTrace();
			return;
		}

		ProcessMonitor monitor = new ProcessMonitor(inStream);

		monitor.start();

		try {
			cmdProcess.waitFor();
			
			monitor.finish();
		} catch (InterruptedException ex) {
			// do nothing
		}
		System.out.println("End Process : " + command);
	}
	
	public static void main(String[] args) {
        SystemCommand cmd = new SystemCommand();
        cmd.runCommand("ping localhost");
    }
	
	class ProcessMonitor extends Thread {
		private InputStream m_stream = null;
		private boolean m_finish = false;

		public ProcessMonitor(InputStream in) {
			m_stream = in;
		}

		public void run() {
			String line = "";
			int lineCount = 0;

			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(m_stream));

				while (!m_finish || reader.ready()) {
					line = reader.readLine();
					if (line.length() > 0) {
						System.out.println(++lineCount + " : " + line);
						print(line);
					}
				}
			} catch (Exception ex) {
			}
		}

		public void finish() {
			m_finish = true;
		}

		private void print(String line) {
		    System.out.println("#" + line);
		}
	}
	
}