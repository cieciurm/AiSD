package scheduler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestGenerator {
    public static void main(String[] args) throws IOException {
                
				if (args.length == 0) {
					System.out.println("Enter number of elements!");
					return;
				}
                
        Random r = new Random();
        
        int id = r.nextInt(1000);
        String filename = "test" + id;
        
        BufferedWriter out = new BufferedWriter(new FileWriter(filename));
        
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            int operation = r.nextInt(3); /* returns 0, 1, 2 */
            
            if (operation == 0) {
              out.write("jobpush " + i + " " + r.nextInt(1000) + "\n");  
            } else if (operation == 1) {
                out.write("jobpop" + "\n");
            } else if (operation == 2) {
              out.write("jobchange " + r.nextInt(100) + " " + r.nextInt(1000) + "\n");  
            }
        }
            
        out.close();
        
        System.out.println(filename);
    }
}
