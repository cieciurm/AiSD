/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *
 * @author mateusz
 * 
 */
public class TestListPQueue {
    public static void main(String[] args) {
        ListPQueue list = new ListPQueue();
        
        System.out.println("* Laboratorium Algorytmow i Struktur Danych");
        System.out.println("* Mateusz Cieciura, GR 1");
        System.out.println("* Cwiczenie nr 2 - kolejka priorytetowa w liscie liniowej\n");
        
        System.out.println("Priority Queue #1:");
        list.insert(22);
        list.insert(3);
        list.insert(77);
        list.insert(6);
        list.insert(1);
        
        list.writeList();

        System.out.println("- Removing elements");
        while (!list.isEmpty()) {
            list.remove();
            list.writeList();
        }

        System.out.println("Priority Queue #2:");
        
        list.insert("Ania");
        list.insert("ania");
        list.insert("Zosia");
        list.insert("zosia");
        
        list.writeList();
        
        System.out.println("- Removing elements");
        while (!list.isEmpty()) {
            list.remove();
            list.writeList();
        }
    }
}
