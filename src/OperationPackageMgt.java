

import java.util.HashMap;

/**
 * ������Ʈ�� �������� ����Ʈ�� ����
 * ������Ʈ�� ���۵Ǹ� �ش� ������Ʈ�� ��Ű�� ���, ����� �� ���� ������ �����ϰ�
 * ������Ʈ�� ����Ǹ� ������ ���� �� ����� ���� �ڷḦ DB�� �����Ѵ�.
 * @author Sejin
 *
 */
public class OperationPackageMgt {
	private static OperationPackageMgt instance = null;
	
	//������Ʈ Id�� key�� ���̺�
	private HashMap projectInfoTable = null;

	private OperationPackageMgt(){
		projectInfoTable = new HashMap();
	}

    /**
     * Singleton ������ �̿��Ͽ� Instance�� �Ѱ��ִ� �޼ҵ�
     * @return
     */
    public static OperationPackageMgt getInstance() {
        if (instance == null) {
            synchronized (OperationPackageMgt.class) {
                if (instance == null) {
                    instance = new OperationPackageMgt();
                }
            }
        }
        return instance;
    }
    
    /**
     * ����� instance �� null �� ����;
     *
     */
    public static void removeInstance(){
    	instance = null;
    }
    
    public String getString(){
    	return "TEST";
    }

    public void endProject(String projectId){
    	projectInfoTable.remove(projectId);
    	
    }
}
