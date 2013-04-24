/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.event;

import java.util.Map;

/**
 *
 * @author 세진
 */
public class Job {

    private int eventType;
    private Map session = null;

    public Job(){

    }

    public Job(int eventType, Map session) {
        this.eventType = eventType;
        this.session = session;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session ) {
        this.session = session;
    }
    
    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType){
        this.eventType = eventType;
    }

}
