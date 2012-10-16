/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *
 * @author mateusz
 * 
 */
public class TestTime {
    public static void main(String[] args) {
        long t1, t2;
        ListPQueue list = new ListPQueue();
        
        for(int i = 1; i < 100; i++) {
            t1 = System.nanoTime();
            list.insert(i);
            t2 = System.nanoTime();
            System.err.println(i + " " + (t2-t1));
        }
    }
    
}
