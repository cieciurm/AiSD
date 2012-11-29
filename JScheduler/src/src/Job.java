/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author mateusz
 */
public class Job {
    private int id;
    private int priority;
    
    public Job (int i, int p) {
        this.id = i;
        this.priority = p;
    }
    
    public Job () {
        this.id = -1;
        this.priority = -1;
    }
    
    public int getId () {
        return this.id;
    }
    
    public int getPriority () {
        return this.priority;
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public void setPriority (int priority) {
        this.priority = priority;
    }
    
    @Override
    public String toString () {
        return "#" + this.id + " p:" + this.priority;
    }
    
    public static void main(String[] args) {
        Job a = new Job();
        Job b = new Job(1,5);
        System.out.println(a);
        System.out.println(b);
    }
}
