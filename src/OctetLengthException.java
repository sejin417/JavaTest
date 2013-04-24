/*
 * Created on 2005. 7. 27
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/**
 * @author 세진
 */
public class OctetLengthException extends Exception {
    public OctetLengthException(){
        super( "Data 의 길이가 8byte보다 큼니다" );    
    }
    public OctetLengthException(String s){
        super(s);
    }
}
