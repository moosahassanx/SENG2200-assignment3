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


        /*
        System.out.println("STAGE: " + name + " - " + getCurrentState());

        // case: the stage is currently starved
        if(getCurrentState() == -1){

            // case: the previous interstage storage is empty
            if(prevQueue.isEmpty() == true){
                // do nothing
                System.out.println(prevQueue.getName() + " is empty");
            }

            // case: there are items to be process in this stage
            else{
                // stage is now busy
                setCurrentState(0);

                // process item from prior queue
                Item car = prevQueue.outputItem();

                // guard to stop null ptr exception
                if(car == null){
                    System.out.println(prevQueue.getName() + " does not have any items");
                    return;
                }
                
                System.out.println("processing: " + car.getName());

                // process item - P = M + N x (d - 0.5)
                Random r = new Random();
                double d = r.nextDouble();
                double processingTime = mean + range * (d - 0.5);
                System.out.println("processingTime: " + processingTime);
        
                // print data onto item
                car.addData(name, processingTime);
        
                // temporarily store it within the stage for later use
                tempItem = car;
            }
        }

        // case: the stage is currently busy
        else if(getCurrentState() == 0){
            // case: the next storage is full
            if(nextQueue.isFull() == true){
                System.out.println(nextQueue.getName() + " is full");
                // set the stage as blocked
                setCurrentState(1);
            }

            // case: theres room in the next interstage storage
            else{
                System.out.println(nextQueue.getName() + " has room");

                if(tempItem == null){
                    System.out.println("Stage doesnt have a temp item.");
                    return;
                }

                // insert the stage stored item into the next interstage storage
                nextQueue.inputItem(tempItem);

                // set the stage status to busy
                setCurrentState(0);
            }
        }

        // case: the stage is blocked
        else if(getCurrentState() == 1) {
            System.out.println("Stage is blocked");
        }
        */
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