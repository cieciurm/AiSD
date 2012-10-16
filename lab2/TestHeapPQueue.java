/*
 * AiSD, cwiczenie 2
 * Mateusz Cieciura, GR1
 */

public class TestHeapPQueue {
	public static void main (String [] args) {
		
		System.out.println("\nAlgorytmy i struktury danych 2012/2013 - Laboratorium");
		System.out.println("               Cwiczenie 2");
		System.out.println("            Mateusz Cieciura, GR1");
		
		System.out.println("\n\tQueue #1:");
			
		HeapPQueue<Integer> hpq = new HeapPQueue<Integer> ();

		hpq.insert (11);
		hpq.insert (18);
		hpq.insert (5);
		hpq.insert (2);
		hpq.insert (666); 
		hpq.insert (1337); 


		//hpq.writeHeap();
	
		while ( !hpq.isEmpty() ) 
			hpq.remove();
				
		System.out.println("\n\tQueue #2:");

		HeapPQueue<String> hpq2 = new HeapPQueue<String> ();

		hpq2.insert ("ala");
		hpq2.insert ("Ala");
		hpq2.insert ("ZOSIA");
		hpq2.insert ("Zosia");
		 
		//hpq2.writeHeap ();

		while ( !hpq2.isEmpty() )
			hpq2.remove();
	}	
}
