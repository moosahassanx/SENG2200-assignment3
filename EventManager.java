import java.time.Duration;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class EventManager {
	private double currentTime;
	
	private double time;

	private PriorityQueue<Job> PQ;

    // constructor
    public EventManager(){
		currentTime = 0;
		PQ = new PriorityQueue<Job>();
	}

	public Job addToPriorityQueue(ArrayList<Stage> stageList, double timeNow){
		Job firstJob = new Job();
		Job secondJob = new Job();

		// make a new job
		if(timeNow == 0){
			firstJob = new Job(timeNow, stageList.get(0));
			secondJob = new Job(timeNow, stageList.get(1));
			System.out.println("current stage: " + firstJob.getCurrentStage().getName());

			PQ.offer(firstJob);
			System.out.println("firstJob offered");
		}

		// processing it and doing stuff
		else{
			firstJob.getCurrentStage().processItem(timeNow);
			currentTime += firstJob.getCurrentStage().getProcessingTime();
		}

		Job nextJob = PQ.poll();									// printing the top element and removing it (GeeksForGeeks))

		// actual discrete simulation lol

		return nextJob;
	}

	public double timeNow() {
		return currentTime;
	}

	public Stage produceItem() {
		return null;
	}
}