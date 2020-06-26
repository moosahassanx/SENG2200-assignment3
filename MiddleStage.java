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

    // default constructor
    public MiddleStage(){
        timeStart = 0;
        timeFinish = 0;
        name = "";
    }

    // main constructor
    public MiddleStage(String n, int m, int r, InterstageStorage after, InterstageStorage before){
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
        System.out.println(name + " processItem()");

        // case: stage is starved
        if(getCurrentState() == -1){
            if(prevQueue.isEmpty() == false){
                // pull item from previous queue
                tempItem = prevQueue.outputItem();

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
                // push
                nextQueue.inputItem(tempItem);

                // check if prev storage be empty
                if(prevQueue.isEmpty()){
                    setCurrentState(-1);
                }

                else{
                    tempItem = prevQueue.outputItem();

                    // set stage as busy
                    setCurrentState(0);
                }
            }
        }        
    }

    public String toString(){
        String printer = "";  

        //      stage name          work[%]              starve[t]           block[t]
        printer += name + "\t\t" + getWork() + "\t\t" + getStarve() + "\t" + getBlock() + "\n";

        return printer;
    }

    public String getWork(){
        String work = "00.00%";

        return work;
    }

    public String getStarve(){
        String starve = "0,000.00";

        return starve;
    }

    public String getBlock(){
        String block = "00,000.00";

        return block;
    }
}