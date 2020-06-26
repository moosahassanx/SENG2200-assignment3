import java.util.ArrayList;
import java.util.Queue;

public class Item {
    private String uniqueID;
    private Data[] dataArray;
    private InterstorageData[] queueArray;
    private ArrayList interstageDataQueue;
    private int count;

    public Item(String AorB) {
        dataArray = new Data[6];
        queueArray = new InterstorageData[6];
        interstageDataQueue = new ArrayList();
        count = 0;

        getID generateID = new getID();
        uniqueID = generateID.retrieveID() + AorB;
    }

    // used for testing mostly
    public int getArraySize(){
        return count;
    }

    public void addData(String name, double processingTime){
        
        if(dataArray[0] == null){
            dataArray[0] = new Data(name, processingTime);
            count++;
            return;
        }

        if(dataArray[1] == null){
            dataArray[1] = new Data(name, processingTime);
            count++;
            return;
        }

        if(dataArray[2] == null){
            dataArray[2] = new Data(name, processingTime);
            count++;
            return;
        }

        if(dataArray[3] == null){
            dataArray[3] = new Data(name, processingTime);
            count++;
            return;
        }

        if(dataArray[4] == null){
            dataArray[4] = new Data(name, processingTime);
            count++;
            return;
        }

        if(dataArray[5] == null){
            dataArray[5] = new Data(name, processingTime);
            count++;
            return;
        }

        else{
            System.out.println("bruh moment, check ur loop before u get null ptr");
        }
    }

    public Data getData(int i){
        return dataArray[i];
    }

    public String getName(){
        return uniqueID;
    }
}