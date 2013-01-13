package scheduler;

public interface SchedulerData {
    public void add(Job a); 
    // adds a job to the scheduler    
    public Job remove(); 
    // removes from the scheduler job with the greatest priority
    public boolean changePriority(int id, int priority); 
    // changes priority in particular job, returns false if such job wasn't found
    public boolean isEmpty(); 
    // return true if scheduler has no jobs
}
