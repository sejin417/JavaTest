package network;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.commons.net.ftp.FTPClient;

/**
 * FTP ���α׷��� �����ϱ� ���� Ŭ������
 * ip, user id, password, get File, write File ������ �޾�
 * Ftp �� ������ �ٿ� ������ ���Ϸ� �����ϴ� Ŭ����
 * 
 * @author �ּ���
 *
 */
public class FtpClientProcess {
	private FTPClient ftpClient = null;

	private String connectIp = null;
	private String userId = null;
	private String password = null;
	private HashMap fileList = null;

	private boolean isDeleteFile = false;
	private boolean isDeleteDirectory = false;
	//	private String[] getFileName = null;
	//	private String[] writeFileName = null;

	public FtpClientProcess( String connectIp, String userId, String password){
		ftpClient = new FTPClient();

		this.connectIp = connectIp;
		this.userId = userId;
		this.password = password;
	}

	public FtpClientProcess( String connectIp, String userId, String password, String getFileName,String writeFileName){
		this(connectIp, userId, password);

		fileList = new HashMap();
		fileList.put(getFileName, writeFileName);
/*		fileList.put("remoteFileName", getFileName);
		fileList.put("writeFileName", writeFileName);
*/	}

	public FtpClientProcess(String connectIp, String userId, String password, HashMap fileList){
		this(connectIp, userId, password);

		this.fileList = fileList;
	}

	public void setDeleteFile( boolean chk ){
		this.isDeleteFile = chk;
	}
	
	public void setDeleteDirectory( boolean chk ){
		this.isDeleteDirectory = chk;
	}

	public String start() {
		StringBuffer processMsg = new StringBuffer();

		//connect
		try{
			ftpClient.connect(connectIp);
			ftpClient.login(userId, password);
			processMsg.append("IP:"+connectIp + " ���� ����\n");
			System.out.println(processMsg);

		}catch(Exception e){
			return "�α��� ����";
		}

		//File Download
		System.out.println("(1)");
		Iterator iterator = fileList.entrySet().iterator();
		System.out.println("(2)");

		File write_file = null;
		String get_file ="";
		Entry entry;
		OutputStream outputStream = null;
		boolean r;
		System.out.println("(3)");

		//		ftpClient.listFiles();
		while(iterator.hasNext()){
			try {
				entry = (Entry)iterator.next();
				write_file = new File((String)entry.getValue());
				get_file = (String)entry.getKey();
				System.out.println((String)entry.getValue());
				System.out.println((String)entry.getKey());
				System.out.println("(4)");
				outputStream = new FileOutputStream(write_file);
				r = ftpClient.retrieveFile(get_file, outputStream);
				System.out.println("(5)");
				outputStream.close();
				System.out.println("(6)"+r);
				if ( r ) {
					System.out.println("(7)");
					processMsg.append( get_file + " ���� �Ϸ�\n");
					System.out.println(processMsg);
					if (isDeleteFile){
						ftpClient.deleteFile(get_file);
					}
				}else {
					System.out.println("(8)");
					write_file.delete();
				}
			} catch (FileNotFoundException e2) {
				System.out.println("why???");
				write_file.delete();
			} catch (IOException e) {
				System.out.println("io");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
		}

		if (isDeleteDirectory){
			try {
				ftpClient.removeDirectory(get_file.substring(0, get_file.lastIndexOf("/") ));
			} catch (IOException e) {
				processMsg.append( "���丮 ���� �� ���� �߻�");
				System.out.println("(9)");
			}
		}

		//log out
		try {
			System.out.println("(10)");
			ftpClient.logout(); 
			processMsg.append("FTP �α׾ƿ� \n");
		} catch (Exception e) {
			processMsg.append("FTP �α׾ƿ� ����:" +e.getMessage() + '\n');
		}

		if (ftpClient.isConnected()){
			try {
				ftpClient.disconnect();
				processMsg.append("FTP ���� ���� \n");
			} catch (IOException e1) {
				processMsg.append("FTP ���� ���� ����:"+ e1.getMessage() + '\n');
			}
		}

		return processMsg.toString();
	}

		//Test
		public static void main(String[] args){
		FtpClientProcess fcp = new FtpClientProcess( "10.81.204.41", "bcnnms", "1q2w3e","\\d:\\BcN_File\\98_��Ÿ�ڷ�\\WinTail.exe","d:\\remote-wsdl.xml");
		fcp.start();
		}
}

