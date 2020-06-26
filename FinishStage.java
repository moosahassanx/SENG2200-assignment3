// TITLE: 					Assignment3
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532
// DATE: 					26/06/2020
// DESCRIPTION: 			polymorphic extension of stage, finalises items
public class FinishStage extends Stage{
    private String name;
    private Item tempItem;
    private InterstageStorage prevQueue;

    // main constructor
    public FinishStage(String n, int m, int r, InterstageStorage before) {
        super(n);

        name = n;
        prevQueue = before;
        setCurrentState(-1, 0);
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
                // stage is still starving so do nothing
            }

            // case: there are items to be processed
            else{
                Item car = prevQueue.outputItem(currentTime);
                
                // System.out.println(car.getName() + " has been finalised.");
                tempItem = car;

                // set stage as busy
                setCurrentState(0, currentTime);
            }
        }

        // case: stage is busy
        else if(getCurrentState() == 0){
            // System.out.println(name + " is busy.");

            // "push"
            // item was produced by S0a
            if(tempItem.getName().charAt(10) == 'a'){
                countABrands();
            }
            // item was produced by S0b
            else{
                countBBrands();
            }

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

            if(prevQueue.isEmpty() == true){
                // updating state
                setCurrentState(-1, currentTime);
            }

            else{
                tempItem = prevQueue.outputItem(currentTime);
                setCurrentState(0, currentTime);
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