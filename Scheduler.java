import java.time.Duration;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Scheduler {
	private double currentTime;
	
	private double time;

	private PriorityQueue<Job> PQ;

    // constructor
    public Scheduler(){
		currentTime = 0;
		PQ = new PriorityQueue<Job>();
	}

	public void addToPriorityQueue(Stage s, double timeNow){
		System.out.println("addToPriorityQueue " + s.getName());
		Job Job = new Job(timeNow, s);
		PQ.offer(Job);
	}
	
	public Job removeJob(){
		Job outputJob = PQ.poll();
		return outputJob;
	}

	/*
	public Job addToPriorityQueue(Stage s, double timeNow){
		Job firstJob = new Job();
		Job secondJob = new Job();

		// make a new job
		if(timeNow == 0){
			firstJob = new Job(timeNow, stageList.get(0));
			secondJob = new Job(timeNow, stageList.get(1));
			System.out.println("Stage: " + firstJob.getCurrentStage().getName());
			System.out.println("Stage: " + firstJob.getCurrentStage().getName());

			PQ.offer(firstJob);
			PQ.offer(secondJob);
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
	*/

	public double timeNow(){
		return currentTime;
	}

	public Stage produceItem(){
		return null;
	}
}