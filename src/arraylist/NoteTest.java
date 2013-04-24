package arraylist;

public class NoteTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Note note = new Note();
//		
		note.addFile("AAA.xml");
		note.addFile("CCC.xml");
		note.addFile("DDD.xml");
		
		if ( note.isFile() ){
			System.out.println("AA");
		}else {
			System.out.println("Bb");
		}
		
		String[] result = note.getFiles();
		for( int i=0;i<result.length;i++){
			System.out.println( result[i] );
		}
	}

}
