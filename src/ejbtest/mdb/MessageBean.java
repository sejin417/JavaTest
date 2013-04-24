package ejbtest.mdb;

public class MessageBean {
	private String key;
	private int _objectCount=0;
	
	public MessageBean( String key){
		this.key = key;
	}
	
	public void start(){
		try {
			Thread.sleep(1000);
			System.out.println( "Ing~! " + key + " cnt:"+ _objectCount);
			Thread.sleep(1500);
		}catch ( Exception e){
			System.out.println( "¼³¸¶~!? " );
		}
	}

	public void setCount( int i) {
		// TODO Auto-generated method stub
		_objectCount= _objectCount + i;

	}
	
	public int getCount(){
		return _objectCount;
	}
	
	public String getKey(){
		return key;
	}
}
