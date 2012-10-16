/*
 * AiSD, cwiczenie 2
 * Mateusz Cieciura, GR1
 */

public class HeapPQueue<T extends Comparable<T>> implements PQueue<T> {
	private T [] heap; 
	private int n; // current number of elements
	private final int INITIAL_SIZE = 32;


	@SuppressWarnings ("unchecked")	
	public HeapPQueue () {
		this.heap = (T[]) new Comparable [INITIAL_SIZE];
		this.n = 0;
	}

	public void swap (int a, int b) {
		T tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}

	@SuppressWarnings ("unchecked")	
	@Override
	public void insert (T o) {
		if (n == heap.length) {
			T [] tmp = (T[]) new Comparable [2*n];
			System.arraycopy (heap, 0, tmp, 0, n);
			heap = tmp;
		}
		
		for (int i = 0; i < n; i++)
			if (o.compareTo(heap[i]) == 0) // Nie dodajemy dwukrotnie elementow
				return;					   // o tym samym priorytecie

		//System.out.println("Dlugosc kopca=" + this.heap.length);
		//System.out.println("Liczba wypelnionych miejsc=" + this.n);
		
		heap[n] = o;

		for (int i = n; i > 0; i--)
			if (heap[i].compareTo(heap[(i-1)/2]) > 0) {
				swap (i, (i-1)/2);
		}
		n++;
		System.out.println ("+ Adding element: " + o);
	}

	@SuppressWarnings ("unchecked")	
	@Override
	public T remove () {
		T removed = heap [0];

		heap[0] = heap[n-1];

		int i = 0;
		while (2*i+1 < n) // dopoki jest chociaz jedno dziecko
			if (2*i+2 >= n) // jest tylko lewe dziecko
				if (heap[i].compareTo(heap[2*i+1]) < 0) { // jesli dziecko jest wieksze od rodzica
					swap(i, 2*i+1);
					i = 2*i+1;
				} else
					i++;
			else // jest oboje dzieci
				if (heap[i].compareTo(heap[2*i+1]) < 0 || heap[i].compareTo(heap[2*i+2]) < 0) 
				// jedno z dzieci jest wieksze od rodzica
					if (heap[2*i+1].compareTo(heap[2*i+2]) > 0) {  // lewe jest wieksze od prawego
						swap(i, 2*i+1);
						i = 2*i+1;
					} else { // prawe jest wieksze od lewego
						swap(i, 2*i+2);
						i = 2*i+2;
					}
				else
					i++;

		n--;
		
		System.out.println ("- Removed element: " + removed);
		return removed;
	}

	public void writeHeap () {
		for (int i = 0; i < n; i++)
			System.out.print (this.heap[i] + " ");
			
		System.out.print("\n"); 
	}

	public boolean isEmpty () {
			if (n == 0)
				return true;
			else
				return false;
	}
}
	
