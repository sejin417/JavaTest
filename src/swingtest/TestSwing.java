package swingtest;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TestSwing extends JFrame {
	public TestSwing (){
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		
	}
	
	public static void main(String[] args){
		TestSwing test = new TestSwing();
		test.setBounds( 300,300,100,100 );
		test.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		test.setVisible(true);
	}
}
