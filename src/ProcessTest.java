import java.io.IOException;
import java.io.InputStream;

/*
 * Created on 2005. 8. 28
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author ����
 */
public class ProcessTest {
    
    public static void main(String[] args) {
        String cmd="cmd /c DIR";
        Runtime rt = Runtime.getRuntime();
        Process proc;
        try {
            proc = rt.exec(cmd);
            InputStream inputT = proc.getErrorStream();  // �ش� ���μ����� ���۸� ���� ���� �ൿ..
            
            byte[] buff = new byte[1000];
            
            //System.out.println("�����");
            while(inputT.read(buff)!= -1){
                //System.out.println("���");
                String strBuff = new String(buff);
                System.out.println(strBuff);
            }
            inputT.close(); 
            proc.waitFor();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
}
