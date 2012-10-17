
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter (new FileWriter ("list.adding.log"));
        long t1, t2;
        int i;
        ListPQueue list = new ListPQueue();
        
        for(i = 1; i < 1000; i++) {
            t1 = System.nanoTime();
            list.insert(i);
            t2 = System.nanoTime();
            out.write(i + " " + (t2-t1) + "\n");
            //System.err.println(i + " " + (t2-t1));
        }
        out.close();
        
        BufferedWriter out2 = new BufferedWriter (new FileWriter ("list.removing.log"));

        while (!list.isEmpty()) {
            t1 = System.nanoTime();
            list.remove();
            t2 = System.nanoTime();
            out2.write(i + " " + (t2-t1) + "\n");
            i--;
        }
        out2.close();
    }
}

