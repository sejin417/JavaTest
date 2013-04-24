/*
 * Created on 2005. 7. 20
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package observable;

import java.util.Observable;

/**
 * @author ¼¼Áø
 */
public class TestObservable extends Observable {
    String name = "test";
    
    public void setName(String name){
        this.name = name;
        setChanged();
        notifyObservers();
    }
    
    public String getName(){
        return this.name;
    }
}
