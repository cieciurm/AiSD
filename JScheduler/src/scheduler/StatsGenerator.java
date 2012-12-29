package scheduler;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import java.util.Random;

public class StatsGenerator {
    private final static int NUMBER_OF_REPETITIONS = 100;
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter as a argument size of the heap (100, 1 000, 10 000, 100 000 ...).");     
            return;
        }
            
        int size = Integer.parseInt(args[0]);
        
        JScheduler scheduler = new JScheduler();
        Monitor add = null;
        Monitor remove = null;
        Monitor change = null;
        
        /* Loop repeated NUMBER_OF_REPETITIONS times to improve results */
        for (int j = 1; j <= NUMBER_OF_REPETITIONS; j++) {
            /* Creating scheduler */
            for (int i = 0; i < size; i++) {
                int p = Math.abs((new Random()).nextInt());
                scheduler.getSh().add(new Job(i, p));
            }

            /* Monitoring */
            add = MonitorFactory.start("* Adding a job to the scheduler already containing " + size + " jobs");
            int m = Math.abs((new Random()).nextInt());
            scheduler.getSh().add(new Job(m, m));
            add.stop();
            remove = MonitorFactory.start("* Removing a job from the scheduler already containing " + size + " jobs");
            scheduler.getSh().remove();
            remove.stop();
            change = MonitorFactory.start("* Changing job's priority in the scheduler already containing " + size + " jobs");
            scheduler.getSh().changePriority(1, 1000000);
            change.stop();
        }
        System.out.println("**************************************************");
        System.out.println(add.getLabel());
        System.out.println("* Number of repetitions: " + add.getHits());
        System.out.println("* Average time of adding [ms]: " + add.getAvg());
        System.out.println("* Started: " + add.getFirstAccess());
        System.out.println("* Started: " + add.getLastAccess());
        System.out.println("**************************************************");
        System.out.println(remove.getLabel());
        System.out.println("* Number of repetitions: " + remove.getHits());
        System.out.println("* Average time of removing [ms]: " + remove.getAvg());
        System.out.println("* Started: " + remove.getFirstAccess());
        System.out.println("* Started: " + remove.getLastAccess());
        System.out.println("**************************************************");
        System.out.println(change.getLabel());
        System.out.println("* Number of repetitions: " + change.getHits());
        System.out.println("* Average time of changing priority [ms]: " + change.getAvg());
        System.out.println("* Started: " + change.getFirstAccess());
        System.out.println("* Started: " + change.getLastAccess());
        System.out.println("**************************************************");
    }
    
}
