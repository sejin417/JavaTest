/*
 * Copyright 2006 KT ALL RIGHTS RESERVED
 *
 * Copyright 2006 Korea Telecom ALL RIGHTS RESERVED
 * ���ϸ�: Note.java
 * �ۼ�����/�ۼ��� : 2006.08.21������
 *
 * UC�� : ��ƿ
 * ���� : ���� ������ ��� entity Ŭ����
 * Ư¡ : 
 *
 * ============================================================================
 * ���� ����
 * NO   ��������    ������  ��������
 * ============================================================================
*/

package arraylist;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * ���� ������ ��� entity Ŭ����
 * @author ������
 * @version 1.1
 */
public class Note implements java.io.Serializable
{
	
	// ���ۻ��¿� Ȯ�ο��ο� ���� �����
	public final static int OK = 0;
	public final static int NOT_OK = 1;
	
	private String      sendUserID     = null;  //������ ������ ����� ID
	private String      sendUserName   = null;  //������ ������ ����� �̸�
	private Timestamp   sendTime       = null;  //������ ������ �ð�
	private String      sendMessage    = null;  //���� ����
	private String      replyMessage  = null;  //���� ����
	private int         sendStatus     = 0;     //���ۻ���
	private int         confirm        = 0;     //Ȯ�ο���
	private String      noteID         = null;  //���� ID
	
	//÷�� ���� �߰�
	private String serverIp;
	private String userId;
	private String passwd;
	private ArrayList<String> fileList = new ArrayList();  //÷�� ���� ����Ʈ

    /**
    * Sets the sendUserID attribute
    * @param sendUserID String
    */
    public void setSendUserID(String sendUserID)
    {
        this.sendUserID = sendUserID;
    }

    /**
    * Returns the sendUserID
    * @return String
    */
    public String getSendUserID()
    {
        return this.sendUserID;
    }

    /**
    * Sets the sendUserName attribute
    * @param sendUserName String
    */
    public void setSendUserName(String sendUserName)
    {
        this.sendUserName = sendUserName;
    }

    /**
    * Returns the sendUserName
    * @return String
    */
    public String getSendUserName()
    {
        return this.sendUserName;
    }

    /**
    * Sets the message attribute
    * @param messaage String
    */
    public void setSendMessage(String sendMessage)
    {
        this.sendMessage=sendMessage;
    }

    /**
    * Returns the message
    * @return String
    */
    public String getSendMessage()
    {
        return this.sendMessage;
    }
    
    public void setReplyMessage(String replyMessage)
    {
        this.replyMessage=replyMessage;
    }

    /**
    * Returns the message
    * @return String
    */
    public String getReplyMessage()
    {
        return this.replyMessage;
    }

    /**
    * Sets the sendTime attribute
    * @param sendTime Timestamp
    */
    public void setSendTime(Timestamp sendTime)
    {
        this.sendTime = sendTime;
    }

    /**
    * Returns the sendTime
    * @return Timestamp
    */
    public Timestamp getSendTime()
    {
        return this.sendTime;
    }

    /**
     * Sets the confirm attribute
     * @param confirm int
     */
     public void setConfirm(int confirm)
     {
         this.confirm = confirm;
     }

     /**
     * Returns the confirm
     * @return int
     */
     public int getConfirm()
     {
         return this.confirm;
     }
     
     /**
     * Sets the sendStatus attribute
     * @param sendStatus int
     */
     public void setSendStatus(int sendStatus)
     {
         this.sendStatus = sendStatus;
     }

     /**
     * Returns the sendStatus
     * @return int
     */
     public int getSendStatus()
     {
         return this.sendStatus;
     }
     
     /**
    * Sets the noteID attribute
    * @param noteID String
    */
    public void setNoteID(String noteID)
    {
        this.noteID=noteID;
    }

    /**
    * Returns the noteID
    * @return String
    */
    public String getNoteID()
    {
        return this.noteID;
    }
    
    //////////////////////////////////////
    // ÷�� ��� �߰� 
    //////////////////////////////////////
    /**
     * Returns ÷�� ���� List ����
     * @return String
     */
    public boolean isFile(){
    	return (fileList.size()>0?true:false);
    }

    public void addFile(String path){
    	this.fileList.add(path);
    }

    public void delFile(String path){
    	String temp;
    	for( int i=0;i<fileList.size();i++){
    		temp = fileList.get(i);
    		
    		if ( temp.equals( path ) ) { 
    			fileList.remove(i);
    			break;
    		}
    	}
    }

    /**
     * Returns the File List
     * @return String
     */
    public String[] getFiles(){
    	String[] result = new String[fileList.size()];
    	
    	fileList.toArray(result);
    	return result;
    }
    
    public void setFtp( String serverIp, String userId, String passwd){
    	this.serverIp = serverIp;
    	this.userId = userId;
    	this.passwd = passwd;
    }
    
    public String getServerIp(){
    	return this.serverIp;
    }
    
    public String getUserId(){
    	return this.userId;
    }
    
    public String getPasswd(){
    	return this.passwd;
    }
    
    public String toString(){
    	StringBuffer result = new StringBuffer();

    	result.append("\nNote sendUserID:"+sendUserID);
    	result.append("\n     sendUserName:"+sendUserName);
    	result.append("\n     sendTime:"+sendTime);
    	result.append("\n     replyMessage:"+replyMessage);
    	result.append("\n     confirm:"+confirm);
    	result.append("\n     noteID:"+noteID);
    	if ( isFile() ){
    		result.append("\n     fileSize:"+fileList.size());
    		String[] temp = this.getFiles();
    		for( int i=0;i<temp.length;i++) {
    			result.append("\n             :"+temp[i]);
    		}
    	}
    	return result.toString();
    }
}
