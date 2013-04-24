package string;

public class EndsWithTest {
	public static void main(String[] args){
/*		String file = "/ipflow/ip/flow";
		
		file.lastIndexOf("/");
		System.out.println( file.substring(0, file.lastIndexOf("/")));*/
		
		String equipmentModel = "ANYMED111_S";
		
		equipmentModel = equipmentModel.substring(0,equipmentModel.length()-2 );
		System.out.println(equipmentModel);
		
		equipmentModel = "ACEMAP11_S";
		
		equipmentModel = equipmentModel.substring(0,equipmentModel.length()-2 );
		System.out.println(equipmentModel);
	}
}
