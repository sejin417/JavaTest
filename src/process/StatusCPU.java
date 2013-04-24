package process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StatusCPU {
	float cpuIdle =0f;
	float cpuuser =0f;
	float cpuKernel =0f;
	float cpuIOWait =0f;
	float cpuSwap =0f;
	
	String memoryPhys;
	String memoryFree;
	String memoryTotSwap;
	String memoryFreeSwap;
	
	private ServerStatesInfo actionProcess2(){
		ServerStatesInfo data = new ServerStatesInfo();
		String command = "/user1/bcnnms/noms/bin/top -n";
		int startPoint=0,endPoint=0;

		float cpuIdle =0f;
		float cpuUser =0f;
		float cpuKernel =0f;
		float cpuIOWait =0f;
		float cpuSwap =0f;

		String memoryPhys = null;
		String memoryFree = null;
		String memoryTotSwap = null;
		String memoryFreeSwap = null;

		String temp = 
		"[2007-05-03 17:26:08] DEBUG - load averages:  2.00,  1.84,  1.54;                    up 80+07:39:40  17:26:08\n" +
		"232 processes: 226 sleeping, 1 zombie, 4 stopped, 1 on cpu\n" +
		"CPU states: 76.4% idle, 10.3% user,  2.2% kernel, 11.1% iowait,  0.0% swap\n" +
		"Memory: 8192M phys mem, 1919M free mem, 10G total swap, 10G free swap\n" +
		"\n" +
		" PID USERNAME LWP PRI NICE  SIZE   RES STATE    TIME    CPU COMMAND\n" +
		"17279 bcnnms   252  59    0  390M  286M sleep   14:17  7.48% appservDAS\n" +
		" 27983 oracle    17  59    0 1621M 1528M sleep  135:57  0.72% oracle\n" +
		" 20694 bcnnms     1  55    0 2440K 1544K cpu/3    0:00  0.72% top\n" +
		" 19291 bcnnms   151  59    0  737M  366M sleep   92:59  0.48% appservDAS\n" +
		" 17416 oracle     1  59    0 1607M 1534M sleep    0:34  0.24% oracle\n" +
		" 17412 oracle     1  59    0 1607M 1534M sleep    0:29  0.24% oracle\n" +
		" 17406 oracle     1  59    0 1607M 1535M sleep    0:27  0.24% oracle\n" +
		" 17426 oracle     1  59    0 1607M 1534M sleep    0:24  0.24% oracle\n" +
		"  2068 adaptor   52  59    0  533M  310M sleep  721:48  0.00% java\n" +
		" 29289 bcnnms   125  59    0  419M  250M sleep   98:12  0.00% java\n" +
		"   229 root      14  59    0 3608K 1680K sleep   85:44  0.00% syslogd\n" +
		" 24025 adaptor  105  59    0  339M  197M sleep   63:34  0.00% java\n" +
		" 18021 bcnnms   131  59    0  440M  324M sleep   58:41  0.00% java\n" +
		"   252 root      48  59    0 3392K 2256K sleep   52:46  0.00% nscd\n" +
		" 27985 oracle    21  59    0 1611M 1529M sleep   48:30  0.00% oracle\n";
		
		int cpuIndex = temp.indexOf( "CPU states:" );
		if ( cpuIndex > -1 ) {
			startPoint = cpuIndex + 12;
			endPoint = temp.indexOf("%",startPoint);
			cpuIdle = Float.parseFloat( temp.substring(startPoint, endPoint));

			startPoint = endPoint + 8;
			endPoint = temp.indexOf("%",startPoint);
			cpuUser = Float.parseFloat( temp.substring(startPoint, endPoint));

			startPoint = endPoint + 7;
			endPoint = temp.indexOf("%",startPoint);
			cpuKernel = Float.parseFloat( temp.substring(startPoint, endPoint));

			startPoint = endPoint + 10;
			endPoint = temp.indexOf("%",startPoint);
			cpuIOWait = Float.parseFloat( temp.substring(startPoint, endPoint));

			startPoint = endPoint + 10;
			endPoint = temp.indexOf("%",startPoint);
			cpuSwap = Float.parseFloat( temp.substring(startPoint, endPoint));
		}

		//Memory 찾기
		int memoIndex = temp.indexOf( "Memory:" );
		if ( memoIndex > -1 ) {
			startPoint = memoIndex + 8;
			endPoint = temp.indexOf(" ",startPoint);
			memoryPhys = temp.substring(startPoint, endPoint);

			startPoint = endPoint + 11;
			endPoint = temp.indexOf(" ",startPoint);
			memoryFree = temp.substring(startPoint, endPoint);

			startPoint = endPoint + 11;
			endPoint = temp.indexOf(" ",startPoint);
			memoryTotSwap = temp.substring(startPoint, endPoint);

			startPoint = endPoint + 13;
			endPoint = temp.indexOf(" ",startPoint);
			memoryFreeSwap = temp.substring(startPoint, endPoint);
		}

		data.setCpuUser(cpuUser);
		data.setCpuKernel(cpuKernel);
		data.setCpuIowait(cpuIOWait);
		data.setCpuSwap(cpuSwap);

		data.setMemPhys(convertMByte(memoryPhys));
		data.setMemFree(convertMByte(memoryFree));
		data.setMemTotSwap(convertMByte(memoryTotSwap));
		data.setMemFreeSwap(convertMByte(memoryFreeSwap));
		
		return data;
	}
	
	private long convertMByte( String msg ){
		char type = msg.charAt( msg.length() - 1 );
		long value = Long.parseLong( msg.substring(0, msg.length()-1) );
		long result = 0;

		try {
			switch ( type ){
			case 'M':
				result = value;
				break;
			case 'G':
				result = value * 1024;
				break;
			case 'K':
				result = value/1024;
				break;
			case 'B':
				result = value/1024/1024;
				break;
			default:
				break;
			}
		}catch( Exception e){
			result = -1;
		}

		return result;
	}
	
    private boolean actionProcess(String command) {
        int startPoint=0,endPoint=0;

	    Process process = null;
	    StringBuffer processMsg = new StringBuffer();
	    try {
	    	process = Runtime.getRuntime().exec( "cmd /c"+ command );
	        BufferedReader b = new BufferedReader(new InputStreamReader(process.getInputStream()));

	        String temp;
	        while ( ( temp =  b.readLine()) != null ){
	        	
	            processMsg.append( temp );
	            processMsg.append( '\n' );
	        }
	        process.waitFor();
			
//	        temp = "load averages:  1.86,  1.75,  1.81;                    up 80+00:32:39  10:19:07\n" +
//	        		"196 processes: 194 sleeping, 1 zombie, 1 on cpu\n"+
//	        		"CPU states: 83.0% idle, 14.6% user,  2.2% kernel,  0.2% iowait,  0.0% swap\n"+
//	        		"Memory: 8192M phys mem, 1998M free mem, 10G total swap, 10G free swap";

	        //CPU 찾기
	        int cpuIndex = temp.indexOf( "CPU states:" );
	        if ( cpuIndex > -1 ) {
	        	startPoint = cpuIndex + 12;
	        	endPoint = temp.indexOf("%",startPoint);
	        	cpuIdle = Float.parseFloat( temp.substring(startPoint, endPoint));

	        	startPoint = endPoint + 8;
	        	endPoint = temp.indexOf("%",startPoint);
	        	cpuuser = Float.parseFloat( temp.substring(startPoint, endPoint));

	        	startPoint = endPoint + 7;
	        	endPoint = temp.indexOf("%",startPoint);
	        	cpuKernel = Float.parseFloat( temp.substring(startPoint, endPoint));

	        	startPoint = endPoint + 10;
	        	endPoint = temp.indexOf("%",startPoint);
	        	cpuIOWait = Float.parseFloat( temp.substring(startPoint, endPoint));

	        	startPoint = endPoint + 10;
	        	endPoint = temp.indexOf("%",startPoint);
	        	cpuSwap = Float.parseFloat( temp.substring(startPoint, endPoint));
	        }
	        
	        //Memory 찾기
	        int memoIndex = temp.indexOf( "Memory:" );
	        if ( memoIndex > -1 ) {
	        	startPoint = memoIndex + 8;
	        	endPoint = temp.indexOf(" ",startPoint);
	        	memoryPhys = temp.substring(startPoint, endPoint);

	        	startPoint = endPoint + 11;
	        	endPoint = temp.indexOf(" ",startPoint);
	        	memoryFree = temp.substring(startPoint, endPoint);

	        	startPoint = endPoint + 11;
	        	endPoint = temp.indexOf(" ",startPoint);
	        	memoryTotSwap = temp.substring(startPoint, endPoint);

	        	startPoint = endPoint + 13;
	        	endPoint = temp.indexOf(" ",startPoint);
	        	memoryFreeSwap = temp.substring(startPoint, endPoint);
	        }
	        
	        
	    } catch (IOException e) {
	    	return false;
	    } catch (InterruptedException e) {
	    	return false;
	    }finally{
	        if (process != null) process.destroy();
	    }
	    return true;
    }
    
	public static void main(String[] args){
		String command = "top -n";
//		String command = "cmd /cdir";
		StatusCPU cmd = new StatusCPU();
		System.out.println(cmd.actionProcess2());
//    	if ( cmd.actionProcess2() ) {
//    		System.out.println( "cpuIdle:" + cmd.cpuIdle );
//    		System.out.println( "cpuIdle:" + cmd.cpuuser );
//    		System.out.println( "cpuIdle:" + cmd.cpuKernel );
//    		System.out.println( "cpuIdle:" + cmd.cpuIOWait );
//    		System.out.println( "cpuIdle:" + cmd.cpuSwap );
//    		
//    		System.out.println( "memoryPhys:" + cmd.memoryPhys );
//    		System.out.println( "memoryFree:" + cmd.memoryFree );
//    		System.out.println( "memoryTotSwap:" + cmd.memoryTotSwap );
//    		System.out.println( "memoryFreeSwap:" + cmd.memoryFreeSwap );
//    	}
//    	
	}
}
