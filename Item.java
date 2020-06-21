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

        getID generateID = new getID();
        uniqueID = generateID.retrieveID();
    }
    
    public Item(String AorB)
    {
        timeEntered = 0;
        timeLeft = 0;
        /*
        // generating id using singleton class
        getID generateID = getID.getInstance();
        uniqueID = generateID.ID + AorB;
        */

        getID generateID = new getID();
        uniqueID = generateID.retrieveID();
    }

    public void newData(String s, double tE, double tL) {
        dataArray = new Data[1];

        dataArray[0] = new Data(s, tE, tL);
    }
}