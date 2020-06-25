import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Stage {
    private double processingTime;
    private String name;
    private InterstageStorage nextQueue;

    private ArrayList<Stage> nextStage;
    private ArrayList<Stage> prevStage;

    private int currentState;

    // default constructor
    public Stage(){
        processingTime = 0;
        name = "";
        nextStage = new ArrayList<Stage>();
        prevStage = new ArrayList<Stage>();
        currentState = 0;
    }

    // main constructor
    public Stage(String n){
        processingTime = 0;
        nextStage = new ArrayList<Stage>();
        prevStage = new ArrayList<Stage>();
    }

    public double getProcessingTime(){
        return processingTime;
    }
    public void setProcessingTime(double p){
        processingTime = p;
    }

    public void setCurrentState(int s){
        // -1: starve
        //  0: busy
        //  1: blocked
        currentState = s;
    }

    public int getCurrentState(){
        return currentState;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public InterstageStorage getNextQueue(){
        return nextQueue;
    }

    public abstract void processItem(double currentTime);
    
    // fake toString() method
    public String toString(){
        String printer = "";  

        printer += name + "\t\t" + "0%" + "\t\t" + "00000.00" + "\t" + "00000.00" + "\n";

        return printer;
    }

    // linked list controlling
    public void setNext(Stage after){
        nextStage.add(after);
    }
    public int getNextSize(){
        return nextStage.size();
    }
    public ArrayList<Stage> getNext(){
        return nextStage;
    }
    
    // linked list controlling
    public void setPrev(Stage before){
        prevStage.add(before);
    }
    public int getPrevSize(){
        return prevStage.size();
    }
    public ArrayList<Stage> getPrev(){
        return prevStage;
    }

    public void setProcessingTime(int m, int n){
        Random r = new Random();
        double d = r.nextDouble();
        
        // P = M + N x (d - 0.5)
        processingTime = m + n * (d - 0.5);

        System.out.println("processingTime: " + processingTime);
    }

    // T2 = T1 + P.
    public double getProcessingTime(double p){
        // timeFinish = timeStart + p;
        return processingTime;
    }

    // TODO: 5. You will also keep a total number of items created by S0a and S0b that arrive at the end of the line.
    public int createdItems(){
        int numberOfItems;

        numberOfItems = 5;

        return numberOfItems;
    }

	public void incStateDur(double timeNow) {
        System.out.println("incStateDur() called");
	}

    // TODO: 6. Lastly, you will keep a total of the number of items that followed each path through Stage 3a/b and Stage 5a/b, that arrive at the end of the line
}