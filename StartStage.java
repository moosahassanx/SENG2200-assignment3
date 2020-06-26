// TITLE: 					Assignment3
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532
// DATE: 					26/06/2020
// DESCRIPTION: 			polymorphic extension of stage, generates items constantly and pushes it
import java.util.Random;

public class StartStage extends Stage{
    private String name;
    private String branding;
    private int mean;
    private int range;

    private Item tempItem;
    private InterstageStorage nextQueue;

    // main constructor
    public StartStage(String n, int m, int r, InterstageStorage q, String b){
        super(n);

        name = n;
        mean = m;
        range = r;

        nextQueue = q;
        setCurrentState(-1, 0);       // set as starved
        branding = b;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void processItem(double currentTime){
        // System.out.println(name + " processItem() loaded.");

        // case: stage is currently starved
        if(getCurrentState() == -1){
            // produce an item
            Item car = new Item(branding);

            // process item - P = M + N x (d - 0.5)
            Random r = new Random();
            double d = r.nextDouble();
            double processingTime = mean + range * (d - 0.5);
            setProcessingTime(processingTime);
    
            // print data onto item
            car.addData(name, processingTime);
    
            // temporarily store it within the stage for later use
            tempItem = car;

            // stage is now busy
            setCurrentState(0, currentTime);
        }

        // case: the stage is currently busy or blocked
        else if(getCurrentState() == 0 || getCurrentState() == 1){
            // case: the next storage is full
            if(nextQueue.isFull() == true){
                setCurrentState(1, currentTime);
            }

            // case: theres room in the next interstage storage
            else{
                // insert the stage stored item into the next interstage storage
                nextQueue.inputItem(tempItem, currentTime);

                // produce an item
                Item car = new Item(branding);
                // System.out.println("starting new car production: " + car.getName());

                // process item - P = M + N x (d - 0.5)
                Random r = new Random();
                double d = r.nextDouble();
                double processingTime = mean + range * (d - 0.5);
                // System.out.println("processingTime: " + processingTime);
                setProcessingTime(processingTime);
        
                // print data onto item
                car.addData(name, processingTime);
        
                // temporarily store it within the stage for later use
                tempItem = car;
                
                // updating state
                setCurrentState(0, currentTime);
            }
        }
    }

    public Item getTempItem(){
        return tempItem;
    }

    // for printing stats
    public String toString(){
        String printer = "";  

        //      stage name            work[%]                  starve[t]                        block[t]
        printer += name + "\t\t" + getWorkLoad() + "%\t\t" + getStarveTime() + "        \t\t" + getBlockTime() + "\n";

        return printer;
    }
}