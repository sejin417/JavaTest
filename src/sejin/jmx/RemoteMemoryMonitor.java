package sejin.jmx;


import java.lang.management.MemoryUsage;
import java.util.Iterator;
import java.util.Set;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class RemoteMemoryMonitor
{
	/**
	 * MXBean ��

Java ���� �ӽ��� �� �÷��� MXBean�� �÷��� MBeanServer ������ ����� ���ؼ� ���� ObjectName �� �����ϴ�. Java ���� �ӽ��� ������ ���� �������̽��� ������ �ν��Ͻ��� �����ϴ�.
���� �������̽�	ObjectName
ClassLoadingMXBean	java.lang:type=ClassLoading
MemoryMXBean	java.lang:type=Memory
ThreadMXBean	java.lang:type=Threading
RuntimeMXBean	java.lang:type=Runtime
OperatingSystemMXBean	java.lang:type=OperatingSystem
Java ���� �ӽ���, ������ ���� �������̽��� �ν��Ͻ��� ������ �ʴ°�, ������ �ν��Ͻ��� �����ϴ�.

���� �������̽�	ObjectName
CompilationMXBean	java.lang:type=Compilation
Java ���� �ӽ���, ������ ���� �������̽��� �ν��Ͻ��� 1 �� �̻� ���� ���� �ֽ��ϴ�.

���� �������̽�	ObjectName
GarbageCollectorMXBean	java.lang:type=GarbageCollector , name=collector's name
MemoryManagerMXBean	java.lang:type=MemoryManager , name=manager's name
MemoryPoolMXBean	java.lang:type=MemoryPool , name=pool's name

	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:3948/jmxrmi");
			JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

			MBeanServerConnection mbs_ = jmxc.getMBeanServerConnection();
			ObjectName stdOsMBeanName =
				new ObjectName("java.lang:type=OperatingSystem");

			System.out.println("-------------------------------------------------");
			System.out.println("System Arch = "
					+ mbs_.getAttribute(stdOsMBeanName, "Arch"));
			System.out.println("Number of Processors = "
					+ mbs_.getAttribute(stdOsMBeanName, "AvailableProcessors"));
			System.out.println("OS Name = "
					+ mbs_.getAttribute(stdOsMBeanName, "Name"));
			System.out.println("OS Version = "
					+ mbs_.getAttribute(stdOsMBeanName, "Version"));

			// RuntimeMBean���� ���� Runtime ������ ��ȸ�մϴ�.
			stdOsMBeanName = new ObjectName("java.lang:type=Runtime");

			System.out.println("Name = "
					+ mbs_.getAttribute(stdOsMBeanName, "Name"));         
			System.out.println("Spec Name = "
					+ mbs_.getAttribute(stdOsMBeanName, "SpecName"));
			System.out.println("VM Version = "
					+ mbs_.getAttribute(stdOsMBeanName, "VmVerion"));

			// ClassLoadingMBean ���� ���� �ε��� Ŭ���� ������ ��ȸ�մϴ�.
			stdOsMBeanName = new ObjectName("java.lang:type=ClassLoading ");

			System.out.println("Loaded Class Count = "
					+ mbs_.getAttribute(stdOsMBeanName, "LoadedClassCount"));
			System.out.println("Total Loaded Class Count = "
					+ mbs_.getAttribute(stdOsMBeanName, "TotalLoadedClassCount"));
			System.out.println("-------------------------------------------------");

			ObjectName stdMBeanName = new ObjectName("java.lang:type=Memory");

			MemoryUsage musage_ = MemoryUsage.from(
					(CompositeData) mbs_.getAttribute(stdMBeanName,
							"HeapMemoryUsage"));

			
			System.out.println("MemoryMBean ���� ���:");
			System.out.println("> HeapMemoryUsage-init = "
					+ musage_.getInit()/(1024.f) + " kbytes");
			System.out.println("> HeapMemoryUsage-max = "
					+ musage_.getMax()/(1024.f) + " kbytes");
			System.out.println("> HeapMemoryUsage-used = "
					+ musage_.getUsed()/(1024.f) + " kbytes");
			System.out.println("> HeapMemoryUsage-committed = "
					+ musage_.getCommitted()/(1024.f) + " kbytes");

			musage_ = MemoryUsage.from(
					(CompositeData) mbs_.getAttribute(stdMBeanName,
							"NonHeapMemoryUsage"));
			System.out.println("\n> NonHeapMemoryUsage-init = "
					+ musage_.getInit()/(1024.f) + " kbytes");
			System.out.println("> NonHeapMemoryUsage-max = "
					+ musage_.getMax()/(1024.f) + " kbytes");
			System.out.println("> NonHeapMemoryUsage-used = "
					+ musage_.getUsed()/(1024.f) + " kbytes");
			System.out.println("> NonHeapMemoryUsage-committed = "
					+ musage_.getCommitted()/(1024.f) + " kbytes");

			// Query
			stdMBeanName = new ObjectName("java.lang:type=MemoryPool,*");
			Set pools_ = mbs_.queryNames(null, stdMBeanName);

			Iterator itr_ = pools_.iterator();

			while(itr_.hasNext())
			{
				Object obj_ = itr_.next();
				ObjectName objName_ = (ObjectName) obj_;

				// Print Memory Pool Usage
				System.out.println("----------------------------------------------");
				System.out.println(mbs_.getAttribute(objName_, "Name")
						+ " Pool ���� ���:");
				System.out.println("Memory Type = "
						+ mbs_.getAttribute(objName_, "Type"));
				System.out.println("Memory Peak Usage:");

				musage_ = MemoryUsage.from(
						(CompositeData) mbs_.getAttribute(objName_, "PeakUsage"));
				System.out.println("> MemoryUsage-init = "
						+ musage_.getInit()/(1024.f) + " kbytes");
				System.out.println("> MemoryUsage-max = "
						+ musage_.getMax()/(1024.f) + " kbytes");
				System.out.println("> MemoryUsage-used = "
						+ musage_.getUsed()/(1024.f) + " kbytes");
				System.out.println("> MemoryUsage-committed = "
						+ musage_.getCommitted()/(1024.f) + " kbytes");

				System.out.println("\nMemory Current Usage:");
				musage_ = MemoryUsage.from(
						(CompositeData) mbs_.getAttribute(objName_, "Usage"));
				System.out.println("> MemoryUsage-init = "
						+ musage_.getInit()/(1024.f) + " kbytes");
				System.out.println("> MemoryUsage-max = "
						+ musage_.getMax()/(1024.f) + " kbytes");
				System.out.println("> MemoryUsage-used = "
						+ musage_.getUsed()/(1024.f) + " kbytes");
				System.out.println("> MemoryUsage-committed = "
						+ musage_.getCommitted()/(1024.f) + " kbytes");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
