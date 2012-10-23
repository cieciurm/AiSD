import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sorter4Double {

    public static void insort(double[] a) {
        for (int i = 1; i < a.length; i++) {
            double b = a[i];
            int j = i;
            while ((j > 0) && (a[j - 1] > b)) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = b;
        }
    }

    public static void qsort(double[] a, int b, int c) {
        int i = b, j = c, h;
        double x = a[(b + c) / 2];
        do {
            while (a[i] < x) {
                i++;
            }
            while (a[j] > x) {
                j--;
            }
            if (i <= j) {
                h = (int) a[i];
                a[i] = a[j];
                a[j] = h;
                i++;
                j--;
            }
        } while (i <= j);
        if (b < j) {
            qsort(a, b, j);
        }
        if (i < c) {
            qsort(a, i, c);
        }
    }

    public static void write(double[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i] + "]");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) throws IOException {
        double t[];

		System.out.println("Laboratorium AiSD, Mateusz Cieciura, GR 1");
		System.out.println("Generowanie czasow sortowan:");

        System.out.println("\tWarunek optymistyczny dla qsorta -> qsort.opt.log");
        BufferedWriter out1 = new BufferedWriter(new FileWriter("qsort.opt.log"));
        for (int j = 10; j < 1001; j += 10) {
            t = new double[j];

            for (int i = 0; i < j; i++) {
                t[i] = i + 1;
            }

            long t1 = System.nanoTime();
            qsort(t, 0, t.length-1);
            long t2 = System.nanoTime();
            out1.write(t2 - t1 + "\n");
        }
        out1.close();
        System.out.println("\tWarunek pesymistyczny dla qsorta -> qsort.pes.log");
        BufferedWriter out2 = new BufferedWriter(new FileWriter("qsort.pes.log"));
        for (int j = 10; j < 1001; j += 10) {
            t = new double[j];

            for (int i = j; i > 0; i--) {
                t[i-1] = i + 1;
            }

            long t1 = System.nanoTime();
            qsort(t, 0, t.length-1);
            long t2 = System.nanoTime();
            out2.write(t2 - t1 + "\n");
        }
        out2.close();
        System.out.println("\tWarunek optymistyczny dla insorta -> insort.opt.log");
        BufferedWriter out3 = new BufferedWriter(new FileWriter("insort.opt.log"));
        for (int j = 10; j < 1001; j += 10) {
            t = new double[j];

            for (int i = 0; i < j; i++) {
                t[i] = i + 1;
            }

            long t1 = System.nanoTime();
            insort(t);
            long t2 = System.nanoTime();
            out3.write(t2 - t1 + "\n");
        }
        out3.close();
        
        System.out.println("\tWarunek pesymistyczny dla insorta -> insort.pes.log");
        BufferedWriter out4 = new BufferedWriter(new FileWriter("insort.pes.log"));
        for (int j = 10; j < 1001; j += 10) {
            t = new double[j];

            for (int i = j; i > 0; i--) {
                t[i-1] = i + 1;
            }

            long t1 = System.nanoTime();
            insort(t);
            long t2 = System.nanoTime();
            out4.write(t2 - t1 + "\n");
        }
        out4.close();
    }
}
