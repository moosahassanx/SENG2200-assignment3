import java.util.*;

public class Item {
    private int timeEntered;
    private int timeLeft;
    private String uniqueID;
    private Data[] dataArray;
    
    public Item()
    {
        uniqueID = "42t8g70h";
    }

    public void newData(String s, double tE, double tL){
        dataArray = new Data[1];

        dataArray[0] = new Data(s, tE, tL);
    }

    
}