public class Job implements Comparable<Job>{
    private double startTime;
    private double duration;
    private double finishTime;
    private Stage currentStage;

    public Job(){
        startTime = 0;
        duration = 0;
        finishTime = 0;
    }

    public Job(double timeNow, Stage s) {
        currentStage = s;
        startTime = 0;
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
        
        // this finishTime < input finishTime
        if(this.finishTime < o.finishTime){
            return -1;
        }

        // this finishTime == input finishTime
        if(this.finishTime == o.finishTime){
            return 0;
        }

        // this finishTime > input finishTime
        else{
            return 1;
        }
    }
}