package ftp;
	
	import java.io.IOException;
	import java.net.SocketException;
	
	import org.apache.commons.net.ftp.*;
	
	public class FtpFileListTest {
	
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			FTPClient ftpClient = new FTPClient();
			String serverIP = "10.81.204.21";
			String userID = "bcnnms";
			String passwd = "bcnnms1234";
			String path = "/user1/bcnnms/linkage/PREMIUM/DATA";
			
			ftpClient = new FTPClient();
			try {
				FTPClientConfig config = new FTPClientConfig( FTPClientConfig.SYST_MVS );

				ftpClient.connect(serverIP);
				ftpClient.configure(config);

				System.out.println("연결");
				ftpClient.login(userID, passwd);
				System.out.println("Login");

				FTPFile[] files = ftpClient.listFiles(path);

				System.out.println("file 검색");

				if ( files == null ){ 
					System.out.println("파일리스트 없음");
					return;
				}

				for(int i=0;i<files.length;i++){
					System.out.print(i);
					System.out.print(files[i].getType() );
					System.out.print(files[i].isFile() );
					System.out.print("  " +files[i].getName());
					System.out.println("  " +files[i].getUser());
				}
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			} finally {
				try {
					ftpClient.quit();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	}
