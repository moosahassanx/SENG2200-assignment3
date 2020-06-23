import java.util.LinkedList;
import java.util.List;

public abstract class Stage {
    private double timeStart;
    private double timeFinish;
    private String name;
    private InterstageStorage nextQueue;

    private List<Stage> nextStage;
    private List<Stage> prevStage;

    // default constructor
    public Stage(){
        timeStart = 0;
        timeFinish = 0;
        name = "";

        nextStage = new LinkedList<Stage>();
        prevStage = new LinkedList<Stage>();
    }

    // main constructor
    public Stage(String n){
        timeStart = 0;
        timeFinish = 0;
        name = n;
        nextStage = new LinkedList<Stage>();
        prevStage = new LinkedList<Stage>();
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

    // T2 = T1 + P.
    public double processingTime(double p){
        // timeFinish = timeStart + p;
        return 2.3;
    }

    public void ProcessItem(double currentTime){
        System.out.println("ProcessItem() called + currentTime: " + currentTime);
    }
    
    // fake toString() method
    public String toString(){
        String printer = "";  

        printer += name + "\t\t" + "0%" + "\t\t" + "00000.00" + "\t" + "00000.00" + "\n";

        return printer;
    }

    public void setNext(Stage after){
        nextStage.add(after);
    }
    public int getNextSize(){
        return nextStage.size();
    }
    public Stage getNext(){
        return nextStage.get(0);
    }
    public Stage getNext2(){
        return nextStage.get(1);
    }
    
    public void setPrev(Stage before){
        prevStage.add(before);
    }
    public int getPrevSize(){
        return prevStage.size();
    }
    public Stage getPrev(){
        return prevStage.get(0);
    }
    public Stage getPrev2(){
        return prevStage.get(1);
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