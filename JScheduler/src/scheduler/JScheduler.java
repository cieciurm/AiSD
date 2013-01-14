package scheduler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

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
    
    public JScheduler() {
            this.sh = new SchedulerHeap();
            this.stats = new int [3];
    }

    public JScheduler(InputStream in) {
            this.sh = new SchedulerHeap();
            this.p = new Parser(in);
            this.stats = new int [3];
    }

    public SchedulerHeap getSh() {
        return this.sh;
    }
    
    public Parser getParser() {
        return this.p;
    }

    /* Public so it could be accessed from Parser.java */
    public static void help() {
            System.out.println ("# ");
            System.out.println ("# Usage:");
            System.out.println ("# java -classpath src/ src.scheduler.JScheduler [-f <file_with_orders>]");
            System.out.println ("# ");
    }
    
    private void writeStats() {
            System.out.println("##### Stats ######");
            System.out.println("# Pushed jobs: " + this.stats[0]);
            System.out.println("# Popped jobs: " + this.stats[1]);
            System.out.println("# Changed jobs: " + this.stats[2]);
            System.out.println("##################");
    }
    
    private void writeStats (FileWriter fr) throws IOException {
            fr.write("##### Stats ######\n");
            fr.write("# Pushed jobs: " + this.stats[0] + "\n");
            fr.write("# Popped jobs: " + this.stats[1] + "\n");
            fr.write("# Changed jobs: " + this.stats[2] + "\n");
            fr.write("##################\n");   
    }
    
    private void writeTime(Monitor m) {
            System.out.println("# Time elapsed: " + m.getAvg() + "ms");
            System.out.println("##################");         
    }
    
    private void writeTime(Monitor m, FileWriter fr) throws IOException {
            fr.write("# Time elapsed: " + m.getAvg() + " ms\n");
            fr.write("##################\n");         
    }

    public static void main(String [] args) throws IOException {

            JScheduler scheduler = null;
            
            boolean fromStdIn = false;

            if (args.length == 0) { // no arguments - reading from System.in
                System.out.println("# Reading from Standard Input");
                scheduler = new JScheduler(System.in);
                fromStdIn = true;
            } else if (args.length == 1) {
                System.out.println("# Error! Too less parameters!");
                help();
                return;
            } else if (!args[0].equals("-f")) {
                System.out.println("# Error! Unknown parameter (required -f)!");
                help();
                return;
            } else if (args[0].equals("-f")) 
                scheduler = new JScheduler(args[1]);
            
            // Initialization of output file with logs
            FileWriter outputFileWriter = null;
            if (!fromStdIn) {
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy-HH:mm:ss");
                Date currentDate = new Date();
                String outputFileName = "log-jscheduler-" + dateFormat.format(currentDate);
                File outputFile = new File(outputFileName);
                outputFileWriter = new FileWriter(outputFile);
            }
            
            String s;
            int operation = 0;
            //System.out.println(scheduler.sh.isEmpty());
            Monitor monitor = MonitorFactory.start();
            while ((s = scheduler.getParser().getBr().readLine()) != null && !s.equals ("")) {
                    operation = scheduler.getParser().getNextOrder(s);
                    if (operation == 1) {
                        //System.out.println("Adding");
                        int [] tmp = scheduler.getParser().getCache();
                        scheduler.getSh().add(new Job(tmp[0], tmp[1]));
                        scheduler.stats[0]++;
                    } else if (operation == 2) {
                        //System.out.println("Removing");
                        Job removed = scheduler.getSh().remove();
                        scheduler.stats[1]++;
                        if (fromStdIn == true) {
                            if (removed == null)
                                System.out.println("No more jobs. There's nothing to be popped.");
                            else
                                System.out.println("Popped job (" + removed + ")");
                        } else {
                            if (removed == null)
                                outputFileWriter.write("No more jobs. There's nothing to be popped.\n");
                            else
                                outputFileWriter.write("Popped job (" + removed + ")\n");
                        }
                    } else if (operation == 3) {
                        //System.out.println("Changing");
                        int [] tmp = scheduler.getParser().getCache();
                        boolean changed = scheduler.getSh().changePriority(tmp[0], tmp[1]);
                        scheduler.stats[2]++;
                        if (!changed) {
                            /* if (fromStdIn) {
                                System.out.println("Priority not changed. There's no element with such ID!");
                            } else {
                                outputFileWriter.write("Priority not changed. There's no element with such ID!\n");
                            } */
                        }
                    }
            }
            monitor.stop();
            if (fromStdIn) {
                scheduler.getSh().writeHeap();
                scheduler.writeStats();
                scheduler.writeTime(monitor);
            } else {
                scheduler.getSh().writeHeap(outputFileWriter);
                scheduler.writeStats(outputFileWriter);
                scheduler.writeTime(monitor, outputFileWriter);
                outputFileWriter.close();
            }
    }
}
