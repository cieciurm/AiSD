package scheduler;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import java.util.Random;

public class TestJScheduler {
    private final static int NUMBER_OF_REPETITIONS = 100;
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter as a argument size of the heap (100, 1 000, 10 000, 100 000 ...).");     
            return;
        }
            
        int size = Integer.parseInt(args[0]);
        
        JScheduler scheduler = new JScheduler();
        Monitor add = null;
        System.out.println("**************************************************");
        /* Loop repeated for 100 times to improve results */
        for (int j = 0; j < NUMBER_OF_REPETITIONS; j++) {
            /* Creating scheduler with 1 000 jobs */
            for (int i = 0; i < size; i++) {
                int p = Math.abs((new Random()).nextInt());
                scheduler.getSh().add(new Job(i, p));
            }

            /* Monitoring adding a job to scheduler */
            add = MonitorFactory.start("* Adding job to a scheduler already containing " + size + " jobs");
            scheduler.getSh().add(new Job(1, 1));
            add.stop();
        }
        System.out.println("**************************************************");
        System.out.println(add.getLabel());
        System.out.println("* Number of repetitions: " + add.getHits());
        System.out.println("* Average time of adding [ms]: " + add.getAvg());
        System.out.println("* Started: " + add.getFirstAccess());
        System.out.println("* Started: " + add.getLastAccess());
        //System.out.println(add);
        System.out.println("**************************************************");
    }
}
