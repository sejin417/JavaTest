package sejin.jmx;

import java.lang.management.*;

import javax.management.*;

public class LocalMemoryMonitor {


	private MBeanServer server = null;

	public LocalMemoryMonitor() {

		server = ManagementFactory.getPlatformMBeanServer();
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
	    // or any other MBeanServer

	    ObjectName name = new ObjectName("com.example:type=Memory");
	    Object mbean = new Memory();
	    mbs.registerMBean(mbean, name);
	}

	public static void main(String argv[]) {
		LocalMemoryMonitor agent = new LocalMemoryMonitor();
		System.out.println(
				"Agent is ready... Press Enter to close");
//		try {
//			System.in.read();
//		} catch (Exception e) { 
//			e.printStackTrace();
//		}

	}
}
