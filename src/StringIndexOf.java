
public class StringIndexOf {
	public String logFiltering(String msg){
		String returnMsg = "Commit point reached";
		StringBuffer filterMsg = new StringBuffer();
		int index = msg.indexOf(returnMsg);
		
		boolean isFirst = true;
		int tempIndex = 0;
		int size = msg.length();
		
		while(index >= 0){
			
			if (isFirst){
				filterMsg.append( msg.substring(0,index - 1));
				isFirst= false;
			}

			tempIndex = index;
			
			index = msg.indexOf( returnMsg , tempIndex+returnMsg.length());
		}
		filterMsg.append( msg.substring(tempIndex, msg.length()) );
		return filterMsg.toString();
	}
	
	public static void main(String[] args){
		StringIndexOf sio = new StringIndexOf();
		
		StringBuffer temp = new StringBuffer();
		
		temp.append("SQL*Loader: Release 9.2.0.4.0 - Production on Wed Oct 18 15:12:04 2006");
		temp.append(" ");
		temp.append("Copyright (c) 1982, 2002, Oracle Corporation.  All rights reserved.");
		temp.append(" ");
		temp.append("Commit point reached - logical record count 58");
		temp.append("Commit point reached - logical record count 116");
		temp.append("Commit point reached - logical record count 174");
		temp.append("Commit point reached - logical record count 232");
		temp.append("Commit point reached - logical record count 290");
		temp.append("Commit point reached - logical record count 348");
		temp.append("Commit point reached - logical record count 406");
		temp.append("Commit point reached - logical record count 464");
		temp.append("Commit point reached - logical record count 522");
		temp.append("Commit point reached - logical record count 580");
		temp.append("Commit point reached - logical record count 638");
		temp.append("Commit point reached - logical record count 696");
		temp.append("Commit point reached - logical record count 754");
		temp.append("Commit point reached - logical record count 812");
		temp.append("Commit point reached - logical record count 870");
		temp.append("Commit point reached - logical record count 928");
		temp.append("Commit point reached - logical record count 986");
		temp.append("Commit point reached - logical record count 1044");
		temp.append("Commit point reached - logical record count 1102");
		temp.append("Commit point reached - logical record count 1160");
		temp.append("Commit point reached - logical record count 1218");
		temp.append("Commit point reached - logical record count 1276");
		temp.append("Commit point reached - logical record count 1334");
		temp.append("Commit point reached - logical record count 1392");
		temp.append("Commit point reached - logical record count 1450");
		temp.append("Commit point reached - logical record count 1508");
		temp.append("Commit point reached - logical record count 1566");
		temp.append("Commit point reached - logical record count 1624");
		temp.append("Commit point reached - logical record count 1682");
		temp.append("Commit point reached - logical record count 1740");
		temp.append("Commit point reached - logical record count 1798");
		temp.append("Commit point reached - logical record count 1856");
		temp.append("Commit point reached - logical record count 1914");
		temp.append("Commit point reached - logical record count 1972");
		temp.append("[RAW Data Import] Process ¿Ï·á");
		System.out.println(sio.logFiltering(temp.toString()));
	}
}
