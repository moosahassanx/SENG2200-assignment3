public class Job{
    private double duration;
    private double currentTime;
    private Stage currentStage;

    public Job(double d, Stage s) {
        currentStage = s;
        duration = d;
        currentTime = duration;
    }
	
    public void finishJob(double t){
        currentStage.processItem(t);
    }
    
    public void updateCurrentTime(double c){
        currentTime = c;
    }

    public Stage getCurrentStage(){
        return currentStage;
    }
}