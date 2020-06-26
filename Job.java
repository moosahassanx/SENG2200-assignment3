// TITLE: 					Assignment3
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532
// DATE: 					26/06/2020
// DESCRIPTION: 			an instance of a job is created using the scheduler. compares other jobs
//                          created by the scheduler using comparable
public class Job implements Comparable<Job>{
    private double duration;
    private Stage currentStage;

    public Job() {
        duration = 0;
    }

    public Job(double timeNow, Stage s) {
        currentStage = s;
        duration = timeNow;
    }
	
    public void finishJob(double t){
        currentStage.processItem(t);
    }

    public Stage getCurrentStage(){
        return currentStage;
    }

    // STILL TESTING
    public double getCurrentTime(){
        return duration;
    }

    @Override
    public int compareTo(Job o) {
        
        // this duration < input duration
        if(this.duration < o.duration){
            return -1;
        }

        // this duration == input duration
        if(this.duration == o.duration){
            return 0;
        }

        // this duration > input duration
        else{
            return 1;
        }
    }
}