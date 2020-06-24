public class Job{
    private double duration;
    private double remainingDuration;
    private Stage currentStage;

    public Job(double d, Stage s) {
        System.out.println("Job() constructor loaded.");
        System.out.println("Job() duration: " + d);
        System.out.println("Job() stage: " + s.getName());

        currentStage = s;
        duration = d;
        remainingDuration = duration;
	}

	public double getRemainingDuration(){
        return remainingDuration;
    }

    public double getDuration(){
        return duration;
    }

    public Stage getCurrentStage(){
        return currentStage;
    }

    public void updateRemainingDuration(double r){
        remainingDuration = remainingDuration - r;
    }

    public void finishJob(double t){
        currentStage.processItem(t);
    }
}