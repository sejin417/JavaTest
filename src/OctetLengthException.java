/*
 * Created on 2005. 7. 27
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/**
 * @author ����
 */
public class OctetLengthException extends Exception {
    public OctetLengthException(){
        super( "Data �� ���̰� 8byte���� ŭ�ϴ�" );    
    }
    public OctetLengthException(String s){
        super(s);
    }
}
