import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @author Sejin
 * 
 */
public class ArrayListTest {
    
    public static void main(String[] args){
        ArrayList al = new ArrayList();
        Hashtable ht = new Hashtable();
        
        al.add("a");
        al.add("b");
        al.add("c");
        ht.put("a",al);
        
        al = new ArrayList();
        al.add("d");
        al.add("f");
        ht.put("b",al);
        
        Enumeration keyIter = ht.keys();
        String key;
        while ( keyIter.hasMoreElements()){
            key = (String)keyIter.nextElement();
            al = (ArrayList) ht.get(key);
            
            System.out.println("---------------------");
            System.out.println( key );
            
            for(int i=0;i<al.size();i++){
                System.out.println( (String)al.get(i) );
            }
        }
    }

}
