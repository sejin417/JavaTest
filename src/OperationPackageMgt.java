

import java.util.HashMap;

/**
 * 프로젝트가 진행중인 리스트를 관리
 * 프로젝트가 시작되면 해당 프로젝트의 패키지 명과, 라우터 명 등의 정보를 관리하고
 * 프로젝트가 종료되면 정보를 삭제 및 기록을 위한 자료를 DB에 저장한다.
 * @author Sejin
 *
 */
public class OperationPackageMgt {
	private static OperationPackageMgt instance = null;
	
	//프로젝트 Id가 key인 테이블
	private HashMap projectInfoTable = null;

	private OperationPackageMgt(){
		projectInfoTable = new HashMap();
	}

    /**
     * Singleton 패턴을 이용하여 Instance를 넘겨주는 메소드
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
     * 종료시 instance 를 null 로 변경;
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
