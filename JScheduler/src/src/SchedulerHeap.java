/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Random;

/**
 *
 * @author mateusz
 */
public class SchedulerHeap implements SchedulerData {

    private Job[] heap;
    private int n; // number of elements in heap
    private final int INITIAL_SIZE = 2;

    public SchedulerHeap() {
        this.heap = new Job[INITIAL_SIZE];
        for (int i = 0; i < INITIAL_SIZE; i++) {
            this.heap[i] = new Job();
        }
        this.n = 0;
    }
    
    private int getN() {
        return this.n;
    }

    private void swap(int i, int j) {
        Job tmp = new Job(heap[i].getId(), heap[i].getPriority());
        heap[i].setId(heap[j].getId());
        heap[i].setPriority(heap[j].getPriority());
        heap[j].setId(tmp.getId());
        heap[j].setPriority(tmp.getPriority());
    }

    @Override
    public void add(Job a) {
        if (this.n == this.heap.length) {
            Job[] tmp = new Job[2*n];
            System.arraycopy(heap, 0, tmp, 0, n);
            heap = tmp;
        }

        for (int i = 0; i < n; i++) 
            if (a.getPriority() == heap[i].getPriority()) // Nie dodajemy dwukrotnie elementow
                return;                                 // o tym samym priorytecie
      
        heap[n] = a;
        this.heapUp();
        n++;
    }

    public void heapUp() {
        for (int i = n; i > 0; i--)
            if (heap[i].getPriority() > heap[(i-1)/2].getPriority())
                this.swap(i, (i-1)/2);
    }

    @Override
    public Job remove() {
        return null;
    }

    @Override
    public void changePriority(int id, int priority) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {
        SchedulerHeap jh = new SchedulerHeap();

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            jh.add(new Job(jh.getN() + 1, r.nextInt(10)));
        }

        for (Job i : jh.heap) {
            if (i.getId() != -1) {
                System.out.println(i);
            }
        }
        
        System.out.println("Number of elements: " + jh.getN() + ", capacity: " + jh.heap.length);
    }
}
