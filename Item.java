import java.util.*;

public class Item {
    private int timeEntered;
    private int timeLeft;
    private String uniqueID;
    private Data[] dataArray;

    public Item(){
        timeEntered = 0;
        timeLeft = 0;
        uniqueID = "";
    }
    
    public Item(String AorB)
    {
        uniqueID = "ITEMID" + AorB;
        
        /*
        char startPoint = uniqueID.charAt(6);
        System.out.println("startPoint: " + startPoint);
        */
    }

    public void newData(String s, double tE, double tL) {
        dataArray = new Data[1];

        dataArray[0] = new Data(s, tE, tL);
    }
}