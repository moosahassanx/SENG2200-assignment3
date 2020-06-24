import java.util.*;

public class Item {
    private int timeEntered;
    private int timeLeft;
    private String uniqueID;
    private Data[] dataArray;

    public Item(){
        timeEntered = 0;
        timeLeft = 0;
        /*
        // generating id using singleton class
        getID generateID = getID.getInstance();
        uniqueID = generateID.ID;
        */

        dataArray = new Data[7];

        getID generateID = new getID();
        uniqueID = generateID.retrieveID();
    }

    public void addData(String name, double processingTime){
        // iterate through every stage array
        for(int i = 0; i < 7; i++){
            // null checker
            if(dataArray[i] != null){
                // add the data
                dataArray[i] = new Data(name, processingTime);
                return;
            }
        }
    }
}