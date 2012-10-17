/*
 * AiSD, cwiczenie 2
 * Mateusz Cieciura, GR1
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestTime {
	public static void main (String [] args) throws IOException {
		BufferedWriter out = new BufferedWriter (new FileWriter ("heap.adding.log"));
        	long t1, t2;
        	int i;
		
		HeapPQueue<Integer> hpq = new HeapPQueue<Integer> ();
		
		
		for (i = 1; i < 1000; i++) {
 			t1 = System.nanoTime();
			hpq.insert (i);
			t2 = System.nanoTime();
			out.write(i + " " + (t2-t1) + "\n");
		}
		out.close();

		BufferedWriter out2 = new BufferedWriter (new FileWriter ("heap.removing.log"));
	
		while ( !hpq.isEmpty() )  {
 			t1 = System.nanoTime();
			hpq.remove();
 			t2 = System.nanoTime();
			out2.write(i + " " + (t2-t1) + "\n");
			i--;
		}
		out2.close();
	}	
}
