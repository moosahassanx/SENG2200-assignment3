import java.time.Duration;
import java.util.PriorityQueue;
import java.util.Queue;

public class EventManager {
	private double currentTime;
	
	private double time;

	private Queue<Job> JobQueue;

    // constructor
    public EventManager(){
		currentTime = 0;
		JobQueue = new PriorityQueue<Job>();
	}
	
	public void addNewJobQueue(double duration, Stage stage){
		JobQueue.add(new Job(duration, stage));
	}

	public Stage nextAction(){
		Job nextJob = JobQueue.poll();			// removed the item with the head of the queue, and cos its a priority queue it removed the highest priority queue
		
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