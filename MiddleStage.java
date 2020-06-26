// TITLE: 					Assignment3
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532
// DATE: 					26/06/2020
// DESCRIPTION: 			polymorphic extension of stage, mainly pulls and pushes items
import java.util.Random;

public class MiddleStage extends Stage{
    private String name;
    private int mean;
    private int range;
    private Item tempItem;
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

        setCurrentState(-1, 0);        // set starved from the start
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

                // updating state
                setCurrentState(0, currentTime);
            }
        }

        // busy or blocked
        else if(getCurrentState() == 0 || getCurrentState() == 1){
            if(nextQueue.isFull()){

                // updating state
                setCurrentState(1, currentTime);
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
                nextQueue.inputItem(tempItem, currentTime);     // changed here

                // check if prev storage be empty
                if(prevQueue.isEmpty()){

                    // updating state
                    setCurrentState(-1, currentTime);                    
                }

                // prev storage is not empty
                else{
                    // pull item from previous queue
                    tempItem = prevQueue.outputItem(currentTime);       // changed here

                    // updating state
                    setCurrentState(0, currentTime);
                }
            }
        }        
    }

    public String toString(){
        String printer = "";  

        //      stage name           work[%]                    starve[t]              block[t]
        printer += name + "\t\t" + getWorkLoad() + "%\t\t" + getStarveTime() + "  \t" + getBlockTime() + "\n";

        return printer;
    }
}