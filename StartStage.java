import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class StartStage extends Stage{
    private double timeStart;
    private double timeFinish;
    private String name;
    private String branding;
    private int mean;
    private int range;

    private Item tempItem;

    private int numberOfItems;

    private InterstageStorage nextQueue;

    // default constructor
    public StartStage(){
        timeStart = 0;
        timeFinish = 0;
        name = "";
        setCurrentState(-1);
    }

    // main constructor
    public StartStage(String n, int m, int r, InterstageStorage q, String b){
        name = n;
        mean = m;
        range = r;

        nextQueue = q;
        setCurrentState(-1);       // set as starved
        branding = b;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void processItem(double currentTime){
        System.out.println(name + " processItem() loaded.");

        // case: stage is currently starved
        if(getCurrentState() == -1){

            // stage is now busy
            setCurrentState(0);

            // produce an item
            Item car = new Item(branding);
            System.out.println("starting new car production: " + car.getName());

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
                // insert the stage stored item into the next interstage storage
                nextQueue.inputItem(tempItem);

                // set the stage status to starved
                setCurrentState(-1);
            }
        }

        
        // stage is currently blocked
        else if(getCurrentState() == 1){
            // next storage is full
            if(nextQueue.isFull() == true){
                // do nothing
                System.out.println(nextQueue.getName() + " is full so it cant make more");
            }

            // theres space in the next storage
            else{
                
            }
        }

    }

    public Item getTempItem(){
        return tempItem;
    }

    public void FinishItem(){
        System.out.println("FinishItem() called");
    }

    // for printing stats
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