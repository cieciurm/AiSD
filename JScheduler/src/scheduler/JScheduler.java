/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author mateusz
 */
public class JScheduler {
  private SchedulerHeap sh;
  private Parser p;
  
  public JScheduler(String filename) throws FileNotFoundException, NullPointerException {
		//try {
        this.sh = new SchedulerHeap();
        this.p = new Parser(filename);
				//} catch (FileNotFoundException e) {
				//System.out.println("# Error! File not found!");
				//help();
				//} 
  }

	/* Public so it can be used (displayed) while opening file in Parser.java */
  public static void help() {
      System.out.println ("# ");
      System.out.println ("# Usage:");
      System.out.println ("# java -classpath <current_dirrectory> src.scheduler.JScheduler -f <file_with_orders>");
      System.out.println ("# ");
  }

  public static void main(String [] args) throws NullPointerException, IOException {
      
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
          } else if (operation == 2) {
              //System.out.println("Removing");
              scheduler.sh.remove();
          } else if (operation == 3) {
              //System.out.println("Changing");
              int [] tmp = scheduler.p.getCache();
              scheduler.sh.changePriority(tmp[0], tmp[1]);
          }
      }
      
      scheduler.sh.writeHeap();
  }
}
