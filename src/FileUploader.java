import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class FileUploader {
    private static final String boundary = "I3yQmit4fl7MPswgDI-urFp-2QovNMtWHOYQWS";
    private static final String NEWLINE  = "\r\n";
    
    public FileUploader(String actionURL, String path, String fileName, String senderSessionID) {
        HttpURLConnection httpConnection = null;
        DataOutputStream out = null;
        StringBuffer header = new StringBuffer();
        File file = null;
        FileInputStream fileIn = null;
        byte[] buffer = new byte[4096];
        int readLen = 0;
        
        try {
            file = new File(path + fileName);
            fileIn = new FileInputStream(file);
            
            // 연결및 헤더 설정
            httpConnection = (HttpURLConnection) new URL(actionURL).openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            
            out = new DataOutputStream(httpConnection.getOutputStream());
            
            // 파라미터 추가
            header.append("--" + boundary + NEWLINE);
            header.append("Content-Disposition: form-data; name=\"senderSessionID\"" + NEWLINE);
            header.append(NEWLINE);
            header.append(senderSessionID + NEWLINE);
            
            // 파일 추가
            header.append("--" + boundary + NEWLINE);
            header.append("Content-Disposition: form-data; name=\"file\"; filename=\"rc.exe\"" + NEWLINE);
            header.append("Content-Type: application/octet-stream" + NEWLINE);
            header.append("Content-Transfer-Encoding: binary" + NEWLINE);
            header.append(NEWLINE);
            
            out.write(header.toString().getBytes());
            
            ProgressBarFrame bar = new ProgressBarFrame(file.length());
            
            while ((readLen = fileIn.read(buffer)) > 0) {
                out.write(buffer, 0, readLen);
                out.flush();
                bar.addValue(readLen);
            }
            
            // 모든 데이터 전송 완료
            out.write((NEWLINE).getBytes());
            out.write(("--" + boundary + "--" + NEWLINE).getBytes());
            out.write((NEWLINE).getBytes());
            out.flush();
            
            httpConnection.getContentLength();
            
            bar.end();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileIn != null) try {
                fileIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new FileUploader("http://localhost/preupload.do", "d:/", "rc.exe", "test");
        //new FileUploader("http://localhost/common_inc/preuploader/up.jsp", "d:/", "rc.exe", "test");
    }
    
    class ProgressBarFrame extends JFrame {
        private static final long serialVersionUID = -6773846346782905638L;
        JProgressBar              bar              = new JProgressBar();
        int                       values           = 0;
        
        public ProgressBarFrame(long maxValue) {
            bar.setMaximum((int) maxValue);
            
            this.getContentPane().add(bar);
            
            this.setSize(300, 50);
            this.setVisible(true);
        }
        
        public void addValue(int value) {
            values += value;
            bar.setValue(values);
        }
        
        public void end() {
            this.setVisible(false);
            System.exit(0);
        }
    }
}
