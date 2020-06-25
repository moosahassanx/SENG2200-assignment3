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

        // case: the stage is not in starve state
        if(getCurrentState() != -1){
            // case: theres space in the next queue storage
            if(nextQueue.isFull() == false){
                nextQueue.inputItem(tempItem);
            }

            // theres no space in the next queue storage
            else{
                // set stage to blocked
                setCurrentState(1);
            }
        }

        // case: prevQueue has items in it
        if(prevQueue.isEmpty() == false){
            // get the item from prev queue
            tempItem = prevQueue.outputItem();

            // set stage to busy
            setCurrentState(0);
        }

        // case: theres no items to pull
        else{
            setCurrentState(-1);
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