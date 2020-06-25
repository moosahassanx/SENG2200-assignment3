import java.util.LinkedList;
import java.util.List;

public class FinishStage extends Stage{
    private double timeStart;
    private double timeFinish;
    private String name;
    private int mean;
    private int range;

    private Item[] itemArray;
    private int numberOfItems;

    InterstageStorage prevQueue;

    private String nextQueue;

    // default constructor
    public FinishStage(){
        timeStart = 0;
        timeFinish = 0;
        name = "";
    }

    // main constructor
    public FinishStage(String n, int m, int r, InterstageStorage before){
        name = n;
        mean = m;
        range = r;
        prevQueue = before;
        itemArray = new Item[10000];
        numberOfItems = 0;
        setCurrentState(-1);
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void processItem(double currentTime){
        System.out.println("STAGE: " + name + " = " + getCurrentState());
        // take the item, grabs the stats from it, and then get rid of the item

        // case: stage is starved
        if(getCurrentState() == -1){
            // case: there are no items to process
            if(prevQueue.isEmpty() == true){
                System.out.println("there are no items to be processed");
            }

            // case: there are items to be processed
            else{
                Item car = prevQueue.outputItem();
                itemArray[numberOfItems] = car;
                numberOfItems++;
                System.out.println(car.getName() + " has been finalised.");
            }
        }

        // case: stage is busy
        else if(getCurrentState() == 0){
            System.out.println(name + " is busy.");
        }

        // case: stage is blocked
        else if(getCurrentState() == 1){
            System.out.println("Stage is blocked. How did you manage to do this?");
        }
    }

    public void FinishItem(){
        System.out.println("FinishItem() called");
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