/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CIECIURM
 */
public class ListPQueue {
    private Element head;

    public ListPQueue(Comparable a) {
        this.head = new Element(a);
    }
    
     public ListPQueue() {
       this.head = null;
    }

    public void insert(Comparable a) {
        Element newE = new Element(a);
        newE.setNext(head);
        head = newE;
        
        Element i = head;
        while (i.goNext() != null) {
            if (i.getElement().compareTo(i.goNext().getElement()) < 0) { // jesli wczesniejszy jest mniejszy
                Object tmp = new Object();
                tmp = i.goNext().getElement();
                i.goNext().setElement(i.getElement());
                i.setElement((Comparable)tmp);
            }
            i = i.goNext();
        }
        System.out.println("+ Adding element: " + a);
    }
    
    public Comparable remove() {
        Comparable removed = this.head.getElement();
        Element newHead = head.goNext();
        head = newHead;
        
        return removed;
    }

    public void writeList() {
        Element e = head;
        while (e != null) {
            System.out.print("->[" + e.getElement() + "]");
            e = e.goNext();
        }
        System.out.println("");
    }
    
    public boolean isEmpty() {
        return (this.head == null) ? true : false;
    }
}
