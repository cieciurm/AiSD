package scheduler;

import java.io.IOException;

public class JScheduler {
  private SchedulerHeap sh;
  private Parser p;
  private int [] stats;
  
  public JScheduler(String filename) {
      try {
        this.sh = new SchedulerHeap();
        this.p = new Parser(filename);
      } catch (Exception e) {
          System.out.println(e.getMessage());
      } 
      this.stats = new int [3];
  }

	/* Public so it could be accessed from Parser.java */
  public static void help() {
      System.out.println ("# ");
      System.out.println ("# Usage:");
			System.out.println ("# java -classpath <current_dirrectory> src.scheduler.JScheduler -f <file_with_orders>");
      System.out.println ("# ");
  }
  
  private void writeStats() {
      System.out.println("*** Stats: ***");
      System.out.println("* Added: " + this.stats[0]);
      System.out.println("* Removed: " + this.stats[1]);
      System.out.println("* Changed: " + this.stats[2]);
      System.out.println("******");
  }

  public static void main(String [] args) throws IOException {
      
      if (args.length <= 1) {
          System.out.println("# Error! Too less parameters!");
          help();
          return;
      }

      if (!args[0].equals("-f")) {
          System.out.println("# Error! Unknown parameter (required -f)!");
          help();
          return;
      }
      
      JScheduler scheduler = new JScheduler(args[1]);
      String s;
      int operation = 0;
      //System.out.println(scheduler.sh.isEmpty());
      
      while ((s  = scheduler.p.getBr().readLine()) != null && !s.equals ("")) {
          operation = scheduler.p.getNextOrder(s);
          if (operation == 1) {
              //System.out.println("Adding");
              int [] tmp = scheduler.p.getCache();
              scheduler.sh.add(new Job(tmp[0], tmp[1]));
              scheduler.stats[0]++;
          } else if (operation == 2) {
              //System.out.println("Removing");
              scheduler.sh.remove();
              scheduler.stats[1]++;
          } else if (operation == 3) {
              //System.out.println("Changing");
              int [] tmp = scheduler.p.getCache();
              scheduler.sh.changePriority(tmp[0], tmp[1]);
              scheduler.stats[2]++;
          }
      }
      
      scheduler.sh.writeHeap();
      scheduler.writeStats();
      

  }
}
