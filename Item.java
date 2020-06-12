import java.util.*;

public class Item {
    private int timeEntered;
    private int timeLeft;
    private String uniqueID;
    private Data[] dataArray;
    
    public Item()
    {
        uniqueID = "ITEMID" + determineStart();
        System.out.println("uniqueID: " + uniqueID);
        
        char startPoint = uniqueID.charAt(6);
        System.out.println("startPoint: " + startPoint);
    }

    public void newData(String s, double tE, double tL){
        dataArray = new Data[1];

        dataArray[0] = new Data(s, tE, tL);
    }

    // randomly select if item is a or b
    public String determineStart(){
        Random r = new Random();
        double AorB = r.nextDouble();

        if(AorB < 0.5){
            return "a";
        }
        else{
            return "b";
        }
    }
}