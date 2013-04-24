/*
 * Created on 2005. 7. 20
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package observable;

import java.util.Observable;
import java.util.Observer;

/**
 * @author 세진
 */
public class TestObserver implements Observer{
    String name;
    
    public TestObserver(String name){
        this.name = name;
    }
    


    public static void main(String[] args) {
        TestObserver test = new TestObserver("dddd");
        TestObservable man = new TestObservable();
        
        man.addObserver( test );
        man.setName( "dfdfdfdf");
        System.out.println("종료");
    }



    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    public void update(Observable arg0, Object arg1) {
        System.out.println("update:"+ ((TestObservable)arg0).getName() );
    }
}
