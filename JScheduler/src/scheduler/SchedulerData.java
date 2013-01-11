package scheduler;

public interface SchedulerData {
    public void add(Job a); // adds a job to the scheduler    
    public Job remove(); // removes from the scheduler job with the greatest priority
    public void changePriority(int id, int priority); // changes priority in particular job
    public boolean isEmpty(); // return true if scheduler has no jobs
}
