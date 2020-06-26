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
    private Item tempItem;

    InterstageStorage prevQueue;

    private String nextQueue;

    // main constructor
    public FinishStage(String n, int m, int r, InterstageStorage before){
        super(n);

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
        // case: stage is starved
        if(getCurrentState() == -1){
            // case: there are no items to process
            if(prevQueue.isEmpty() == true){
                // System.out.println("there are no items to be processed");
            }

            // case: there are items to be processed
            else{
                Item car = prevQueue.outputItem(currentTime);
                
                // System.out.println(car.getName() + " has been finalised.");
                tempItem = car;

                // set stage as busy
                setCurrentState(0);
            }
        }

        // case: stage is busy
        else if(getCurrentState() == 0){
            // System.out.println(name + " is busy.");

            // "push"
            // System.out.println(tempItem.getName() + " needs to be stored somewhere: " + tempItem.getName().charAt(10));

            // item was produced by S0a
            if(tempItem.getName().charAt(10) == 'a'){
                countABrands();
            }
            // item was produced by S0b
            else{
                countBBrands();
            }

            // System.out.println(tempItem.getData(3).getStageName());
            // System.out.println(tempItem.getData(5).getStageName());

            // S3a
            if(tempItem.getData(3).getStageName() == "S3a"){
                // S3a to S5a
                if(tempItem.getData(5).getStageName() == "S5a"){
                    addS3atoS5a();
                }

                // S3a to S5b
                else{
                    addS3atoS5b();
                }
            }

            // S3b
            if(tempItem.getData(3).getStageName() == "S3b"){
                // S3b to S5a
                if(tempItem.getData(5).getStageName() == "S5a"){
                    addS3btoS5a();
                }

                // S3b to S5b
                else{
                    addS3btoS5b();
                }
            }

            // destroy item
            tempItem = null;

            // check if prev storage be empty
            if(prevQueue.isEmpty() == true){
                setCurrentState(-1);
            }

            // case: theres items
            else{
                // "process" the item as a final product
                tempItem = prevQueue.outputItem(currentTime);

                // System.out.println(tempItem.getName() + " needs to be stored somewhere");
            }
        }

        // case: stage is blocked
        else if(getCurrentState() == 1){
            System.out.println("Stage is blocked. How did you manage to do this?");
        }
    }

    public String toString() {
        String printer = "";  

        //      stage name            work[%]                  starve[t]               block[t]
        printer += name + "\t\t" + getWorkLoad() + "%\t\t" + getStarveTime() + "      \t" + getBlockTime() + "\n";

        return printer;
    }
}