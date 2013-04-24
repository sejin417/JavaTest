
public class IpConvertTest {
	public String getIp(String ipnum ){
		String binary = Long.toBinaryString( Long.parseLong(ipnum));
		String zero = "00000000000000000000000000000000";
		if (binary.length() < 32) {
		binary = zero.substring(0, 32 - binary.length()) + binary;
		}
		String ip = "";
		if ( binary.equals("0")){
			ip = "0.0.0.0";
		}else {
			ip = Integer.valueOf(binary.substring(0, 8), 2) + "."
			+ Integer.valueOf(binary.substring(8, 16), 2) + "."
			+ Integer.valueOf(binary.substring(16, 24), 2) + "."
			+ Integer.valueOf(binary.substring(24, 32), 2);
		}

		return ip.trim();
	}
	

	public String[] getTest(String[] columns){
		String tablename = "";
		String projectId = "";
		String dbTime = "";
		
		String[] insertColumns = new String[18];
		insertColumns[0] = tablename;
		insertColumns[1] = projectId;        //PROJECT_ID
		insertColumns[2] = dbTime;           //DATE_ID
		insertColumns[3] = getIp(columns[0]);//ROUTER_IP
		insertColumns[4] = getIp(columns[5]);//NODE_IP_IN
		insertColumns[5] = columns[3];       //REGION_IP_IN
		insertColumns[6] = getIp(columns[6]);//NODE_IP_OUT
		insertColumns[7] = columns[4];       //REGION_IP_OUT
		
		if (columns[7].length() >= 6)
			insertColumns[8] = columns[7].substring(0, 6);//AREA_IN
		else if (columns[7].length() > 0)
			insertColumns[8] = columns[7].substring(0, columns[7].length());//AREA_IN
		else
			insertColumns[8] = "999999";
		
		if (columns[8].length() >= 6)
			insertColumns[9] = columns[8].substring(0, 6);//AREA_OUT
		else if (columns[8].length() > 0)
			insertColumns[9] = columns[8].substring(0, columns[8].length());//AREA_OUT
		else
			insertColumns[9] = "999999";

		insertColumns[10] = columns[9];      //TRAFFIC_BYTE
		insertColumns[11] = columns[10];     //PACKET_COUNT
		insertColumns[12] = columns[11];     //FLOW_COUNT
		insertColumns[13] = columns[12];     //MEAN_TIME
		insertColumns[14] = columns[13];   //BPS
		insertColumns[15] = columns[14];   //PPS
		insertColumns[16] = columns[15];   //SRC_SERVICE_TYPE
		insertColumns[17] = columns[16];   //DES_SERVICE_TYPE

		return insertColumns;
	}
	
	public static void main(String[] args){
		IpConvertTest temp = new IpConvertTest();
		
		String[] test = new String[17];
		
		test[0]="3537826165";
		test[1]="0";
		test[2]="0";
		test[3]="2821";
		test[4]="2813";
		test[5]="2106589233";
		test[6]="2106589221";
		test[7]="323";
		test[8]="323";
		test[9]="358126565";
		test[10]="479074";
		test[11]="3817";
		test[12]="26.9";
		test[13]="26194.1";
		test[14]="34.6";
		test[15]="V";
		test[16]="V";
		
		System.out.println(  temp.getIp("3537826165") );
		
		System.out.println( temp.getTest( test ));
	}
}

