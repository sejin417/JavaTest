import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class FileWriteTest {
	
	public String getWrite(String importTable){
		StringBuffer output = new StringBuffer();
		
		output.append("load data\n");
		output.append("truncate\n");
		output.append("into table ");
		output.append(importTable);
		output.append('\n');
		output.append("fields terminated by '|' \n");
		output.append("trailing nullcols \n");
		output.append("(\n");
		output.append("  SVCCONTRACTNUM                char,\n");
		output.append("  LOCATIONCODE                  char,\n");
		output.append("  STACKMODULENUM                char,\n");
		output.append("  IFNAME                        char,\n");
		output.append("  GATEWAYIP                     char,\n");
		output.append("  CUSTUPLINKIP                  char,\n");
		output.append("  ORDERSPEED                    integer external,\n");
		output.append("  CUSTOMERNAME                  char,\n");
		output.append("  LEASEDLINENUM                 char,\n");
		output.append("  CUSTID                        char,\n");
		output.append("  CUSTNAME                      char,\n");
		output.append("  CUSTEMAIL                     char,\n");
		output.append("  CUSTTELNUM                    char\n");
		output.append(")\n");

		return output.toString();
	}
	
	public void writeFile(String fileName){
		FileOutputStream output;
		try {
			output = new FileOutputStream(fileName);
			output.write(getWrite("TEST").getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){ 
		FileWriteTest fwt = new FileWriteTest();
		
		fwt.writeFile( "c:/aaaa.ctl" );
		
	}
}
