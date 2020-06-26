import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MiddleStage extends Stage{
    private double timeStart;
    private double timeFinish;
    private String name;
    private int mean;
    private int range;

    private Item tempItem;
    private int numberOfItems;

    private InterstageStorage nextQueue;
    private InterstageStorage prevQueue;

    // main constructor
    public MiddleStage(String n, int m, int r, InterstageStorage after, InterstageStorage before){
        super(n);

        name = n;
        mean = m;
        range = r;

        nextQueue = after;
        prevQueue = before;

        setCurrentState(-1);        // set starved from the start
    }

    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }

    public void processItem(double currentTime){
        // System.out.println(name + " processItem()");

        // case: stage is starved
        if(getCurrentState() == -1){
            if(prevQueue.isEmpty() == false){
                // pull item
                tempItem = prevQueue.outputItem(currentTime);

                if(nextQueue.isFull()){
                    // blocked
                    setCurrentState(1);
                }

                else{
                    // busy
                    setCurrentState(0);
                }
            }
        }

        // busy or blocked
        else if(getCurrentState() == 0 || getCurrentState() == 1){
            if(nextQueue.isFull()){
                // stage is blocked
                setCurrentState(1);
            }

            else{
                // process item - P = M + N x (d - 0.5)
                Random r = new Random();
                double d = r.nextDouble();
                double processingTime = mean + range * (d - 0.5);
                // System.out.println("processingTime: " + processingTime);
                setProcessingTime(processingTime);

                // print data onto item
                tempItem.addData(name, processingTime);
                
                // push
                nextQueue.inputItem(tempItem, currentTime + processingTime);

                // check if prev storage be empty
                if(prevQueue.isEmpty()){
                    setCurrentState(-1);
                }

                // prev storage is not empty
                else{
                    // pull item from previous queue
                    tempItem = prevQueue.outputItem(currentTime + processingTime);

                    // set stage as busy
                    setCurrentState(0);
                }
            }
        }        
    }

    public String toString(){
        String printer = "";  

        //      stage name           work[%]                    starve[t]              block[t]
        printer += name + "\t\t" + getWorkLoad() + "%\t\t" + getStarveTime() + "      \t" + getBlockTime() + "\n";

        return printer;
    }
}