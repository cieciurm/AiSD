/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CIECIURM
 */
public class List {
    private Element head;
    
    public List (Comparable a) {
        head = new Element (a);
    }
    
    public void insert (Comparable a) {
        Element newE = new Element (a);
        newE.setNext(head);
        head = newE;
    }
    
    public void writeList () {
        while (this.head != null) {
            System.out.println (this.head.getElement());
            this.head = this.head.goNext();
        }   
    }
    
    public static void main (String [] args) {
        List list = new List (7);
        list.insert (10);
        list.insert (12);
        list.insert (6);

        //System.out.println (list.head.getElement());
        //System.out.println (list.head.getNext());
        
        list.writeList();
        
        //System.out.println( list.head.getElement() );
        
        
    }
    
}
