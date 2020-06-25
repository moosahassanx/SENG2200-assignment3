import java.util.PriorityQueue;

public class Scheduler {
	private double currentTime;
	
	private PriorityQueue<Job> PQ;

    // constructor
    public Scheduler(){
		currentTime = 0;
		PQ = new PriorityQueue<Job>();
	}

	public void addToPriorityQueue(Stage s, double timeNow){
		// System.out.println("addToPriorityQueue " + s.getName());
		Job Job = new Job(currentTime + timeNow, s);
		PQ.offer(Job);
	}
	
	public Job removeJob(){
		Job outputJob = PQ.poll();

		// updating time
		currentTime = outputJob.getCurrentTime();

		return outputJob;
	}

	public double timeNow(){
		return currentTime;
	}

	public Stage produceItem(){
		return null;
	}
}