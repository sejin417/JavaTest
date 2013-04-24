/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nio.sejin.chatserver.queue;

import nio.sejin.chatserver.event.Job;

/**
 *
 * @author 세진
 */
public interface Queue {
    public Job pop(int eventType );
    public void push(Job job);
}
