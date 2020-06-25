import java.time.Duration;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class EventManager {
	private double currentTime;
	
	private double time;

	private PriorityQueue<Job> PJ;

    // constructor
    public EventManager(){
		currentTime = 0;
		PJ = new PriorityQueue<Job>();
	}

	// the first items created by S0a and S0b are created simultaneously
	// whenever the items have been processed and the next queue is not blocked - transfer to next queue storage
	// s1 pulls the item and processes it

	public Stage performProduction(ArrayList<Stage> stageList, double timeNow){

		for(Stage s : stageList){
			Stage tempStage = s.getPrev();
		}
		
		

		System.out.println("Stage: " + stageList.getName());
		stageList.processItem(timeNow);			// only call when job is complete

		// check for adjacent stages
		stageList.processAdjacent();

		Job nextJob = PJ.poll();			// printing the top element and removing it (GeeksForGeeks))

		System.out.println("current stage: " + nextJob.getCurrentStage().getName());
		
		// gives you the stage
		
		/*
		System.out.println("getremainingDuration(): " + nextJob.getRemainingDuration());

		currentTime = nextJob.getRemainingDuration();

		for(Job j : JobQueue){
			j.updateRemainingDuration(nextJob.getRemainingDuration());
		}

		nextJob.finishJob(currentTime);
		*/
		
		return nextJob.getCurrentStage();
	}



	public double timeNow() {
		return currentTime;
	}

	public Stage produceItem() {
		return null;
	}
}