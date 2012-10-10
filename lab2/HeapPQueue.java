/*
 * AiSD, cwiczenie 2
 * Mateusz Cieciura, GR1
 */

public class HeapPQueue<T extends Comparable<T>> implements PQueue<T> {
	private T [] heap;

	@SuppressWarnings ("unchecked")	
	public HeapPQueue () {
		this.heap = (T[]) new Comparable [0];
	}

	public void swap (int a, int b) {
		T tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
	
	@SuppressWarnings ("unchecked")	
	@Override
	public void insert (T o) {
		for (int i = 0; i < heap.length; i++)
			if (o.compareTo(heap[i]) == 0) // Nie dodajemy dwukrotnie elementow
				return;					   // o tym samym priorytecie

		System.out.println ("+ Adding element: " + o);
		T[] temp = (T[]) new Comparable [heap.length + 1];

		for (int i = 0; i < heap.length; i++)
			temp[i] = heap[i];

		temp[heap.length] = o;
		heap = temp;

		for (int i = heap.length-1; i > 0; i--)
			if (heap[i].compareTo(heap[(i)/2]) > 0) {
				swap (i, i/2);
		}
	}

	@SuppressWarnings ("unchecked")	
	@Override
	public T remove () {
		T removed = heap [0];

		if (heap.length == 1) {
			heap = (T[]) new Comparable [0];
			System.out.println ("- Removed element: " + removed);
			return removed;
		}
	
		int new_length = heap.length-1;
		T[] tmp = (T[]) new Comparable [new_length];
		
		for (int i = 1; i < new_length; i++)
			tmp[i] = heap[i];
		tmp[0] = heap[heap.length-1];
		heap = tmp;

		int i = 0;
		while (2*i+1 < heap.length) // dopoki jest chociaz jedno dziecko
			if (2*i+2 >= heap.length) // jest tylko lewe dziecko
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
		
		System.out.println ("- Removed element: " + removed);
		return removed;
	}

	public void writeHeap () {
		if (heap.length == 0) {
			System.out.println("-!- Heap is empty!");
			return;
		}

		System.out.println ("[" + heap[0] + "]");
		for (int i = 1; i < heap.length; i++) {
			System.out.print ("[" + heap[i] + "]\t");
			if (i == 2 || i == 6 || i == 14) 
				System.out.print("\n");
		}
		
		System.out.println("\n");
	}

	public boolean isEmpty () {
			if (heap.length == 0)
				return true;
			else
				return false;
	}
}
	
