package ejbtest.mdb;

public class TestBean {
	int a;
	public TestBean(int a){
		this.a = a;
	}
	
	public int getSleepTime(){
		return a;
	}
}
