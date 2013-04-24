package cron;

 /**
 * <PRE>
 * <b>Title:</b> 
 * <b>
 * </b>
 *
 * <b>Copyright:</b> Copyright (c) 2012
 * <b>Company:</b> kt
 * <b>Version:</b> 1.0
 * </PRE>
 * @author user_email@email.com
 * @history <li> </li>
 */
public class CopyStringMethodTest {
	String aaa;
	String bbb;

	/**
	 * @return the aaa
	 */
	public String getAaa() {
		return aaa;
	}

	/**
	 * @param aaa the aaa to set
	 */
	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	/**
	 * @return the bbb
	 */
	public String getBbb() {
		return bbb;
	}

	/**
	 * @param bbb the bbb to set
	 */
	public void setBbb(String bbb) {
		this.bbb = bbb;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyStringMethodTest a = new CopyStringMethodTest();
		a.setAaa("AAA");
		CopyStringMethodTest b = new CopyStringMethodTest();
		b.setAaa("BBB");
		System.out.println ( b.getAaa() +";" + a.getAaa());
		
		b.setAaa( a.getAaa());

		System.out.println ( b.getAaa() +";" + a.getAaa());
		a.setAaa("CCC");
		
		System.out.println ( b.getAaa() +";" + a.getAaa());
	}

}
