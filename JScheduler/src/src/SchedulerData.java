/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author mateusz
 */
public interface SchedulerData {
    public void add (Job a);    
    public Job remove ();
    public void changePriority (int id, int priority);    
}
