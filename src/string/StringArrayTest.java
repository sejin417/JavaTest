package string;

import java.rmi.RemoteException;

public class StringArrayTest {
	public static void main(String[] args){
		DistributionDiagram result = new DistributionDiagram ();

		String[][] sampleData = { 
				{ "JNSC01963" ,"JJJJ00015", "1"},
				{ "JNMP01914" ,"JJJJSJ01T", "1"},
				{ "SLJL03103" ,"JJJJ00015", "1"},
				{ "JJJJ00015" ,"SLJL04577", "2"},
				{ "JJJJ00015" ,"GGSW04379", "2"},
				{ "JJJJSJ01T" ,"GGSW04379", "2"},
				{ "JJJJSJ01T" ,"CBCJ03615", "2"},
				{ "JJJJSJ01T" ,"CNDJ00008", "2"}
		};

		
    		for ( int i=0;i<sampleData.length; i++){
    			result.setLink(sampleData[i][0], sampleData[i][1], Integer.parseInt(sampleData[i][2]));

    			//소스 장비가 등록되어 있는지 확인후 입력
    			if ( !result.isEquipment( sampleData[i][0] )){
    				BcNSystem temp = new BcNSystem();
    				temp.setEquipmentID(sampleData[i][0]);
    				result.setSystem( temp );
    			}

    			//타겟 장비가 등록되어 있는지 확인후 입력
    			if ( !result.isEquipment( sampleData[i][1] )){
    				BcNSystem temp = new BcNSystem();
    				temp.setEquipmentID(sampleData[i][0]);
    				result.setSystem( temp );
    			}
    			System.out.println(result.toString());
    		}
    		
			String[] temp = result.getLabelList(1);
			for( int i=0;i< temp.length;i++){
				System.out.println("LEVEL [1]::"+temp[i]);
			}

	}
}
