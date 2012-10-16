/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CIECIURM
 */
public class Element {
    private Comparable e;
    private Element next;
    
    public Element () {
        this.e = -1;
        this.next = null;
    }
    
    public Element (Comparable a) {
        this.e = a;
        this.next = null;
    }
    
    public void setElement (Comparable a) {
        this.e = a;
    }    
    
    public Comparable getElement () {
        return this.e;
    }
    
    public Element getNext () {
        return this.next;
    }
    
    public void setNext (Element e) {
        this.next = e;
    }
    
    public Element goNext () {
        return this.next;
    }
    
   public static void main (String [] args) {
        Element e = new Element (7);
        Element e2 = new Element (10);
        Element e3 = new Element (12);
        Element e4 = new Element (17);
        Element head = e;
        
        e.setNext( e2 );
        e2.setNext( e3 );
        e3.setNext( e4 );
  
        while (head != null) {
            System.out.println (head.e);
            head = head.goNext();
            //head = head.next;
        }
     }
}